package phonemes;

/**
 * Closure phone
 * 
 * @author 2425693 
 * @version 07/03/2017
 */
public class TypeClosure extends Phoneme
{
    private static int count = 0;

    public TypeClosure (int s, int e, String n, String t){
        super(s,e,n,t);
        count++;
    }

    public static int getCount () {
        return count;}
}
