package net.imperialvalor.titanapi.bungee;

import net.imperialvalor.titanapi.TitanAPI;
import net.imperialvalor.titanapi.share.MessageService;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

/**
 *
 * @author Whitescan
 *
 */
public class TitanAPIBungeeImpl extends Plugin implements TitanAPI {
	// Setup

	private static TitanAPIBungeeImpl instance;

	// Runtime

	private boolean locked = false;

	@Override
	public void onEnable() {
		TitanAPIBungeeImpl.instance = this;
		getProxy().getPluginManager().registerListener(this, new BungeeConnectionListener(this));
		getLogger().info("Enabled!");
	}

	@Override
	public void onDisable() {
		getLogger().info("Disabled!");
	}

	@Override
	public boolean isLocked() {
		return locked;
	}

	@Override
	public void setLocked(boolean locked) {
		this.locked = locked;

		if (locked) {
			for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
				player.disconnect(MessageService.LOCKED);
			}
		}

	}

	public static TitanAPIBungeeImpl getInstance() {
		return instance;
	}
}
