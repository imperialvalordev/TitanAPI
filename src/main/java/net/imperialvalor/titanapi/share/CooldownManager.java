package net.imperialvalor.titanapi.share;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/**
 *
 * @author Whitescan
 *
 */
public class CooldownManager {

	private final Map<UUID, Long> cooldowns = new HashMap<>();

	public void setCooldown(UUID uniqueId, long seconds) {

		cooldowns.put(uniqueId, seconds);

		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				cooldowns.remove(uniqueId);
			}

		}, seconds * 1000);

	}

	public long getCooldown(UUID uniqueId) {
		return cooldowns.getOrDefault(uniqueId, (long) 0);
	}

	public boolean hasCooldown(UUID uniqueId) {
		return getCooldown(uniqueId) > 0;
	}

}
