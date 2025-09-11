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
        return this.getRadius() * this.getRadius() * Math.PI;
    }

    public void draw() {
        StdDraw.setPenColor(this.getColor());
        StdDraw.filledCircle(this.getCenterX(), this.getCenterY(), this.getRadius());;
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
