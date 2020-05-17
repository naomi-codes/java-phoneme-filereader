package phonemes;

/**
 * Vowel type Phoneme
 * 
 * @author 2425693 
 * @version 07/03/2017
 */
public class TypeVowel extends Phoneme
{
	
	private static String NAME = "Vowel";
	//private static String NAME = "Vow";
	
    private static int count = 0;
    public TypeVowel (int s, int e, String t){
        super(s,e,NAME,t);
        count++;
    }

    public static int getCount () {
        return count;}
}
