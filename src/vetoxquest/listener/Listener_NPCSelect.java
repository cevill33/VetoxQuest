package vetoxquest.listener;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import net.citizensnpcs.api.event.NPCSelectEvent;

public class Listener_NPCSelect implements Listener{

	public static HashMap<UUID, Integer> npcid = new HashMap<>();
	
	
	@EventHandler()
	public void onSelect(NPCSelectEvent e){
		Player p = (Player) e.getSelector();
		npcid.put(p.getUniqueId(), e.getNPC().getId());
	}
}
