/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class BabyBirths {
    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                           " Gender " + rec.get(1) +
                           " Num Born " + rec.get(2));
            }
        }
    }

    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int countBoysName = 0;
        int countGirlsName = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                countBoysName ++;
            }
            else {
                totalGirls += numBorn;
                countGirlsName ++;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("female girls = " + totalGirls);
        System.out.println("male boys = " + totalBoys);
        System.out.println("number of girls' names = "+ countGirlsName);
        System.out.println("number of Boys names = "+ countBoysName);
    }

    public int getRank(int year,String name, String gender)
    {
        
        String FileName = "yob"+year+".csv";
        int rank = getRankFromFile(FileName,gender,name);
        return rank;
       }
       
    public int getRankFromFile(String FileName,String gender,String name)
    {
        int rank=0;
        String Filepath = "data/"+FileName;
        FileResource fr = new FileResource(Filepath);
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                rank ++;
                if(rec.get(0).equals(name))
                {
                    return rank;
                   }
               }
           }
        return -1;
       }
       
    public String getName(int year,int rank,String gender)
    {
        int pos=0;
        String FileName = "data/yob"+year+".csv";
        FileResource fr = new FileResource(FileName);
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                pos++;
                if(pos == rank)
                {
                    return rec.get(0);
                   }
               }
           }
        return "No Name";
       }
       
    public String whatIsNameInYear(int year, int newyear, String name, String gender)
    {
        int rank = getRank(year,name,gender);
        String newname = getName(newyear,rank,gender);
        return newname;
       }
       
    public int yearOfHighestRank(String name, String gender)
    {
        DirectoryResource dr = new DirectoryResource();
        int highestRank=0;
        String FileName = "";
        for(File f : dr.selectedFiles())
        {
            int rank = getRankFromFile(f.getName(),gender,name);
            if((highestRank == 0 || highestRank>rank) && rank > 0)
            {
                highestRank= rank;
                FileName = f.getName();
               }
           }
           
        
        if(highestRank != 0)
        {
            FileName = FileName.substring(FileName.indexOf("yob")+3,FileName.indexOf(".csv"));
            int year = Integer.parseInt(FileName);
            return year;
           }
        return -1;
       }
       
       public double getAverageRank(String name, String gender)
       {
           DirectoryResource dr = new DirectoryResource();
           int SumOfRank=0;
           int count =0;
            for(File f : dr.selectedFiles())
            {
                int rank = getRankFromFile(f.getName(),gender,name);
                if(rank > 0)
                {
                    SumOfRank = SumOfRank + rank;
                }
                count++;
               }
           
           if(SumOfRank != 0)
           {
               double avgrank = (double) SumOfRank / count;
               return avgrank;
            }
            
           return -1;
           }
           
    public int getTotalBirthsRankedHigher(String name,String gender,int year)
    {
        String Filepath = "data/yob"+year+".csv";
        int totalBirth = 0;
        FileResource fr = new FileResource(Filepath);
        for(CSVRecord rec : fr.getCSVParser(false))
        {
            if(rec.get(1).equals(gender))
            {
                if(rec.get(0).equals(name))
                {
                    break;
                   }
                totalBirth = totalBirth + Integer.parseInt(rec.get(2));  
               }
           }
        return totalBirth;
    }
    
    public void test () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource();
        totalBirths(fr);
        //System.out.println(getRank(1971,"Frank", "M"));
        //System.out.println(getName(1982,450, "M"));
        //System.out.println("Owen born in 2012 would be "+whatIsNameInYear(1974,2014,"Owen","M")+" if she was born in 2014.");
        //System.out.println(yearOfHighestRank("Mich","M"));
        //System.out.println(getAverageRank("Robert","M"));
        //System.out.println(getTotalBirthsRankedHigher("Drew","M",1990));
    }
}
