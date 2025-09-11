import java.awt.Color;

public class DrawableCircle extends DrawableShape{
    protected double radius;

    public DrawableCircle(double x, double y, java.awt.Color color, double radius){
        super(x, y, color);
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public double area() {
        double area = this.radius * this.radius * Math.PI;
        return area;
    }

    public void draw() {
        StdDraw.setPenColor(this.color);
        StdDraw.filledCircle(this.center_x, this.center_y, this.radius);;
    }

    public static void main(String[] args){
        DrawableCircle c = new DrawableCircle(0.25, 0.25, Color.RED, 0.10);
        c.draw();
        System.out.println(c.area());


        DrawableShape s = new DrawableCircle(0.75, 0.6, Color.BLUE, 0.20);
        s.draw();
        System.out.println(s.area());
    }
}
