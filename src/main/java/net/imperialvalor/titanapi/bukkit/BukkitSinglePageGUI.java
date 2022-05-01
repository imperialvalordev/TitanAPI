package net.imperialvalor.titanapi.bukkit;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import lombok.Getter;
import lombok.NonNull;

/**
 * 
 * @author Whitescan
 *
 */
public abstract class BukkitSinglePageGUI extends BukkitGUI {

	@Getter
	private Inventory page;

	public BukkitSinglePageGUI(@NonNull Plugin plugin, @NonNull String title) {
		super(plugin, title);
	}

	protected void calculatePage(List<ItemStack> items) {

		Inventory page = Bukkit.createInventory(null, 54, getTitle());

		int slot = 0;

		for (ItemStack item : items) {
			page.setItem(slot++, item);
		}

		this.page = page;

	}

	@Override
	public void open(Player player) {
		player.openInventory(getPage());
	}

}
