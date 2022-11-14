import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

public class PerimeterRunner {
    public double getPerimeter(Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0;
        // Start with prevPoint = the last point 
        Point prevPoint = s.getLastPoint();
        // For each point currPoint in the shape,
        for (Point currPoint : s.getPoints()) {
            // Find distance from prevPoint to currPoint 
            double distance = prevPoint.distance(currPoint);
            // Update the totalPerim = totalPerim + distance
            totalPerim = totalPerim + distance;
            // Update the prevPoint to be currPoint
            prevPoint = currPoint;
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

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);

        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);

        int numOfPoints = getNumPoints(s);
        System.out.println("Num of Points: " + numOfPoints);

        double avgLength = getAverageLength(s);
        System.out.println("Average length: " + avgLength);
    }

    public static void main(String[] args) {
        PerimeterRunner pRunner = new PerimeterRunner();
        pRunner.testPerimeter();
    }
}
