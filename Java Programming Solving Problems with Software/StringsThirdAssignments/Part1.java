import edu.duke.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
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
        return "no dna found";
    }
    
    public StorageResource getAllGenes()
    {
        StorageResource sr = new StorageResource();
        sr.add(findGene("AAAATTAGTT"));
        sr.add(findGene("ATGBBBCCTGACTAA"));
        sr.add(findGene("AATABTSATAGATAA"));
        
        return sr;
    }
    
    
    
      public void printAllGenes()
    {
        StorageResource sr = getAllGenes();
        for(String s: sr.data())
        {
            System.out.println(s);
        }
        
    }
    
    public static void main(String[] args) {
        Part1 p1 = new Part1();
        p1.printAllGenes();
    }
}
