package vetoxquest.listener;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import vetoxquest.Main;
import vetoxquest.core.Playing;
import vetoxquest.core.Quest;
import vetoxquest.core.QuestNPC;
import vetoxquest.core.manager.FileManager;

/**
 * Created by Jakob on 17.04.2016.
 */
public class Listener_NPCClickEvent implements Listener {

	public static List<String> antispam = new ArrayList<>();
    
	private static boolean onClick(Player p, NPC npc) {
        
		//Initialisierung:
		String name = npc.getName();
        int id = npc.getId();
        Playing playing = Quest.playing.get(p.getUniqueId());
        
        //Talkname set on Clicker if new one (+Talkstep = 0):
        if(playing.getTalkname() != name) {
            playing.setTalkname(name);
            playing.setTalkstep(0);
        }
        	
        //Create QuestNPC:
        QuestNPC questNPC = QuestNPC.map.get(name);
        
        //Check if not NULL:
        if(questNPC != null) {
            if(playing.getQuest() != null) {}
            
            //Spamschutz:
            if(!antispam.contains(p.getName())){
            	antispam.add(p.getName());
            	Bukkit.getScheduler().runTaskLater(Main.main, new Runnable() {
            	@Override
    			public void run() {
    			antispam.remove(p.getName());
    			} }, 20); }else{
            	p.sendMessage(Main.prefix + "§cIch denke nicht, dass du so schnell lesen kannst!");
            	return false;}
            
            //Set TalkStep higher & execute QuestClick:
            playing.setTalkstep(playing.getTalkstep() + 1);
            questNPC.onClick(p, playing.getTalkstep());
            return true;
            
            
        }else {
        	//If the NPC is not an Object:            
            //Set TalkStep higher & send Normal Message:
        	List<String>  list = FileManager.getText(id);
        	if(list.isEmpty()) {
        		return false;
        	}
        	
            //Spamschutz:
            if(!antispam.contains(p.getName())){
            	antispam.add(p.getName());
            	Bukkit.getScheduler().runTaskLater(Main.main, new Runnable() {
            	@Override
    			public void run() {
    			antispam.remove(p.getName());
    			} }, 20); }else{
            	p.sendMessage(Main.prefix + "§cIch denke nicht, dass du so schnell lesen kannst!");
            	return false;
            }
        	playing.setTalkstep(playing.getTalkstep() + 1);
        	if(list.size() < playing.getTalkstep()){
        		playing.setTalkstep(1);
        	}
        	String text = list.get(playing.getTalkstep()-1).replace('&', '§');
        	Main.sendNPC(p, playing.getTalkstep(), list.size(), name, text);
        }
        return false;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onRightClick(NPCRightClickEvent e) {
        onClick(e.getClicker(), e.getNPC());
    }
}
