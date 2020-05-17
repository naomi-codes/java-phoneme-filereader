package phonemes;
/**
 * Abstract parent class for all phonemes.
 * Holds attribute information
 * 
 * @author Z
 * @version 04/03/17
 */
public abstract class Phoneme
{
    protected int startSampleNo;
    protected int endSampleNo;
    protected String name;
    protected String type;
    protected int sampleRate;

    public Phoneme(){
        startSampleNo = 0;
        endSampleNo = 0; 
        name = null;
        type = null;
    } //default constructor

    public Phoneme(int s, int e, String n, String t){
        this.startSampleNo = s;
        this.endSampleNo = e;
        this.name = n;
        this.type = t;
    } //constructor

    public int getStartSampleNo(){
        return startSampleNo;
    } //getStartSampleNo

    public int getEndSampleNo(){
        return endSampleNo;
    } //getEndSampleNo
    
    public String getName() {
        return name;
    } //getName
    
    public String getType() {
        return type;
    } //getType
    
}