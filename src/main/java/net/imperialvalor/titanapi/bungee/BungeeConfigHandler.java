package net.imperialvalor.titanapi.bungee;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Logger;

import net.imperialvalor.titanapi.share.config.AbstractConfigHandler;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

/**
 *
 * @author Whitescan
 *
 */
public abstract class BungeeConfigHandler extends AbstractConfigHandler {

	protected Plugin plugin;

	protected Configuration config;

	protected Logger logger;

	public BungeeConfigHandler(Plugin plugin, Logger logger, File configFile) {
		super(configFile);
		this.plugin = plugin;
		this.logger = logger;
		load();
	}

	@Override
	public void load() {

		if (!configFile.getParentFile().exists()) {
			logger.warning("Config folder " + configFile.getParentFile().getAbsolutePath()
					+ " does not exist, creating it... This can be ignored if you are setting this up.");
			configFile.getParentFile().mkdirs();
		}

		if (!configFile.exists()) {
			logger.warning("Config file " + configFile.getAbsolutePath()
					+ " does not exist, creating default... This can be ignored if you are setting this up.");
			try {
				InputStream in = plugin.getResourceAsStream(configFile.getName());
				Files.copy(in, configFile.toPath());
			} catch (IOException e) {
				logger.warning("Failed to copy default file " + configFile.getAbsolutePath()
						+ " to datafolder. Make sure the file is not in use (system lock) before reporting this as an error!");
				e.printStackTrace();
			}
		}

		try {
			this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
		} catch (IOException e) {
			logger.severe("Failed to reload config file: " + configFile.getAbsolutePath());
			e.printStackTrace();
		}

	}

	@Override
	public void saveConfig() {
		try {
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, configFile);
		} catch (IOException e) {
			logger.severe("Failed to save config file: " + configFile.getAbsolutePath());
			e.printStackTrace();
		}
	}

	@Override
	public void reload() {

		try {
			this.config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
		} catch (IOException e) {
			logger.severe("Failed to reload config file: " + configFile.getAbsolutePath());
			e.printStackTrace();
		}

		read();

	}

}
