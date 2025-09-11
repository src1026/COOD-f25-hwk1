import java.awt.*;

public class DrawableRectangle extends DrawableShape {
    double width;
    double height;

    public DrawableRectangle(double x, double y, java.awt.Color color, double width, double height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }
    public double area() {
        double area = this.width * this.height;
        return area;
    }

    public void draw() {
        StdDraw.setPenColor(this.color);
        StdDraw.filledRectangle(this.center_x, this.center_y, this.width / 2, this.height / 2);
    }

    public static void main(String[] args) {
        DrawableShape r1 = new DrawableRectangle(0.25, 0.25, Color.RED, 0.10, 0.20);
        r1.draw();
        System.out.println(r1.area());


        DrawableShape r2 = new DrawableRectangle(0.75, 0.6, Color.BLUE, 0.20, 0.30);
        r2.draw();
        System.out.println(r2.area());
    }
}
