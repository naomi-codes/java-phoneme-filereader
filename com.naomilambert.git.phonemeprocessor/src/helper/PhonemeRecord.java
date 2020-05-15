package helper;

import java.util.ArrayList;
import java.util.List;

// package imports
import phonemes.Phoneme;


/**
 * Class to hold details of existing known (to the program) phonemes including arrays of various groups
 * of phonemes, a list of phonemes found in the file read. 
 * Gives access to the list of found phonemes for reference
 * Contains the methods needed to discern phoneme type.
 * 
 * @author Zee 
 * @version 07/03/2017
 */
public class PhonemeRecord 
{
    private static List<Phoneme> foundPhonemes;

    private static String[] affricatives = {"jh", "ch"};
    private static String[] closures = {"bcl", "dcl", "gcl", "pcl", "tck", "kcl", "tcl"};
    private static String[] fricatives = {"s", "sh", "z", "zh", "f", "th", "v", "dh"};
    private static String[] semivowels = {"l", "r", "w", "y", "hh", "hv", "el"};
    private static String[] nasals = {"m", "n", "ng", "em", "en", "eng", "nx"};
    private static String[] stops = {"b", "d", "g", "p", "t", "k", "dx", "q"};
    private static String[] others = {"pau", "epi", "h#", "1", "2"};
    private static String[] vowels = {"iy", "ih", "eh", "ey", "ae", "aa", "aw", "ay", "ah", "ao", "oy", "ow", 
            "uh", "uw", "ux", "er", "ax", "ix", "axr", "ax-r"};

    /**
     * Constructor for objects of class PhonemeRecord
     */
    public PhonemeRecord()
    {
        foundPhonemes = new ArrayList<Phoneme>();
    } // constructor

    public static void addPhoneme (Phoneme p) {
        foundPhonemes.add(p);
    }//addPhoneme

    public static List<Phoneme> getPhonemes () {
        return foundPhonemes;
    }//getPhonemes

    public static String findType(String pho) {
        String type = "not found";
        if (isAffricative(pho)) type = "affricative";
        if (isClosure(pho)) type = "closure";
        if (isStop(pho)) type = "stop";
        if (isVowel(pho)) type = "vowel";
        if (isSemivowel(pho)) type = "semivowel";
        if (isFricative(pho)) type = "fricative";
        if (isNasal(pho)) type = "nasal";
        if (isOther(pho)) type = "other";
        return type;
    } // findPhonemeType

    public static boolean isAffricative(String ph) {
        boolean found = false;

        for (int i = 0; i < affricatives.length; i++){
            if (affricatives[i].equals(ph))
                found = true;       
        }

        return found;
    } // iswAffricative

    public static boolean isClosure(String ph) {
        boolean found = false;

        for (int i = 0; i < closures.length; i++){
            if (closures[i].equals(ph))
                found = true;       
        }

        return found;
    } // isClosure

    public static boolean isFricative(String ph) {
        boolean found = false;

        for (int i = 0; i < fricatives.length; i++){
            if (fricatives[i].equals(ph))
                found = true;       
        }

        return found;
    } // isFricative

    public static boolean isSemivowel(String ph) {
        boolean found = false;

        for (int i = 0; i < semivowels.length; i++){
            if (semivowels[i].equals(ph))
                found = true;       
        }

        return found;
    } // isSemivowel

    public static boolean isNasal(String ph) {
        boolean found = false;

        for (int i = 0; i < nasals.length; i++){
            if (nasals[i].equals(ph))
                found = true;       
        }

        return found;
    } // isNasal

    public static boolean isStop(String ph) {
        boolean found = false;

        for (int i = 0; i < stops.length; i++){
            if (stops[i].equals(ph))
                found = true;       
        }

        return found;
    } //isStop

    public static boolean isVowel(String ph) {
        boolean found = false;

        for (int i = 0; i < vowels.length; i++){
            if (vowels[i].equals(ph))
                found = true;       
        }

        return found;
    } //isVowel

    public static boolean isOther(String ph) {
        boolean found = false;

        for (int i = 0; i < others.length; i++) {
            if (others[i].equals(ph))
                found = true;
        }

        return found;
    }
}