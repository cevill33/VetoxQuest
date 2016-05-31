package vetoxquest.npc;

import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.core.QuestNPC;

/**
 * Created by Jakob on 18.04.2016.
 */
public class NPC_Yakuru extends QuestNPC {

    @Override
    public void onClick(Player p, int tstep) {
        Main.sendNPC(p, 1, 1, getName(), "Ich sehe ,dass du bald in einen magischen Ort reisen wirst. Dort kannst du mächtige Zauber mit hilfe eines Lohen-Stabes erlernen.");
    }

}
