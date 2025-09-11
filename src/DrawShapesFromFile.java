import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;

public class DrawShapesFromFile {

    public static DrawableShape[] readFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int n = scanner.nextInt();
            scanner.nextLine();
            DrawableShape[] shapes = new DrawableShape[n];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                char shape = parts[0].charAt(0);
                double x = Double.parseDouble(parts[1]);
                double y = Double.parseDouble(parts[2]);
                Color color = getColor(parts[3]);

                if (shape == 'c'){
                    double radius = Double.parseDouble(parts[4]);
                    shapes[i] = new DrawableCircle(x, y, color, radius);
                } else if (shape == 'r') {
                    double width  = Double.parseDouble(parts[4]);
                    double height = Double.parseDouble(parts[5]);
                    shapes[i] = new DrawableRectangle(x, y, color, width, height);
                }
            }
            return shapes;

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
            return new DrawableShape[0];
        }
    }

    private static Color getColor(String s) {
        switch (s.toLowerCase()) {
            case "red": return Color.RED;
            case "blue": return Color.BLUE;
            case "green": return Color.GREEN;
            default: return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please specify input file!");
            return;
        }
        DrawableShape[] shapes = readFile(args[0]);
        for (DrawableShape s : shapes) {
            if (s != null) s.draw();
        }
    }
}
