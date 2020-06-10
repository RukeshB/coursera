
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {

    public int count(String dna, String codon)
    {
        int index = dna.indexOf(codon);
        int c =0;
        while(index!=-1)
        {
            index = dna.indexOf(codon,index+codon.length());
            c++;
        }
        return c;
    }
    
    public double cgRatio(String dna)
    {
        
        int c = count(dna,"C");
        int g = count(dna,"G");
        //System.out.println("c => "+c+" g => "+g);
        double ratio= (double) (c+g) / dna.length();
        return ratio;
    }
    
    public static void main(String[] args) {
        Part2 p2 = new Part2();
        System.out.println("cgratio => "+p2.cgRatio("ATGCCATAG"));
        
        System.out.println("countCTG => "+p2.count("CTGAACTGCT","CTG"));
    }
}
