package net.imperialvalor.titanapi.share;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 
 * @author Whitescan
 *
 */
public class CooldownManager {

	private final Map<UUID, Long> cooldowns = new HashMap<>();

	public void setCooldown(UUID uniqueId, long time) {

		if (time < 1) {
			cooldowns.remove(uniqueId);
		} else {
			cooldowns.put(uniqueId, time);
		}

	}

	public long getCooldown(UUID uniqueId) {
		return cooldowns.getOrDefault(uniqueId, (long) 0);
	}

}
