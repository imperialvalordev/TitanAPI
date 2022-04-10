package net.imperialvalor.titanapi.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import lombok.Getter;
import net.imperialvalor.titanapi.TitanAPI;
import net.imperialvalor.titanapi.share.MessageService;

/**
 *
 * @author Whitescan
 *
 */
public class TitanAPIBukkitImpl extends JavaPlugin implements TitanAPI {

	// Setup

	@Getter
	private static TitanAPIBukkitImpl instance;

	// Runtime

	private boolean locked = false;

	@Override
	public void onEnable() {
		TitanAPIBukkitImpl.instance = this;
		getServer().getPluginManager().registerEvents(new BukkitConnectionListener(this), this);
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
			for (Player player : Bukkit.getOnlinePlayers()) {
				player.kickPlayer(MessageService.LOCKED.getText());
			}
		}

	}

}
