package vetoxquest.quest;

import me.vetoxapi.VetoxAPI;
import me.vetoxapi.mongodb.DBVetoxPlayer;
import me.vetoxapi.mongodb.QuestPlayer;
import me.vetoxapi.objects.VetoxPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.api.Title;
import vetoxquest.core.Mode;
import vetoxquest.core.Playing;
import vetoxquest.core.Quest;
import vetoxquest.core.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jakob on 17.04.2016.
 */
public class Quest_DerAnfang extends Quest {

    @Override
    public void start(Player p) {
        Quest.onQuestStart(p, "Der Anfang");
        Playing.get(p).setOrder("Rede mit den Dorfbewohnern und lies dir alle Schilder durch, danach rede mit dem Piloten des Zeppelins.");
    }

    @Override
    public void informManager() {
        List<Step> steps = new ArrayList<>();
        steps.add(new Step1());


        register("Der Anfang", null, Mode.EASY, 0, null, 0, null, steps);
    }

    @Override
    public void onEnd(Player p) {
        Title t = new Title("§aQuest Erledigt");
        t.send(p);
        p.playSound(p.getLocation(), Sound.CAT_PURR, 1, 1);

        new QuestPlayer(p.getUniqueId().toString()).create(p.getName());
        p.teleport(VetoxAPI.spawn);
        VetoxPlayer vP = VetoxPlayer.stats.get(p.getUniqueId());
        new DBVetoxPlayer(p.getUniqueId().toString()).setObject("maintutorial", 1);
        if(vP.getLvl() < 2) {
            vP.setLvl(2);
            vP.setExp(1);
            p.setLevel(2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.main, new Runnable() {
                @Override
                public void run() {
                    VetoxPlayer vP = VetoxPlayer.stats.get(p.getUniqueId());
                    if(vP.getLvl() == 2) {
                        p.sendMessage("");
                        p.sendMessage("§a§k#######################################");
                        p.sendMessage("");
                        p.sendMessage("  §6Levelaufstieg: §7Du bist nun Lvl: §5" + vP.getLvl());
                        p.sendMessage("");
                        p.sendMessage("§a§k#######################################");
                        p.sendMessage("");
                        p.setLevel(2);
                    }
                }
            },20*6);
        }





    }

}

class Step1 extends Step {

    @Override
    public void run(Player p) {
        p.sendMessage("Hi ich bin step 1");
    }
}
