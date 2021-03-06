//Create a Polygon class. A polygon is a closed shape with lines joining the corner points.
//You will keep the points in an array list. Use object of java.awt.Point for the point.

//Polygon will have as an instance variable an ArrayList of Points to hold the points
//The constructor takes no parameters but initializes the instance variable
//
//The add method adds a Point to the polygon
//
//The perimeter method returns the perimeter of the polygon
//
//The draw method draws the polygon by connecting consecutive points and then
//connecting the last point to the first.
//
//No methods headers or javadoc is provided this time. You get to try your hand at writing a class almost from scratch
//
//For the draft, finish the constructor.
//Have the perimeter method return 0 and have the draw mwthod draw a
//line from point 0, 0 to point 30, 40
//

import java.util.ArrayList;
import java.awt.Point;
public class Polygon
{
    // TODO: provide the required constructor, instance variable, and methods
    ArrayList<Point> points;

    public Polygon() {
        points = new ArrayList<Point>();
    }

    public double perimeter()
    {
        double peri = 0.0;
        double sideLength = 0.0;
        int i = 0;
        int m = points.size() - 1;
        for (i = 0; i < m ; i++)
        {
            sideLength = Math.sqrt( Math.pow(points.get(i).getX() - points.get(i + 1).getX(), 2) + Math.pow(points.get(i).getY() - points.get(i + 1).getY(), 2) );
            peri+= sideLength;
        }
        double lastSideLength = Math.sqrt( Math.pow(points.get(0).getX() - points.get(m).getX(), 2) + Math.pow(points.get(0).getY() - points.get(m).getY(), 2) );
        peri = peri + lastSideLength;

        return peri;
    }

    public void draw()
    {
        Point first, second;

        for(int i = 0; i < points.size() - 1; i++)
        {
            first = points.get(i);
            second = points.get(i+1);

            Line line = new Line(first.getX(), first.getY(), second.getX(), second.getY());
            line.draw();
        }

        first = points.get(0);
        second = points.get(points.size() - 1);
        Line line = new Line(first.getX(), first.getY(), second.getX(), second.getY());
        line.draw();
    }

    public void add(Point newPoint) {
        points.add(newPoint);
    }
}
