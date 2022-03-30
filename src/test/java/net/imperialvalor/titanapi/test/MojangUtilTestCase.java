package net.imperialvalor.titanapi.test;

import static org.junit.Assert.assertEquals;

import java.util.TreeMap;
import java.util.UUID;

import org.junit.Test;

import net.imperialvalor.titanapi.share.util.MojangUtil;

/**
 * 
 * @author Whitescan
 *
 */
public class MojangUtilTestCase {

	public static final UUID UNIQUEID = UUID.fromString("6b3b816a-e1c1-4f47-9819-33e0a92cf416");
	public static final String USERNAME = "Orange_Nestea";
	public static final int CHANGES = 10;

	@Test
	public void test() {

		UUID resultId = MojangUtil.getUniqueId(USERNAME);
		assertEquals(UNIQUEID, resultId);

		String resultUsername = MojangUtil.getLatestName(resultId);
		assertEquals(USERNAME, resultUsername);

		TreeMap<Long, String> nameHistory = MojangUtil.getNameHistory(resultId);
		assertEquals(nameHistory.size(), 10);

	}

}
