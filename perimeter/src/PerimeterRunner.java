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

    public void testPerimeter() {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }

    public static void main(String[] args) {
        PerimeterRunner pRunner = new PerimeterRunner();
        pRunner.testPerimeter();
    }
}
