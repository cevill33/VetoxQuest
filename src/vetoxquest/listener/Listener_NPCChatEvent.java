package vetoxquest.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.citizensnpcs.api.ai.speech.event.NPCSpeechEvent;

/**
 * Created by Jakob on 23.04.2016.
 */
public class Listener_NPCChatEvent implements Listener{

    @EventHandler
    public void onChat(NPCSpeechEvent e) {
    	e.setCancelled(true);
    }
}
