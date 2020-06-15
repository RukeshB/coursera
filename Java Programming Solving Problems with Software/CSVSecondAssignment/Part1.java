
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part1 {

    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord coldestHour = null;
        for(CSVRecord record : parser)
        {
            if(coldestHour == null)
            {
                coldestHour = record;
            }
            else
            {
                double currenttemp = Double.parseDouble(record.get("TemperatureF"));
                double coldesttemp = Double.parseDouble(coldestHour.get("TemperatureF"));
                if(coldesttemp > currenttemp)
                {
                    coldestHour = record;
                }
            }
        }
        return coldestHour;
    }
    
    public void testcoldestHourInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestHour = coldestHourInFile(parser);
        System.out.println("the coldest tempeture is "+coldestHour.get("TemperatureF"));
    }
    
    public double averageTemperatureInFile (CSVParser parser)
    {
        double sum = 0;
        double avg =0;
        double count =0;
        for(CSVRecord record : parser)
        {
                double currenttemp = Double.parseDouble(record.get("TemperatureF"));
                sum = sum + currenttemp;
                count ++;
        }
        avg = sum/count;
        return avg;
    }
    
    public void testAverageTemperatureInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is "+avg);
    }
    
     public double averageTemperatureWithHighHumidityInFile (CSVParser parser, int value)
    {
        double sum = 0;
        double avg =0;
        double count =0;
        for(CSVRecord record : parser)
        {
                double currenttemp = Double.parseDouble(record.get("TemperatureF"));
                String humidity =record.get("Humidity");
                if(humidity!="N/A")
                {
                    double currenthumidity = Double.parseDouble(humidity);
                    if(currenthumidity >= 80)
                    {
                        sum = sum + currenttemp;
                        count ++;
                    }
                }
                
        }
        if(count == 0)
        {
            System.out.println("No temperatures with that humidity");
            return 0;
        }
        avg = sum/count;
        return avg;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureWithHighHumidityInFile (parser,80);
        System.out.println("Average temperature in file with Humidity higher then 80 is "+avg);
    }
    
     public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord lowestHumidity = null;
        for(CSVRecord record : parser)
        {
            String humidity =record.get("Humidity");
                if(humidity.contains("N/A"))
                {
                    //System.out.println(humidity);
                    continue;
                }
                else{
                    if(lowestHumidity == null )
                        {
                            lowestHumidity = record;
                        }
                        else
                        {
                         
                                double currenttemp = Double.parseDouble(humidity);
                                double lowestHumiditytemp = Double.parseDouble(lowestHumidity.get("Humidity"));
                                if(lowestHumiditytemp > currenttemp)
                                {
                                    lowestHumidity = record;
                                }
                           
                            
                        }
                    }
                }
            
        return lowestHumidity;
    }
    
    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidity = lowestHumidityInFile(parser);
        System.out.println("the Lowest Humidity is "+lowestHumidity.get("Humidity")+" at "+ lowestHumidity.get("TimeEST"));
    }
    
    public String fileWithColdestTemperature()
    {
        File temp=null;
        double coldestHour = 100;
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
             FileResource fr = new FileResource(f);
             CSVParser parser= fr.getCSVParser();
             
             double currentcoldest = Double.parseDouble(coldestHourInFile(parser).get("TemperatureF"));
             if(coldestHour >= 100)
             {
                 coldestHour = currentcoldest;
                 temp=f;
             }
             else
             {
                 if(currentcoldest < coldestHour && currentcoldest > 0)
                 {
                     coldestHour = currentcoldest;
                     temp=f;
                    }
             }
        }
        System.out.println(temp);
        return temp.getName();
    }
    
    public void testFileWithColdestTemperature()
    {
        String FileName = fileWithColdestTemperature();
        System.out.println("file Name With Coldest Temperature is "+ FileName);
        //String filename = "nc_weather\2014"
        FileResource fr = new FileResource("E:\\git\\coursera\\Java Programming Solving Problems with Software\\CSVSecondAssignment\\nc_weather\\2014\\"+FileName);
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestHour = coldestHourInFile(parser);
        System.out.println("the coldest tempeture is "+coldestHour.get("TemperatureF"));
        
    }
    
    public String fileWithlowestHumidity()
    {
        File temp=null;
        double lowestHumidity = -1;
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
             FileResource fr = new FileResource(f);
             CSVParser parser= fr.getCSVParser();
             String humidity =lowestHumidityInFile(parser).get("Humidity");
                if(humidity=="N/A")
                {
                    humidity="-1";
                }
             double currentHumidity = Double.parseDouble(humidity);
             if(lowestHumidity == 13)
             {
                 System.out.println(lowestHumidityInFile(parser).get("TimeEST"));
                }
             if(lowestHumidity < 0)
             {
                 lowestHumidity = currentHumidity;
                 temp=f;
             }
             else
             {
                 if(currentHumidity < lowestHumidity)
                 {
                     lowestHumidity = currentHumidity;
                     temp=f;
                    }
             }
        }
        System.out.println(temp);
        return temp.getName();
    }
    
    public void testFileWithlowestHumidity()
    {
        String FileName = fileWithlowestHumidity();
        System.out.println("file Name With Lowest Humidity is "+ FileName);
        //String filename = "nc_weather\2014"
        FileResource fr = new FileResource("E:\\git\\coursera\\Java Programming Solving Problems with Software\\CSVSecondAssignment\\nc_weather\\2014\\"+FileName);
        CSVParser parser = fr.getCSVParser();
        CSVRecord lowestHumidity = lowestHumidityInFile(parser);
        System.out.println("the Lowest Humidity is "+lowestHumidity.get("Humidity")+" at "+ lowestHumidity.get("TimeEST"));
        
    }
    
}
