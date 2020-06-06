
/**
 * Write a description of StringsFirstAssignments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part1{
    
    public String findSimpleGene (String dna){
        String result = "";
        int startindex = dna.indexOf("ATG");
        int endindex = dna.indexOf("TAA",startindex+3);
        if(startindex != -1 && endindex != -1)
        {
            result = dna.substring(startindex,endindex+3);
            if(result.length()%3==0)
            {
                return result;
            }
        }
        return "No DNA Found";
    }
    
    public void testSimpleGene ()
    {
        System.out.println(findSimpleGene("QLATGQEWRT")); 
        System.out.println(findSimpleGene("ZAAGQEWRT"));
        System.out.println(findSimpleGene("GQEWRTAA"));
        System.out.println(findSimpleGene("ATGQEWRTAA"));
        System.out.println(findSimpleGene("ATGQEWTAA"));
    }
    
    public static void main(String[] args)
    {
        Part1 p1 = new Part1();
        p1.testSimpleGene();
    }
}