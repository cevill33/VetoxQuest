package vetoxquest.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import vetoxquest.core.Playing;
import vetoxquest.core.Quest;

/**
 * Created by Jakob on 17.04.2016.
 */
public class Listener_PlayerJoinEvent implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        p.sendMessage("Quest du bist gejoint!");

        Playing playing = new Playing(false, null);
        Quest.playing.put(p.getUniqueId(), playing);






    }




}
