
import java.util.*;
public class WordFinder {
	/**
	 * Given a String (the haystack) and an array of Strings (the needles),
	 * return a Map<String, Integer>, where keys in the map correspond to
	 * elements of needles that were found as substrings of haystack, and the
	 * value for each key is the lowest index of haystack at which that needle
	 * was found. A needle that was not found in the haystack should not be
	 * returned in the output map.
	 * 
	 * @param haystack
	 *            The string to search into.
	 * @param needles
	 *            The array of strings to search for. This array is not mutated.
	 * @return The list of needles that were found in the haystack.
	 */
	public static Map<String, Integer> findWords(String haystack,
			String[] needles) {
		if (haystack == null || needles == null)
			 return new HashMap<>();
		return SearchMany(haystack,needles);
	}
	private static Map<String, Integer> SearchMany(String haystack, String[] needles) {
		HashMap<String, Integer> output = new HashMap<String, Integer>();
		RabinKarp searcher = new RabinKarp();
		for (String needle : needles) {
			int index = searcher.RabinKarpSearch(haystack, needle);
			if (index >= 0) {
				output.put(needle, index);
			}
		}
		return output;
	}

}
