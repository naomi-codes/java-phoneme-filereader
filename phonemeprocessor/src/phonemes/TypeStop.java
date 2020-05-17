package phonemes;

/**
 * Stop phoneme.
 * 
 * @author 2425693 
 * @version 07/03/2017
 */
public class TypeStop extends Phoneme
{
	private static String NAME = "Stop";
	//private static String NAME = "Sto";
	
    private static int count = 0;

    public TypeStop (int s, int e, String t){
        super(s,e,NAME,t);
        count++;
    }

    public static int getCount () {
        return count;}
}
