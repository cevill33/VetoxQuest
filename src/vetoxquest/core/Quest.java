package vetoxquest.core;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import org.bukkit.scoreboard.*;
import vetoxquest.Main;
import vetoxquest.api.Title;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jakob on 16.04.2016.
 */
public abstract class Quest {

    public static HashMap<UUID, Playing> playing = new HashMap<>();
    public static HashMap<String, Quest> map = new HashMap<>();

    private String name;
    private List<String> description;
    private Mode difficulty;
    private int minimumpoints;
    private List<Story> completedstorys;
    private int minstorypoint;
    private HashMap<String, String> questnpcmethod;


    public void register(String name, List<String> description, Mode difficulty, int minimumpoints, List<Story> completedstorys, int minstorypoint, HashMap<String, String> questnpcmethod, List<Step> steps) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.minimumpoints = minimumpoints;
        this.completedstorys = completedstorys;
        this.minstorypoint = minstorypoint;
        this.questnpcmethod = questnpcmethod;
        map.put(name, this);
    }
    public static void setScoreboard(Player p){
        Scoreboard sb = Bukkit.getServer().getScoreboardManager().getMainScoreboard();

        //Objective obj = sb.getObjective("aaa");
        //Objective obj = sb.getObjective("aaa");
        //if(obj != null) {
        //    obj.unregister();
        //}
        Objective obj = sb.registerNewObjective("aaa", "aaa");

    }

    public static void sendScoreboard(Player p, String title, List<String> text){

        //Objective obj = sb.getObjective("aaa");
        //Objective obj = sb.getObjective("aaa");
        //if(obj != null) {
        //    obj.unregister();
        //}
        Objective obj = p.getScoreboard().getObjective("aaa");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(title);

        Score order = obj.getScore("§aAuftrag: ");
        order.setScore(text.size() + 1);

        int i = text.size() + 1;
        for(String s : text) {
            i--;
            Score a1 = obj.getScore(s);
            a1.setScore(i);
        }
    }

    public abstract void informManager();

    public abstract void onEnd(Player p);

    public abstract void start(Player p);

    public String getName() {
        return name;
    }

    public List<String> getDescription() {
        return description;
    }

    public Mode getDifficulty() {
        return difficulty;
    }

    public int getMinimumpoints() {
        return minimumpoints;
    }

    public List<Story> getCompletedstorys() {
        return completedstorys;
    }

    public int getMinstorypoint() {
        return minstorypoint;
    }

    public HashMap<String, String> getQuestnpcmethod() {
        return questnpcmethod;
    }


    public static void onQuestStart(Player p, String name) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.main, new Runnable() {
			
			@Override
			public void run() {
				if(p == null) return;
		    	Title t = new Title("§aNeue Quest", "§7Name:§f " + name);
		        t.send(p);
		        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
		        Playing playing = Quest.playing.get(p.getUniqueId());
		        playing.setQuest(name);
		        playing.setPlaying(true);
			}
		},10);

    }

    public static void newOrder(Player p, List<String> order) {
    	Bukkit.getScheduler().scheduleSyncDelayedTask(Main.main, new Runnable() {
			
			@Override
			public void run() {
		        p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);

                String sorder = "";
                for(String t : order) {
                    sorder = sorder + t + " ";
                }

                p.sendMessage("");
		        p.sendMessage("§e§nNeuer Auftrag: §f" + sorder);
                sendScoreboard(p, "§3Quest:", order);
                Quest.playing.get(p.getUniqueId()).setOrder(order);
				
			}
		},22*2);

    }
}

