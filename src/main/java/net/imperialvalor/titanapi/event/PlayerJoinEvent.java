package net.imperialvalor.titanapi.event;

import net.imperialvalor.titanapi.TitanAPI;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class PlayerJoinEvent extends Plugin implements Listener {
	private TitanAPI plugin;
	public PlayerJoinEvent(TitanAPI titanAPI) {
		this.plugin = titanAPI;
	}

	@EventHandler
	public void onPlayerConnect(LoginEvent event) {
		plugin.getLogger().info(event.getConnection().getUniqueId() + " has logged in");
	}
}
