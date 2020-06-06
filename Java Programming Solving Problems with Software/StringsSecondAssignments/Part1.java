/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author Rukesh
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
    public void printAllGenes()
    {
        String dna = "AATGABCTAATAG";
        System.out.println(findGene(dna));
        
        dna = "ATGBBBCCTGACTAA";
        System.out.println(findGene(dna));
        
        dna = "AATABTSATAGATAA";
        System.out.println(findGene(dna));
    }
    
    public static void main(String[] args) {
        Part1 p1 = new Part1();
        p1.printAllGenes();
    }
}
