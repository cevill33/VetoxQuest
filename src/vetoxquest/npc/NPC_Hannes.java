package vetoxquest.npc;

import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.core.QuestNPC;

/**
 * Created by Jakob on 18.04.2016.
 */
public class NPC_Hannes extends QuestNPC {

    @Override
    public void onClick(Player p, int tstep) {
        Main.sendNPC(p, 1, 1, getName(), "In der Hauptstadt gibt es einen Markt. Dort kann man seine erfarmten Sachen verkaufen");
    }
}
