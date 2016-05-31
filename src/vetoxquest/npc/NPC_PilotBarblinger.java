package vetoxquest.npc;

import me.vetoxapi.VetoxAPI;
import me.vetoxapi.mongodb.QuestPlayer;
import me.vetoxapi.objects.VetoxPlayer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import vetoxquest.Main;
import vetoxquest.commands.Command_VetoxQuestAnswer;
import vetoxquest.core.Playing;
import vetoxquest.core.Quest;
import vetoxquest.core.QuestNPC;

/**
 * Created by Jakob on 21.04.2016.
 */
public class NPC_PilotBarblinger extends QuestNPC {


    @Override
    public void onClick(Player p, int tstep) {
        int page = 8;

        Playing playing = Playing.get(p);
        if(playing.getQuest() == null) {
            Main.sendNPC(p, 1, 1, getName(), "Hi du musst die Quest in der Höhle starten!");
            return;
        }


        if(playing.getTalkname().equals(getName())) {
            if(playing.getAnswer() != null) {
                p.sendMessage(Main.prefix + "§cBeantworte zuerst die Frage!");
                playing.setTalkstep(playing.getTalkstep() - 1);
                return;
            }
        }
        

        
        
        switch (tstep) {
            case  1:
                Main.sendNPC(p, 1, page, getName(), "Hi ich bin der Pilot von diesem Schiff! Ich werde dich nach Elbros bringen doch zuerst musst du noch ein paar Fragen beantworten.");
                break;
            case  2:
                Main.sendOwn(p,"Okay passt, schieß los!");
                break;
            case 3:
                Main.sendNPC(p, tstep, page, getName(), "Was kann man auf unserem Server nicht verzaubern?");
                playing.setAnswer("A");

                TextComponent component1 = new TextComponent("Klicke auf die Antwort: ");

                TextComponent a1 = new TextComponent("\n §3A: §7§l[DIAMANTR§STUNG]");
                a1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer A"));

                TextComponent b1 = new TextComponent("\n §3B: §7§l[EISENR§STUNG]");
                b1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer B"));

                TextComponent c1 = new TextComponent("\n §3C: §7§l[WERKZEUGE]");
                c1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer C"));

                TextComponent d1 = new TextComponent("\n §3D: §7§l[BÖGEN]");
                d1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer D"));

                component1.addExtra(a1);
                component1.addExtra(b1);
                component1.addExtra(c1);
                component1.addExtra(d1);
                p.spigot().sendMessage(component1);
                break;
            case 4:
                Main.sendNPC(p, tstep, page, getName(), "Gut gemacht. Noch eine Frage: Wie kann man auf unserem Server §cnicht§f reisen?");
                playing.setAnswer("B");

                TextComponent component2 = new TextComponent("(Klicke wieder auf die Antwort) Mit: ");

                TextComponent a2 = new TextComponent("\n §3A: §7§l[/SPAWN]");
                a2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer A"));

                TextComponent b2 = new TextComponent("\n §3B: §7§l[/WARP]");
                b2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer B"));

                TextComponent c2 = new TextComponent("\n §3C: §7§l[BALLONEN]");
                c2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer C"));

                TextComponent d2 = new TextComponent("\n §3D: §7§l[PFERDEN]");
                d2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer D"));

                component2.addExtra(a2);
                component2.addExtra(b2);
                component2.addExtra(c2);
                component2.addExtra(d2);
                p.spigot().sendMessage(component2);
                break;
            case 5:
                Main.sendNPC(p, tstep, page, getName(), "Wenn ich eine Frage habe und ein Teammitglied online ist. Wie stelle ich dann die Frage?");
                playing.setAnswer("C");

                TextComponent component3 = new TextComponent("Klicke wieder auf die Antwort:");


                TextComponent a3 = new TextComponent("\n §3A: §7§l/support <Frage>");
                a3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer A"));

                TextComponent b3 = new TextComponent("\n §3B: §7§l/? <Frage>");
                b3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer B"));

                TextComponent c3 = new TextComponent("\n §3C: §7§l? <Frage>");
                c3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer C"));

                TextComponent d3 = new TextComponent("\n §3D: §7§l[ICH SCHREIBE SIE EINFACH IN DEN CHAT]");
                d3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer D"));

                component3.addExtra(a3);
                component3.addExtra(b3);
                component3.addExtra(c3);
                component3.addExtra(d3);
                p.spigot().sendMessage(component3);
                break;
            case 6:
                Main.sendNPC(p, tstep, page, getName(), "Was kann man auf dem Server §cnicht §fmachen?");
                playing.setAnswer("A");

                TextComponent component4 = new TextComponent("Klicke auf die Antwort:");


                TextComponent a4 = new TextComponent("\n §3A: §7§l/tpa <Spieler>");
                a4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer A"));

                TextComponent b4 = new TextComponent("\n §3B: §7§l/radio join");
                b4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer B"));

                TextComponent c4 = new TextComponent("\n §3C: §7§l/stats");
                c4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer C"));

                TextComponent d4 = new TextComponent("\n §3D: §7§l/sethome");
                d4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer D"));

                component4.addExtra(a4);
                component4.addExtra(b4);
                component4.addExtra(c4);
                component4.addExtra(d4);
                p.spigot().sendMessage(component4);
                break;
            case 7:
                Main.sendNPC(p, tstep, page, getName(), "Kann man sich auf dem Server Grundstücke kaufen?");
                playing.setAnswer("A");

                TextComponent component5 = new TextComponent("Klicke auf die Antwort:");


                TextComponent a5 = new TextComponent("\n §3A: §7§l[JA]");
                a5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer A"));

                TextComponent b5 = new TextComponent("\n §3B: §7§l[NEIN]");
                b5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer B"));

                component5.addExtra(a5);
                component5.addExtra(b5);
                p.spigot().sendMessage(component5);
                break;
            case 8:
                Main.sendNPC(p, tstep, page, getName(), "Du hast alle Fragen beantwortet! Du wirst nun nach Elbros teleportiert...");
                Quest q = Quest.map.get("Der Anfang");
                q.onEnd(p);
        } 




    }

    public static void questionConfirm(Player p) {
        Playing playing = Playing.get(p);
        if(playing.getAnswer() == null) return;
        if (playing.getAnswer().equals(Command_VetoxQuestAnswer.answer.get(p.getUniqueId()))) {

            playing.setAnswer(null);
            playing.setTalkstep(playing.getTalkstep() + 1);
            QuestNPC questNPC = QuestNPC.map.get("Pilot Berblinger");
            p.sendMessage(Main.prefix + "§aFrage geschafft!");
            questNPC.onClick(p, playing.getTalkstep());



        } else {
            p.sendMessage(Main.prefix + "§cDas war die falsche Antwort, du musst die Fragen nun erneut machen!");
            playing.setAnswer(null);
            playing.setTalkstep(0);
            playing.setTalkname("Pilot Berblinger");
        }
    }





}
