package net.imperialvalor.titanapi.bukkit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import lombok.AllArgsConstructor;
import net.imperialvalor.titanapi.share.MessageService;

/**
 *
 * @author Whitescan
 *
 */
@AllArgsConstructor
public class BukkitConnectionListener implements Listener {

	private final TitanAPIBukkitImpl api;

	@EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
	public void onPreLogin(AsyncPlayerPreLoginEvent e) {
		if (api.isLocked()) {
			api.getLogger().warning("Denied access to network for: " + e.getName() + " - Network is locked!");
			e.disallow(Result.KICK_OTHER, MessageService.LOCKED.getText());
		}

	}

}
