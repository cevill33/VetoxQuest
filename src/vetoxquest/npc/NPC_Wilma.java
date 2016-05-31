package vetoxquest.npc;

import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.core.QuestNPC;

/**
 * Created by Jakob on 19.04.2016.
 */
public class NPC_Wilma extends QuestNPC{


    @Override
    public void onClick(Player p, int tstep) {
        if (tstep == 1)
        Main.sendNPC(p, 1, 2, getName(), "In Elbros kann man keine Diasachen verzaubern, dafür kann man aber den Rest bis zu einer Verzauberungsstufe von 10 verbessern.");
        if(tstep == 2)
            Main.sendNPC(p, 2, 2, getName(), "Übrigens verzaubert man dort mit Feuerbällen(Diese muss man mit einem speziellen Rezept herstellen)");

    }
}
