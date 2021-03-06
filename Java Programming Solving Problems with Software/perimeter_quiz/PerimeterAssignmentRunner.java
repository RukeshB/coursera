import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
       for(Point p: s.getPoints())
        {
            count++;
        }
   
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here 
        double Avg =0;
        int num = getNumPoints(s);
        Point prevPt = s.getLastPoint();
        for(Point p: s.getPoints())
        {
            double currDist = prevPt.distance(p);
            Avg = Avg + currDist;
            prevPt = p;
        }
        Avg =Avg/num;
        return Avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double large=0;
        Point prevPt = s.getLastPoint();
        for(Point p: s.getPoints())
        {
            double currDist = prevPt.distance(p);
            if(large<currDist)
            {
                large = currDist;
            }
            prevPt = p;
        }
        return large;
    }

    public double getLargestX(Shape s) {
        // Put code here
        return 0.0;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double largestperimeter = 0;
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(largestperimeter<length)
            {
                largestperimeter=length;
            }
        }
        return largestperimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double largestperimeter = 0;
        DirectoryResource dr=new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(largestperimeter<length)
            {
                largestperimeter=length;
                temp=f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int num = getNumPoints(s);
        System.out.println("num ="+num);
        
        double Avglength = getAverageLength(s);
        System.out.println("Average Length ="+Avglength);
        
        double LargestSide = getLargestSide(s);
        System.out.println("Largest Side ="+LargestSide);
        
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double LargestPerimeter=getLargestPerimeterMultipleFiles();
        System.out.println("LargestPerimeter = "+LargestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String filename =getFileWithLargestPerimeter();
        System.out.println("file name = "+filename);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        
        pr.testPerimeterMultipleFiles();
        
        pr.testFileWithLargestPerimeter();
    }
}
