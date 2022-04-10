package net.imperialvalor.titanapi.bungee;

import lombok.AllArgsConstructor;
import net.imperialvalor.titanapi.share.MessageService;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

/**
 *
 * @author Whitescan
 *
 */
@AllArgsConstructor
public class BungeeConnectionListener implements Listener {

	private final TitanAPIBungeeImpl api;

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onConnect(PreLoginEvent e) {

		e.registerIntent(api);

		if (api.isLocked()) {
			api.getLogger().warning("Denied access to network for: " + e.getConnection().getName() + " - Network is locked!");
			e.setCancelReason(MessageService.LOCKED);
			e.setCancelled(true);
		}

		e.completeIntent(api);

	}

}
