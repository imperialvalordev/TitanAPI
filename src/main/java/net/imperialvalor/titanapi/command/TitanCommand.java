package net.imperialvalor.titanapi.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Dependency;
import co.aikar.commands.annotation.Subcommand;
import net.imperialvalor.titanapi.TitanAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;

@CommandAlias("titanapi|titan")
@CommandPermission("titanapi.use")
public class TitanCommand extends BaseCommand {
	@Dependency
	private TitanAPI plugin;

	@Subcommand("check")
	public void checkAPI(CommandSender sender) {
		sender.sendMessage(new ComponentBuilder("TitanAPI is reporting no issues.").color(ChatColor.GREEN).create());
	}
}
