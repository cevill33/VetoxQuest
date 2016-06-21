package vetoxquest;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import vetoxquest.commands.Command_VQ;
import vetoxquest.commands.Command_VetoxQuestAnswer;
import vetoxquest.core.Playing;
import vetoxquest.core.Quest;
import vetoxquest.core.manager.FileManager;
import vetoxquest.core.manager.ManagerQuest;
import vetoxquest.core.manager.ManagerQuestNPC;
import vetoxquest.listener.Listener_NPCChatEvent;
import vetoxquest.listener.Listener_NPCClickEvent;
import vetoxquest.listener.Listener_NPCSelect;
import vetoxquest.listener.Listener_PlayerJoinEvent;

/**
 * Created by Jakob on 15.04.2016.
 */
public class Main extends JavaPlugin{

    public static final String prefix = "§e[§3Quest§e] ";
    public static Plugin main; //Das ist ein Test

    @Override
    public void onEnable() {
        this.main = this;
        PluginManager pM = Bukkit.getServer().getPluginManager();
        pM.registerEvents(new Listener_NPCClickEvent(), this);
        pM.registerEvents(new Listener_PlayerJoinEvent(), this);
        pM.registerEvents(new Listener_NPCChatEvent(), this);
        pM.registerEvents(new Listener_NPCSelect(), this);
        getCommand("vetoxquestanswer").setExecutor(new Command_VetoxQuestAnswer());
        getCommand("vq").setExecutor(new Command_VQ());

        ManagerQuestNPC.registerNPC();
        ManagerQuest.register();
        loadPlaying();
        FileManager.crateFile("QuestMsg");
        FileManager.loadMessages();
        
        	

        
        


       













    }

    public static String getNPCPrefix(int page, int last, String name) {
        return "\n \n \n§8" + page + "/" + last + " §9" + name + " §8§l§: §f";
    }

    public static void sendOwn(Player p, String text) {
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage(p.getDisplayName() + "§8§l: §f" + text);
    }

    public static void sendNPC(Player p, int page, int steps, String name, String text) {
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("§8" + page + "/" + steps + " §9" + name + " §8§l§: §f" + text);
    }


    private static void loadPlaying() {
        for(Player all : Bukkit.getOnlinePlayers()) {
            Playing playing = new Playing(false, null);
            Quest.playing.put(all.getUniqueId(), playing);
        }
    }


}
