import java.awt.Color;

public class DrawableRectangle extends DrawableShape {
    double width;
    double height;

    public DrawableRectangle(double x, double y, java.awt.Color color, double width, double height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double area() {
        return this.getWidth() * this.getHeight();
    }

    public void draw() {
        StdDraw.setPenColor(this.getColor());
        StdDraw.filledRectangle(this.getCenterX(), this.getCenterY(), this.getWidth() / 2, this.getHeight() / 2);
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
