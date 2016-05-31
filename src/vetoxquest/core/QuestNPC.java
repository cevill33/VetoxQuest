package vetoxquest.core;

import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by Jakob on 16.04.2016.
 */
public abstract class QuestNPC {

    public static HashMap<String, QuestNPC> map = new HashMap<>();
    private String name;

    public void register(String name) {
        this.name = name;
        map.put(name, this);
    }

    public abstract void onClick(Player p, int tstep);

    public String getName() {
        return name;
    }


}

