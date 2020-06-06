
/**
 * Write a description of StringsFirstAssignments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Part2{
    
    public String findSimpleGene (String dna,int startCodon, int stopCodon){
        String result = "";
        if(startCodon != -1 && stopCodon != -1)
        {
            result = dna.substring(startCodon,stopCodon+3);
            if(result.length()%3==0)
            {
                return result;
            }
        }
        return "No DNA Found";
    }
    
    public void testSimpleGene ()
    {
        String dna = "QLATGQEWRT";
        String dna1=dna.toUpperCase();
        int startCodon = dna1.indexOf("ATG");
        int stopCodon = dna1.indexOf("TAA",startCodon+3);
        System.out.println(findSimpleGene(dna,startCodon,stopCodon));
        
        dna = "ZAAGQEWRT";
        dna1=dna.toUpperCase();
        startCodon = dna1.indexOf("ATG");
        stopCodon = dna1.indexOf("TAA",startCodon+3);
        System.out.println(findSimpleGene(dna,startCodon,stopCodon));
        
        dna = "GQEWRTAA";
        dna1=dna.toUpperCase();
        startCodon = dna1.indexOf("ATG");
        stopCodon = dna1.indexOf("TAA",startCodon+3);
        System.out.println(findSimpleGene(dna,startCodon,stopCodon));
        
        dna = "EATGQEWRTAART";
        dna1=dna.toUpperCase();
        startCodon = dna1.indexOf("ATG");
        stopCodon = dna1.indexOf("TAA",startCodon+3);
        System.out.println(findSimpleGene(dna,startCodon,stopCodon));
       
        dna = "QWATGQEWTAAXC";
        dna1=dna.toUpperCase();
        startCodon = dna1.indexOf("ATG");
        stopCodon = dna1.indexOf("TAA",startCodon+3);
        System.out.println(findSimpleGene(dna,startCodon,stopCodon));
        
        dna = "atgtaa";
        dna1=dna.toUpperCase();
        startCodon = dna1.indexOf("ATG");
        stopCodon = dna1.indexOf("TAA",startCodon+3);
        System.out.println(findSimpleGene(dna,startCodon,stopCodon));
        
    }
    
    public static void main(String[] args)
    {
        Part2 p2 = new Part2();
        p2.testSimpleGene();
    }
}