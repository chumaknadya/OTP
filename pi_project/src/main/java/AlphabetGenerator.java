import java.util.*;

public class AlphabetGenerator {
	/**
	 * Given a numeric base, return a char[] that maps every digit that is
	 * representable in that base to a lower-case char.
	 * <p>
	 * This method will try to weight each character of the alphabet
	 * proportional to their occurrence in words in a training set.
	 * <p>
	 * The letters should occur in lexicographically ascending order in the
	 * returned array. - {"a", "b", "c", "c", "d"} is a valid output. - {"b",
	 * "c", "c", "d", "a"} is not.
	 * <p>
	 * If base >= 0, the returned array should have length equal to the size of
	 * the base.
	 * <p>
	 * If base < 0, return null.
	 * <p>
	 * If a String of trainingData has any characters outside the range a-z,
	 * ignore those characters and continue.
	 *
	 * @param base         A numeric base to get an alphabet for.
	 * @param trainingData The training data from which to generate frequency counts.
	 *                     This array is not mutated.
	 * @return A char[] that maps every digit of the base to a char that the
	 * digit should be translated into.
	 */
	private  static float totalNumberOfCharacters;
	public static char[] generateFrequencyAlphabet(int base,
												   String[] trainingData) {
		if (base < 0)
			return null;
		if (base == 0) {
			char[] emptyRes = {};
			return emptyRes;
		}
		Map<Character, Integer> countMap = calculateFrequency(trainingData);
		Character[] keys = countMap.keySet().toArray(new Character[0]);
		Arrays.sort(keys);
		Map<Character, Float> frequencyMap = calculateProbability(keys,totalNumberOfCharacters,countMap);
		Map<Character, Float> cumulativeProbabilityMap = calculateCumulativeProbability(frequencyMap,keys,base);
		String result = "";
		int end = 0;
		for(int i = 0; i < keys.length; i++){
			for(int j = end; j < (int)Math.ceil(cumulativeProbabilityMap.get(keys[i])); j++){
				result += keys[i];
			}
			end = (int)Math.ceil(cumulativeProbabilityMap.get(keys[i]));
		}
		return result.toCharArray();
	}

	private static Map<Character, Integer> calculateFrequency(String[] words) {
		Map<Character, Integer> frequency = new HashMap<>();
		totalNumberOfCharacters = 0;
		for (String word : words) {
			for (char symbol : word.toCharArray()) {
				if (Character.isLetter(symbol)) {
					totalNumberOfCharacters += 1;
					frequency.put(symbol, frequency.getOrDefault(symbol, 0) + 1);
				}
			}
		}
		return frequency;
	}

	private static Map<Character, Float> calculateProbability(Character[] keys,float totalNumber,Map<Character, Integer> countMap) {
		Map<Character, Float> frequencyMap = new HashMap<Character, Float>();
		for(int i = 0; i < countMap.size();i++){
			frequencyMap.put(keys[i], (float) (countMap.get(keys[i])/totalNumber));
		}
		return frequencyMap;
	}
	private static Map<Character, Float> calculateCumulativeProbability( Map<Character, Float> frequencyMap,Character[] keys,int base) {
		Map<Character, Float> cumulativeProbabilityMap = new HashMap<Character, Float>();
		float cdfMultBase = 0;
		for(int i = 0; i < keys.length;i++){
			cdfMultBase  += frequencyMap.get(keys[i]);
			cumulativeProbabilityMap.put(keys[i],cdfMultBase*base);
		}
		return cumulativeProbabilityMap;
	}



}
