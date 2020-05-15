package phonemes;

/**
 * Semivowel phoneme.
 * 
 * @author 2425693
 * @version 07/03/2017
 */
public class TypeSemivowel extends Phoneme
{
	private static String NAME = "Semivowel";
	//private static String NAME = "Se";
	
    private static int count = 0;

    public TypeSemivowel (int s, int e, String t){
        super(s,e,NAME,t);
        count++;
    }

    public static int getCount () {
        return count;}	
}
