package phonemes;

/**
 * Fricative phoneme
 * 
 * @author 2425693 
 * @version 07/03/2017
 */
public class TypeFricative extends Phoneme
{
	private static String NAME = "Fricative";
	//private static String NAME = "Fri";
	
    private static int count = 0;
    public TypeFricative (int s, int e, String t){
        super(s,e,NAME,t); 
        count++;
    }

    public static int getCount () {
    return count;}
}
