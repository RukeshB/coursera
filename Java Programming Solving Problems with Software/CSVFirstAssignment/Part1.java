
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    public String countryInfo(CSVParser parser, String country)
    {
        for(CSVRecord record : parser)
        {
            String c=record.get("Country");
            //System.out.println(c);
            if(country.equals(c))
            {
                return c+": "+ record.get("Exports")+": "+record.get("Value (dollars)");
                //System.out.print(record.get("Country")+": ");
                //System.out.print(record.get("Exports")+": ");
                //System.out.println(record.get("Value (dollars)"));
            }
        }
        return "Nothing Found";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2)
    {
        for(CSVRecord record: parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportItem1) && export.contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser,String exportIteam)
    {
        int count=0;
        for(CSVRecord record: parser)
        {
            String export=record.get("Exports");
            if(export.contains(exportIteam))
            {
                count++;
            }
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount)
    {
        for(CSVRecord record: parser)
        {
            String exportAmount = record.get("Value (dollars)");
            if(exportAmount.length()>amount.length())
            {
                System.out.println(record.get("Country")+ ": "+exportAmount);
            }
        }
    }
    
    public void tester()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //System.out.println(countryInfo(parser,"Nauru"));
        //parser = fr.getCSVParser();
        //listExportersTwoProducts(parser,"cotton","flowers");
        //parser = fr.getCSVParser();
        //System.out.println(numberOfExporters(parser, "cocoa"));
        //parser = fr.getCSVParser();
        bigExporters(parser,"$999,999,999,999");
    }
}
