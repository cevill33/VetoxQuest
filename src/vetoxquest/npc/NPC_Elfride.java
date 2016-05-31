package vetoxquest.npc;

import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.core.QuestNPC;

/**
 * Created by Jakob on 19.04.2016.
 */
public class NPC_Elfride extends QuestNPC{


    @Override
    public void onClick(Player p, int tstep) {
        Main.sendNPC(p, 1, 1, getName(), "Ich bin schon alt, würde ich doch nur in Elbros leben könnte ich mit /ride auf der Straße umsonnst reiten.");
    }
}
