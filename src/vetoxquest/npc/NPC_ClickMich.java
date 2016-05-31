package vetoxquest.npc;

import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.core.Quest;
import vetoxquest.core.QuestNPC;

import java.util.Arrays;

/**
 * Created by Jakob on 17.04.2016.
 */
public class NPC_ClickMich extends QuestNPC{

    @Override
    public void onClick(Player p, int tstep) {

        int steps = 6;
        String name = "Max";


        switch (tstep) {
            case 1:
                p.sendMessage(Main.getNPCPrefix(tstep, steps, name) + "Hi ich bin " + name + ". §c(Klicke bitte nochmal auf mich!)");
                break;
            case 2:
                p.sendMessage(Main.getNPCPrefix(tstep, steps, name) +
                        "Du bist hier auf einer fast unbewohnten Insel gestrandet. Ich denke dass du nach Erfolg strebst doch hier wirst du ihn kaum finden. §c(Klick nochmal)");
                break;
            case 3:
                Main.sendOwn(p, "Ah okay! Und was soll ich jetzt machen?");
                break;
            case 4:
                p.sendMessage(Main.getNPCPrefix(tstep, steps, name) + "Es gibt an der Spitze der Insel einen Zeppelin, der kann dich nach Elbros, einer Stadt für aufstrebende Menschen bringen.");
                break;
            case 5:
                Main.sendOwn(p, "Das hört sich toll an! Und ist die Reise umsonnst?");
                break;
            case 6:
                p.sendMessage(Main.getNPCPrefix(tstep, steps, name) +
                        "Ja, nur wird der Pilot Fragen über die Stadt Elbros stellen. Deswegen rede mit den Bewohnern dieser Insel, denn die können dir vieles über Elbros sagen.");
                Quest q = Quest.map.get("Der Anfang");
                q.start(p);
                Quest.newOrder(p, Arrays.asList("Rede mit den Drofbewohnen", "und lies dir alle", "Schilder durch. Danach", "rede mit dem Piloten vom", "Luftschiff!"));

                break;
            default:
                Quest.playing.get(p.getUniqueId()).setTalkstep(0);


        }







    }
}
