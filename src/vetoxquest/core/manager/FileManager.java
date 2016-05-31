package vetoxquest.core.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class FileManager {
	public static HashMap<Integer, List<String>> npcmsg = new HashMap<>();
	
	
	public static void crateFile(String filename){
		File file = new File("plugins/VetoxQuest/" + filename + ".yml");
		File ordner  = new File("plugins/VetoxQuest");
		if(!ordner.exists()){
			ordner.mkdir();
		}
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void saveFile(File file, FileConfiguration cfg){
		try {
			cfg.save(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		loadMessages();
	}
	

	public static void addText(Player p, int id, String msg) {
		
		File file = new File("plugins/VetoxQuest/QuestMsg.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = cfg.getStringList("" + id);
		if(list == null) {
			list = new ArrayList<>();
		}
		
		list.add(msg);
		cfg.set("" + id, list);
		saveFile(file, cfg);
	}
	
	public static List<String> getText(int id) {
		File file = new File("plugins/VetoxQuest/QuestMsg.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		return cfg.getStringList("" + id);
	}
	
	
	public static void removeText(Player p, int id, int textnumber) {

		textnumber--;
		File file = new File("plugins/VetoxQuest/QuestMsg.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = cfg.getStringList("" + id);
		if(list == null) {
			return;
		}
		if(list.get(textnumber) != null){
			String s = list.get(textnumber);
			list.remove(s);
			cfg.set("" + id, list);
		}
		saveFile(file, cfg);
	}
	public static void setText(Player p, int id, int textnumber, String msg) {
		
		File file = new File("plugins/VetoxQuest/QuestMsg.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		List<String> list = cfg.getStringList("" + id);
		if(list == null) {
			return;
		}
		if(list.size() >= textnumber) {
			list.set(textnumber, msg);
			cfg.set("" + id, list);
		}else{
			list.add(msg);
			cfg.set("" + id, list);
			saveFile(file, cfg);
		}
		saveFile(file, cfg);
	}
	
	public static void loadMessages() {
		npcmsg = new HashMap<>();
		File file = new File("plugins/VetoxQuest/QuestMsg.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		for(String keys : cfg.getKeys(true)) {
			npcmsg.put(Integer.parseInt(keys), FileManager.getText(Integer.parseInt(keys)));
		}
	}
	
	
	
	
	
}
