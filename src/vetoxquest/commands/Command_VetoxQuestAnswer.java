package vetoxquest.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import vetoxquest.core.Playing;
import vetoxquest.npc.NPC_PilotBarblinger;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Jakob on 21.04.2016.
 */
public class Command_VetoxQuestAnswer implements CommandExecutor{

    public static HashMap<UUID, String> answer = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {

        Player p = (Player) cs;

        if(args.length == 0) {
            return true;
        }

        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("confirm")) {
                Playing playing = Playing.get(p);
                System.out.println(playing.getTalkname());
                switch (playing.getTalkname()) {

                    case "Pilot Berblinger": NPC_PilotBarblinger.questionConfirm(p); break;

                }



                return true;
            }

            answer.put(p.getUniqueId(), args[0]);
            p.sendMessage(vetoxquest.Main.prefix + "§eDu hast für §3" + args[0] + "§e gestimmt!");
            TextComponent text = new TextComponent(vetoxquest.Main.prefix + "§eBestätigung: ");
            TextComponent a1 = new TextComponent(" §f§lKLICK MICH");
            a1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/vetoxquestanswer confirm"));
            text.addExtra(a1);
            p.spigot().sendMessage(text);
            return true;
        }








        return false;
    }
}
