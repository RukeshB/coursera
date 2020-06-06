
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
     public int findStopCodon(String dna, int startIndex, String stopCodon)
    {
        int currIndex = dna.indexOf(stopCodon,startIndex+3);
        
            if(currIndex !=-1 && (currIndex - startIndex) % 3 == 0)
            {
                return currIndex;
            }
       
        return dna.length();
    }
    
    public String findGene (String dna)
    {
        int startIndex = dna.indexOf("ATG");
        if(startIndex != -1)
        {
            int stopIndexTAA = findStopCodon(dna,startIndex,"TAA");
            int stopIndexTAG = findStopCodon(dna,startIndex,"TAG");
            int stopIndexTGA = findStopCodon(dna,startIndex,"TGA");
            
            if(stopIndexTAA < stopIndexTAG && stopIndexTAA<stopIndexTGA )
            {
                return dna.substring(startIndex,stopIndexTAA+3);
            }
            
            if(stopIndexTAG < stopIndexTAA && stopIndexTAG<stopIndexTGA)
            {
                return dna.substring(startIndex,stopIndexTAG+3);
            }
            
            if(stopIndexTGA < stopIndexTAA && stopIndexTGA<stopIndexTAG)
            {
                return dna.substring(startIndex,stopIndexTGA+3);
            }
        }
        return "";
    }
    
     
    public int countGenes(String dna)
    {
        int count =0;
        
        while(findGene(dna)!="")
        {
            dna = findGene(dna);
            count++;
        }
        return count;
    }
    
    public void printAllGenes()
    {
        String dna = "ATGTAAGATGCCCTAGT";
        System.out.println(countGenes(dna));
        
    }
    public static void main(String[] args) {
        Part3 p3 = new Part3();
        p3.printAllGenes();
    }

}
