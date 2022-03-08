package net.imperialvalor.titanapi;

import co.aikar.commands.BungeeCommandManager;
import net.imperialvalor.titanapi.command.TitanCommand;
import net.md_5.bungee.api.plugin.Plugin;

public final class TitanAPI extends Plugin {

	@Override
	public void onEnable() {
		// Plugin startup logic
		BungeeCommandManager manager = new BungeeCommandManager(this);
		
		manager.registerCommand(new TitanCommand());
		getLogger().info("Successfully registered TitanAPI administration commands.");
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
