package phonemes;

/**
 * Other Phoneme
 * 
 * @author 2425693
 * @version 07/03/2017
 */
public class TypeOthers extends Phoneme
{
	private static String NAME = "Others";
	//private static String NAME = "Oth";
	
    private static int count = 0;
    public TypeOthers (int s, int e, String t){
        super(s,e,NAME,t);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
