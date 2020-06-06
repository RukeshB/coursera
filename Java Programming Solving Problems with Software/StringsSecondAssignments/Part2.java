
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb)
    {
        int index=stringb.indexOf(stringa);
        int count=0;
        while(index != -1)
        {
            index = stringb.indexOf(stringa,index+stringa.length());
            count++;
        }
        return count;
    }
    
    public void testHowMany()
    {
        System.out.println(howMany("AA", "ATAAAA"));
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
    }
    
    public static void main(String[] args) {
        Part2 p2 = new Part2();
        p2.testHowMany();
    }

}
