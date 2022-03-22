package net.imperialvalor.titanapi.share.config;

import java.io.File;

/**
 *
 * @author Whitescan
 *
 */
public abstract class AbstractConfigHandler {

	protected File configFile;

	public AbstractConfigHandler(File configFile) {
		this.configFile = configFile;
	}

	public abstract void load();

	public abstract void saveConfig();

	public abstract void reload();

	public abstract void read();

}
