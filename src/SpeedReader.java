/**
 * Program to implement RSVP speed reader using StdDraw library.
 *
 * This assignment originally created by Peter-Michael Osera at University of Pennsylvania.
 * 
 * @author Chris Murphy
 */

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SpeedReader {

    /*
    This method is responsible for updating the text in the window for the speed reader.
    You will need to change the parameters as you complete this part of the assignment.
     */
    public static void show(String filename, int rate) {

        // this sets up the window... don't forget to call it!
        setup();
        if (rate <= 0) {
            System.out.println("Please specify a positive integer!");
            return;
        }
        int delay = 60000 / rate;

        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext()) {
                String word = scanner.next();
                displayWord(word);
                // this displays the text
                StdDraw.show();

                // this causes the program to wait for 500ms
                StdDraw.pause(delay);

                // this removes everything that is being displayed
                StdDraw.clear();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error reading file");
        }

    }

    public static void setPenColor(java.awt.Color color) {
        String colorString = "";
        if (color.equals(java.awt.Color.BLACK)) {
            colorString = "Black";
        } else if (color.equals(java.awt.Color.RED)) {
            colorString = "Red";
        } else {
            colorString = "Other";
        }
        System.out.println("Color: " + colorString);
        StdDraw.setPenColor(color);
    }

    public static void printString(String text, double x, double y) {
        System.out.println(text);
        // System.out.println(x + " " + y);
        StdDraw.text(x, y, String.valueOf(text));
    }

    public static void displayWord(String word){
        // this helper function display a word,
        // with its middle char in red and rest in black
        if (word.length() % 2 == 1){
            // display entire word in black
            setPenColor(StdDraw.BLACK);
            printString(word, 50, 50);
            // then overlap middle char in red
            Character anchorChar = word.charAt(word.length()/2);
            setPenColor(StdDraw.RED);
            printString(String.valueOf(anchorChar), 50, 50);
        } else {
            setPenColor(StdDraw.BLACK);
            printString(word, 46.1, 50);
            Character anchorChar = word.charAt(word.length()/2);
            setPenColor(StdDraw.RED);
            printString(String.valueOf(anchorChar), 50, 50);
        }
    }

    /*
    This method sets up the window for the speed reader.
    You should not need to change anything here!
    Please speak to the Instructor if you think any change is necessary.
     */
    private static void setup() {
        // this creates a window of 800x600 pixels
        StdDraw.setCanvasSize(800, 400);

        // this sets the scale of the x- and y-axis to be from 0 to 100
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);

        // this enables animation so that things don't appear jittery
        StdDraw.enableDoubleBuffering();

        // this sets the drawing color to black
        StdDraw.setPenColor(StdDraw.BLACK);

        // this sets the text font to be fixed-width
        StdDraw.setFont(new java.awt.Font("COURIER", java.awt.Font.BOLD, 100));
    }


    public static void main(String[] args) {
        // 1. check number of arguments
        if  (args.length != 2) {
            System.out.println("Please specify the file name and wpm!");
            return;
        }
        String filename = args[0];
        int rate;

        // 2. check positive integer
        try {
            rate = Integer.parseInt(args[1]);
            if (rate <= 0) {
                System.out.println("Please specify a positive wpm");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please specify a positive wpm");
            return;
        }

        // 3. try opening with the file
        File file = new File(filename);
        if (!file.exists() || !file.canRead()) {
            System.out.println("Error reading file");
            return;
        }

        show(filename, rate);
    }
    
}
