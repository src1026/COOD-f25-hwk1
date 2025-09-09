import java.awt.Color;

public abstract class DrawableShape {
    double center_x;
    double center_y;
    java.awt.Color color;

    public DrawableShape(double x, double y, java.awt.Color color) {
        this.center_x = x;
        this.center_y = y;
        this.color = color;
    }

    public double getCenterX() {
        return this.center_x;
    }

    public double getCenterY() {
        return this.center_y;
    }

    public java.awt.Color getColor() {
        return this.color;
    }

    public abstract double area();
    public abstract void draw();

}
