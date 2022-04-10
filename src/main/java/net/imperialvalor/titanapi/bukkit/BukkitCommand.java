package net.imperialvalor.titanapi.bukkit;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.imperialvalor.titanapi.share.MessageService;

/**
 *
 * @author Whitescan
 *
 */
@AllArgsConstructor
public abstract class BukkitCommand implements CommandExecutor, TabExecutor {

	@Getter
	private final String permission;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (hasPermission(sender)) {
			executeCommand(sender, label, args);

		} else {
			sender.spigot().sendMessage(MessageService.NO_PERMISSION_COMMAND);
		}

		return true;

	}

	protected abstract void executeCommand(CommandSender sender, String label, String[] args);

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player && sender.hasPermission(getPermission())) {
			return tabComplete(sender, label, args);
		}

		return new ArrayList<>();

	}

	protected abstract List<String> tabComplete(CommandSender sender, String label, String[] args);

	protected boolean hasPermission(CommandSender sender) {
		return getPermission() == null || sender.hasPermission(getPermission());
	}

}
