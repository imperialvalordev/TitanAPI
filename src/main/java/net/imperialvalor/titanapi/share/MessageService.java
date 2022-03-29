package net.imperialvalor.titanapi.share;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.TextComponent;

/**
 *
 * @author Whitescan
 *
 */
public class MessageService {

	/**
	 * TODO Network Prefix
	 */
	private static final String PROXY_PREFIX = "§cIV §f§l» §e";

	/**
	 * Message used when actor is laking the permission to access a command section
	 */
	public static final TextComponent NO_PERMISSION_COMMAND = new TextComponent("§cYou don't have the permission to access that command!");

	/**
	 * Message used when actor is laking the permission to access a server
	 */
	public static final TextComponent NO_PERMISSION_SERVER = new TextComponent("§cYou don't have the permission to access that server!");

	/**
	 * Message used when the actor must be a player
	 */
	public static final TextComponent PLAYER_ONLY = new TextComponent("§cThis Feature is restricted to players!");

	/**
	 * Message used when the target player could not be found
	 */
	public static final TextComponent TARGET_NOT_FOUND = new TextComponent("§cTarget could not be found!");

	/**
	 * Message used when target is the actor
	 */
	public static final TextComponent TARGET_IS_SENDER = new TextComponent("§cYou can't interact with yourself!");

	/**
	 * Message used when a feature is disabled
	 */
	public static final TextComponent DISABLED_FEATURE = new TextComponent(
			"§cThis Feature is currently unavailable. Please try again later.");

	public static final TextComponent LOCKED = new TextComponent(
			PROXY_PREFIX + "§4System Error\n\n§cThe server is currently unavailable!\n\n§aPlease contact the support!");

	/**
	 * Method used when displaying custom messages
	 *
	 * @param message - The message to create
	 * @return <TextComponent>
	 */
	public static TextComponent createMessage(String message) {
		TextComponent textComponent = new TextComponent(PROXY_PREFIX + message);
		return textComponent;
	}

	/**
	 * Method used when displaying a syntax error message
	 *
	 * @param context - The help context
	 * @return <TextComponent>
	 */
	public static TextComponent createSyntaxErrorMessage(String context) {
		TextComponent textComponent = createMessage("§cWrong arguments, try §a" + context);
		textComponent.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, context));
		return textComponent;
	}

	/**
	 * Method used when displaying cooldown messages
	 *
	 * @param message - The message to create
	 * @return <TextComponent>
	 */
	public static TextComponent createCooldownMessage(long cooldown) {
		return createMessage("§cYou must wait §8" + cooldown + " second(s) §cbefore using that again.");
	}

}
