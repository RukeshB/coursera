
/**
 * Write a description of Grayscale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class Grayscale {
    public ImageResource convertToGray(ImageResource image)
    {
        
            ImageResource newImage = new ImageResource(image.getWidth(),image.getHeight());
            for(Pixel p : newImage.pixels())
            {
                Pixel inpixel = image.getPixel(p.getX(),p.getY());
                int average = (inpixel.getRed()+inpixel.getGreen()+inpixel.getBlue())/3;
                p.setRed(average);
                p.setGreen(average);
                p.setBlue(average);
            }
            String newName = "Gray-"+image.getFileName();
            newImage.setFileName(newName);
            return newImage;
    }
    
    public static void main(String[] args)
        {
            Grayscale gs = new Grayscale();
            DirectoryResource dr = new DirectoryResource();
            for(File f : dr.selectedFiles())
            {
                ImageResource image = new ImageResource(f);
                
                ImageResource newImage = gs.convertToGray(image);
                newImage.save();
                //System.out.println(newName);
                newImage.draw();
        
            }
        }

}
