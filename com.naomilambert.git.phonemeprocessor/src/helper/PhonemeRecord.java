package helper;

import java.util.List;

// package imports
import phonemes.Phoneme;


/**
 * Class to hold details of existing known (to the program) phonemes 
 * including arrays of various groups of phonemes, a list of phonemes 
 * found in the file read. 
 * Gives access to the list of found phonemes for printing and adding 
 * the list
 * Contains the methods needed to discern phoneme type.
 * 
 * @author Zee 
 * @version 07/03/2017
 */
public class PhonemeRecord 
{
	// CONSTANTS TO HOLD PHONEMES BY TYPE

	private static final String[] AFFRICATIVES = {"jh", "ch"};
	private static final String[] CLOSURES = {"bcl", "dcl", "gcl", "pcl", "tck", "kcl", "tcl"};
	private static final String[] FRICATIVES = {"s", "sh", "z", "zh", "f", "th", "v", "dh"};
	private static final String[] SEMIVOWELS = {"l", "r", "w", "y", "hh", "hv", "el"};
	private static final String[] NASALS = {"m", "n", "ng", "em", "en", "eng", "nx"};
	private static final String[] STOPS = {"b", "d", "g", "p", "t", "k", "dx", "q"};
	private static final String[] OTHERS = {"pau", "epi", "h#", "1", "2"};
	private static final String[] VOWELS = {"iy", "ih", "eh", "ey", "ae", "aa", "aw", "ay", "ah", "ao", "oy", "ow", 
			"uh", "uw", "ux", "er", "ax", "ix", "axr", "ax-r"};

	// List to hold all phonemes found in the file
	private static List<Phoneme> foundPhonemes;

	/**
	 * Adds a previously validated phoneme to the list of all 
	 * found phonemes
	 * @param phoneme 
	 */
	public static void addPhoneme (Phoneme phoneme) {
		foundPhonemes.add(phoneme);

	}//addPhoneme

	/**
	 * Returns the list of all found phonemes
	 * @return
	 */
	public static List<Phoneme> getPhonemes () {
		return PhonemeRecord.foundPhonemes;
	}//getPhonemes

	/**
	 * Takes the read in phoneme and finds its matching type if there is one
	 * @param phoneme
	 * @return
	 */
	public static String findType(String phoneme) {
		String type = null;
		if (isAffricative(phoneme)) type = "affricative";
		if (isClosure(phoneme)) type = "closure";
		if (isStop(phoneme)) type = "stop";
		if (isVowel(phoneme)) type = "vowel";
		if (isSemivowel(phoneme)) type = "semivowel";
		if (isFricative(phoneme)) type = "fricative";
		if (isNasal(phoneme)) type = "nasal";
		if (isOther(phoneme)) type = "other";
		return type;
	} // findPhonemeType

	/**
	 * Checks if the phoneme is an affricative
	 * @param phoneme
	 * @return boolean
	 */
	public static boolean isAffricative(String phoneme) {
		boolean found = false;

		for (int i = 0; i < AFFRICATIVES.length; i++){
			if (AFFRICATIVES[i].equals(phoneme))
				found = true;       
		}

		return found;
	} // iswAffricative

	/**
	 * Checks if the phoneme is a closure
	 * @param phoneme
	 * @return
	 */
	public static boolean isClosure(String phoneme) {
		boolean found = false;

		for (int i = 0; i < CLOSURES.length; i++){
			if (CLOSURES[i].equals(phoneme))
				found = true;       
		}

		return found;
	} // isClosure

	/**
	 * Checks if the phoneme is a fricative
	 * @param phoneme
	 * @return
	 */
	public static boolean isFricative(String phoneme) {
		boolean found = false;

		for (int i = 0; i < FRICATIVES.length; i++){
			if (FRICATIVES[i].equals(phoneme))
				found = true;       
		}

		return found;
	} // isFricative

	/**
	 * Checks if the phoneme is a semivowel
	 * @param phoneme
	 * @return
	 */
	public static boolean isSemivowel(String phoneme) {
		boolean found = false;

		for (int i = 0; i < SEMIVOWELS.length; i++){
			if (SEMIVOWELS[i].equals(phoneme))
				found = true;       
		}

		return found;
	} // isSemivowel

	/**
	 * Checks if the phoneme is a nasal
	 * @param phoneme
	 * @return
	 */
	public static boolean isNasal(String phoneme) {
		boolean found = false;

		for (int i = 0; i < NASALS.length; i++){
			if (NASALS[i].equals(phoneme))
				found = true;       
		}

		return found;
	} // isNasal

	/**
	 * Checks if the phoneme is a stop
	 * @param phoneme
	 * @return
	 */
	public static boolean isStop(String phoneme) {
		boolean found = false;

		for (int i = 0; i < STOPS.length; i++){
			if (STOPS[i].equals(phoneme))
				found = true;       
		}

		return found;
	} //isStop

	/**
	 * Checks if the phoneme is a vowel
	 * @param phoneme
	 * @return
	 */
	public static boolean isVowel(String phoneme) {
		boolean found = false;

		for (int i = 0; i < VOWELS.length; i++){
			if (VOWELS[i].equals(phoneme))
				found = true;       
		}

		return found;
	} //isVowel

	/**
	 * Checks if the phoneme is an other
	 * @param phoneme
	 * @return
	 */
	public static boolean isOther(String phoneme) {
		boolean found = false;

		for (int i = 0; i < OTHERS.length; i++) {
			if (OTHERS[i].equals(phoneme))
				found = true;
		}

		return found;
	}
}