package net.imperialvalor.titanapi;

import co.aikar.commands.BungeeCommandManager;
import net.imperialvalor.titanapi.command.TitanCommand;
import net.imperialvalor.titanapi.event.PlayerJoinEvent;
import net.md_5.bungee.api.plugin.Plugin;

public final class TitanAPI extends Plugin {

	@Override
	public void onEnable() {
		// Plugin startup logic

		// Register Commands
		BungeeCommandManager manager = new BungeeCommandManager(this);

		manager.registerCommand(new TitanCommand());
		getLogger().info("Successfully registered TitanAPI administration commands.");

		// Register Events
		getProxy().getPluginManager().registerListener(this, new PlayerJoinEvent(this));
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
