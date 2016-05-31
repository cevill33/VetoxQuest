package vetoxquest.npc;

import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.core.QuestNPC;

/**
 * Created by Jakob on 18.04.2016.
 */
public class NPC_Swen extends QuestNPC {


    @Override
    public void onClick(Player p, int tstep) {
        switch (tstep) {
            case 1:
                p.sendMessage(Main.getNPCPrefix(tstep, 3, getName()) + "Hi ich bin Swen. Als ich jung war habe ich auch in der nähe von Elbros als Minenforscher gearbeitet.");
                break;
            case 2:
                Main.sendOwn(p, "Und wieso arbeitest du nicht mehr dort?");
                break;
            case 3:
                Main.sendNPC(p, tstep, 3, getName(), "Zu dieser Zeit war ich noch jung und konnte mich bei einer Gefahr verteidigen." +
                        " Jetzt farme ich nur noch hier, es gibt zwar nicht so viele Erze, aber dafür gibt es hier auch keine gefährlichen Mobs sowie Spieler.");
                break;
        }

    }


}
