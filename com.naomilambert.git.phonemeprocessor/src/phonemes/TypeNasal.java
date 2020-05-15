package phonemes;

/**
 * Nasal phoneme
 * 
 * @author 2425693
 * @version 07/03/2017
 */
public class TypeNasal extends Phoneme
{
    private static int count = 0;

    public TypeNasal (int s, int e, String n, String t){
        super(s,e,n,t);
        count++;
    }

    public static int getCount () {
        return count;}
}
