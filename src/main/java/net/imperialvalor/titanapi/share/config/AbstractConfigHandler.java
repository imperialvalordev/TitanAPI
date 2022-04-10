package net.imperialvalor.titanapi.share.config;

import java.io.File;

import lombok.AllArgsConstructor;

/**
 *
 * @author Whitescan
 *
 */
@AllArgsConstructor
public abstract class AbstractConfigHandler {

	protected File configFile;

	public abstract void load();

	public abstract void saveConfig();

	public abstract void reload();

	public abstract void read();

}
