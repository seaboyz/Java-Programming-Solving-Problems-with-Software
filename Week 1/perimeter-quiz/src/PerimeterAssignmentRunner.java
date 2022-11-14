import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

public class PerimeterAssignmentRunner {
    public double getPerimeter(Shape s) {
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

    public int getNumPoints(Shape s) {
        // start with numOfPoints = 0
        int numOfPoints = 0;
        // for each point in the shape
        for (Point point : s.getPoints()) {
            // update the numOfPoints = numOfPoints + 1
            numOfPoints = numOfPoints + 1;
        }
        // return totalPoints
        return numOfPoints;
    }

    public double getAverageLength(Shape s) {
        // average length = perimeter / numOfSides
        // numOfSides = numOfPoints
        double avgLength = getPerimeter(s) / getNumPoints(s);
        return avgLength;
    }

    public double getLongestSide(Shape s) {
        // start with longestSide = 0
        double longestSide = 0;
        // start with the prevPoint = the last point of s
        Point prevPoint = s.getLastPoint();
        // for each point of Shape s as currPoint
        for (Point currPoint : s.getPoints()) {
            // calculate the distance from the currPoint to prevPoint 
            double distance = currPoint.distance(prevPoint);
            // if distance > longestSide 
            if (distance > longestSide) {
                // longestSide = distance
                longestSide = distance;
            }
            // else no change
        }
        // return the the longestSide
        return longestSide;
    }

    public double getLargestX(Shape s) {
        // start with the largestX = Double.NEGATIVE_INFINITY
        double largestX = Double.NEGATIVE_INFINITY;
        // for each current point of the shape
        for (Point currPoint : s.getPoints()) {
            double currX = currPoint.getX();
            // if x of the current point > the largestX 
            if (currX > largestX) {
                // update the largestX
                largestX = currX;
            }
            // else do nothing
        }
        // return largestX
        return largestX;

    }

    public double getLargestPerimeterMultipleFiles(DirectoryResource dr) {
        // start largestq = 0
        double largestPerimerter = 0;
        // for each file of the director 

        for (File f : dr.selectedFiles()) {
            // convert File to FileResource
            FileResource fResource = new FileResource(f);
            // build a Shape s with the file resourse
            Shape s = new Shape(fResource);
            // get the currPerimeter of the Shape s
            double currPerimeter = getPerimeter(s);
            // if the currPerimeter > largestPerimerter
            if (currPerimeter > largestPerimerter) {
                // update largestPerimerter = currPerimeter
                largestPerimerter = currPerimeter;
            }
            // else do nothing 
        }

        // return the largestPerimerter
        return largestPerimerter;
    }

    public String getFileWithLargestPerimeter(DirectoryResource dr) {
        // Start with the File fileWithTheLargestPerimeter = null
        File fileWithTheLargestPerimeter = null;
        // Start with the largestPerimerter = Double.NEGATIVE_INFINITY
        double largestPerimerter = Double.NEGATIVE_INFINITY;
        // for each currFile of the DirectoryResource dr
        for (File currFile : dr.selectedFiles()) {
            // build a Shape s from the file
            FileResource fr = new FileResource(currFile);
            Shape s = new Shape(fr);
            // get the perimeter of the Shape s
            double currPerimeter = getPerimeter(s);
            // if cuurPerimeter > largestPerimerter
            if (currPerimeter > largestPerimerter) {
                // update the largestPerimerter = currPerimeter
                largestPerimerter = currPerimeter;
                // update the largestPerimerter corresponding file fileWithTheLargestPerimeter = currFile 
                fileWithTheLargestPerimeter = currFile;
            }
            // else do nothing
        }
        // return the file name
        return fileWithTheLargestPerimeter.getName();
    }

    public void testAverageLength() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double averageLength = getAverageLength(s);
        System.out.println("Average Length: " + averageLength);
    }

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }

    public void testLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();

        double largestPerimerter = getLargestPerimeterMultipleFiles(dr);

        System.out.println("Largest perimeter: " + largestPerimerter);
    }

    public void testFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        String fileName = getFileWithLargestPerimeter(dr);
        System.out.println("File with the largest perimeter: " + fileName);
    }

    public void testLongestSide() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double longestSide = getLongestSide(s);
        System.out.println("Longest Side: " + longestSide);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle() {
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0, 0));
        triangle.addPoint(new Point(6, 0));
        triangle.addPoint(new Point(3, 6));
        for (Point p : triangle.getPoints()) {
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = " + peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main(String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
    }
}
