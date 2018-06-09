import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.ArrayList;
import java.util.List;

public class DigitsToStringConverter {
	/**
	 * Given a list of digits, a base, and an mapping of digits of that base to
	 * chars, convert the list of digits into a character string by applying the
	 * mapping to each digit in the input.
	 * 
	 * If digits[i] >= base or digits[i] < 0 for any i, consider the input
	 * invalid, and return null. If alphabet.length != base, consider the input
	 * invalid, and return null.
	 *
	 * @param digits
	 *            A list of digits to encode. This object is not mutated.
	 * @param base
	 *            The base the digits are encoded in.
	 * @param alphabet
	 *            The mapping of digits to chars. This object is not mutated.
	 * @return A String encoding the input digits with alphabet.
	 */
	public static String convert(int[] digits, int base, char[] alphabet) {
		if (base < 2 || alphabet == null || digits == null || alphabet.length != base)
			return null;
		StringBuilder strBuilder = new StringBuilder();
		for(int i = 0; i < digits.length;i++)
			if(digits[i] >= base || digits[i] < 0)
				return null;
		    else
		    	strBuilder.append(alphabet[digits[i]]);
		return strBuilder.toString();
	}
}
