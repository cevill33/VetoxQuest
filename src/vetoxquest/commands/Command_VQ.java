package vetoxquest.commands;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import vetoxquest.Main;
import vetoxquest.core.manager.FileManager;
import vetoxquest.listener.Listener_NPCSelect;

public class Command_VQ implements CommandExecutor{

	@Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
		
		//Check:
		Player p = (Player)cs;
		File file = new File("plugins/VetoxQuest/QuestMsg.yml");
		@SuppressWarnings("unused")
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		if(!p.hasPermission("vetoxquest.text")) {
			p.sendMessage(Main.prefix + "§cDu darfst diesen Befehl nicht nutzen!");
		}
		
		
		
		
		//Command: LIST
		if(args.length == 0) {
			sendSyntax(p);
			return false;
		}
		if(args[0].equalsIgnoreCase("list")) {
			if(!Listener_NPCSelect.npcid.containsKey(p.getUniqueId())) {
				p.sendMessage(Main.prefix + "§cDu musst einen NPC auswählen!");
				return true;
			}
			p.sendMessage(Main.prefix + "§7Nachrichten von diesem NPC: ");
			for(String text : FileManager.getText(Listener_NPCSelect.npcid.get(p.getUniqueId()))) {
				p.sendMessage("§e- §f" + text);
			}
			return false;
		}
		
		
		if(args.length <=  1){
			sendSyntax(p);
			return false;
		}
		
		
		//Command: ADD
		if(args[0].equalsIgnoreCase("add")){
			String message = "";
			for(int i = 1; i < args.length; i++){
				message = message + args[i] + " ";
			}
			
			HashMap<UUID, Integer> map = Listener_NPCSelect.npcid;
			if(!map.containsKey(p.getUniqueId())) {
				p.sendMessage(Main.prefix + "§cDu musst zuerst einen NPC auswählen!");
				return false;
			}
			
			FileManager.addText(p, map.get(p.getUniqueId()), message);
			p.sendMessage(Main.prefix + "§7Du hast eine Nachricht hinzugefügt!");
			p.sendMessage(Main.prefix + "§7Nachricht: §f" + message);
			return false;
		}
		
		
		//Command: REMOVE
		if(args[0].equalsIgnoreCase("remove")){
			
			HashMap<UUID, Integer> map = Listener_NPCSelect.npcid;
			if(!map.containsKey(p.getUniqueId())) {
				p.sendMessage(Main.prefix + "§cDu musst zuerst einen NPC auswählen!");
				return false;
			}
			FileManager.removeText(p, map.get(p.getUniqueId()), Integer.parseInt(args[1]));
			p.sendMessage(Main.prefix + "§7Du hast die Nachricht §a" + Integer.parseInt(args[1]) + " §7entfernt!");
			return false;
		}
		
		
		//Command: SET
		if(args[0].equalsIgnoreCase("set")){
			if(args.length >= 2){
				String msg = "";
				for(int i = 2; i < args.length; i++){
					msg = msg + args[i] + " ";
				}
				HashMap<UUID, Integer> map = Listener_NPCSelect.npcid;
				if(!map.containsKey(p.getUniqueId())) {
					p.sendMessage(Main.prefix + "§cDu musst zuerst einen NPC auswühlen!");
					return false;
				}
				FileManager.setText(p, map.get(p.getUniqueId()), Integer.parseInt(args[1]), msg);
				p.sendMessage(Main.prefix + "§7Du hast die Nachricht §c" + Integer.parseInt(args[1]) + " §7auf §a" + msg + " §7gesetzt!");
				return false;
			}else{
				sendSyntax(p);
			}
		}
		
		
		
		return false;
	}
	
	
	private static void sendSyntax(Player p) {
		p.sendMessage(Main.prefix + " §f/vq add <Text>!");
		p.sendMessage(Main.prefix + " §f/vq set <Nummer> <Text>");
		p.sendMessage(Main.prefix + " §f/vq remove <Nummer>");
		p.sendMessage(Main.prefix + " §f/vq list");
		
		
	}

}
