public class DrawableCircle extends DrawableShape{
    protected double radius;
    double center_x;
    double center_y;
    java.awt.Color color;

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

    }
}
