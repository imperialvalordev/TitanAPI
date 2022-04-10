package net.imperialvalor.titanapi.share.util;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Whitescan
 *
 */
public class ValidationUtils {

	/**
	 * Check if string only contains whitelisted characters.
	 *
	 * @param input - the input string to validate
	 * @return if the input does not contain invalid characters
	 */
	public static boolean validateStringInput(String input) {

		if (StringUtils.isBlank(input)) {
			return false;
		}

		String whitelist = "[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789^!\\\"$%&/{}()[]=?\\\\@€+*~#<>|,;.:-_ ]";

		for (char c : input.toCharArray()) {
			if (whitelist.indexOf(c) == -1) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Validate if string only contains whitelisted characters and is not exceeding the maximal length for this input.
	 *
	 * @param input     - the input string to validate
	 * @param maxLength - the maximum length of the input
	 * @return if the input does not contain illegal characters or exceeds the maximum length
	 */
	public static boolean validateStringInput(String input, int maxLength) {
		return validateStringInput(input) && input.length() <= maxLength;
	}

	/**
	 * Validate decimal inputs.
	 *
	 * @param input - the decimal input to validate
	 * @return if the input does not contain illegal characters
	 */
	public static boolean validateDecimalInput(String input) {

		if (StringUtils.isBlank(input)) {
			return false;
		}

		String characterWhitelist = "+-.";
		String numberWhitelist = "0123456789";

		long plusCounter = countChars(input, '+');
		long minusCounter = countChars(input, '-');
		long pointCounter = countChars(input, '.');

		// Only one +, - and . allowed
		if (pointCounter > 1 || plusCounter > 1 || minusCounter > 1) {
			return false;
		}

		// Only either + or - allowed
		// Input has to start with a whitelisted char
		if ((plusCounter == 1 && minusCounter == 1) || ((characterWhitelist + numberWhitelist).indexOf(input.charAt(0)) == -1)) {
			return false;
		}

		// Input should only contain whitelisted numbers at this point
		for (char c : input.toCharArray()) {

			if (c != '+' && c != '-' && c != '.') {
				if (numberWhitelist.indexOf(c) == -1) {
					return false;
				}
			}

		}

		return true;
	}

	/**
	 * Validate integer input strings.
	 *
	 * @param input - the integer input to validate.
	 * @return if the input does not contain illegal characters
	 */
	public static boolean validateIntegerInput(String input) {

		if (StringUtils.isBlank(input)) {
			return false;
		}

		String characterWhitelist = "+-.";
		String numberWhitelist = "0123456789";

		long plusCounter = countChars(input, '+');
		long minusCounter = countChars(input, '-');

		// Only one + and - allowed
		// Only either + or - allowed
		if (plusCounter > 1 || minusCounter > 1 || (plusCounter == 1 && minusCounter == 1)) {
			return false;
		}

		// Input has to start with a whitelisted char
		if ((characterWhitelist + numberWhitelist).indexOf(input.charAt(0)) == -1) {
			return false;
		}

		// Input should only contain whitelisted numbers at this point
		for (char c : input.toCharArray()) {

			if (c != '+' && c != '-' && c != '.') {
				if (numberWhitelist.indexOf(c) == -1) {
					return false;
				}
			}

		}

		return true;

	}

	/**
	 * Validate key input strings.
	 *
	 * @param input     - the key input to validate
	 * @param maxLength - the maximum length of the input allowed
	 * @return if the key does not contain or exceeds the maximum char length
	 */
	public static boolean validateKeyInput(String input, int maxLength) {

		if (StringUtils.isBlank(input) || input.length() > maxLength) {
			return false;
		}

		String whitelist = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		for (char c : input.toCharArray()) {
			if (whitelist.indexOf(c) == -1) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Used to count occurrences of a characters in given string.
	 *
	 * @param input - the string to filter
	 * @param c     - the character to count
	 * @return the number of occurrences
	 */
	public static long countChars(String input, char c) {
		return input.chars().filter(ch -> ch == c).count();
	}

}
