package turtle;

import java.util.Vector;

/**
 *
 * @author biankatpas
 */
public class Point {
    
    private int x;
    private int y;
    
    public Point() {
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point sum(Vector<Point> points) {
        Point sum = new Point();
        
        for (Point point : points) {
            sum.setX(sum.getX() + point.getX());
            sum.setY(sum.getY() + point.getY());
        }
        return sum;
    }
    
    public Point mult(int scale) {
        Point mult = new Point();
        mult.setX(x * scale);
        mult.setY(y * scale);
        return mult;
    }
    
    public void print() {
        System.out.println(x + "," + y);
    }
}
