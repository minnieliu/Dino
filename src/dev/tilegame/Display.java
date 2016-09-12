package dev.tilegame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Minnie on 2016-07-08.
 */
public class Display {

    private JFrame frame;
    // title, width, height

    private Canvas canvas;
    // where would we draw images, and display the canvas using JFrame
    private String title;
    private int width, height;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();

    }
    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        // game may not close properly if we dont have this line of code.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ability for the user to resize the Jframe
        frame.setResizable(false);
        // the frame will pop up in the center of the screen
        frame.setLocationRelativeTo(null);
        // set visible to true to be able to see the frame
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        // stays at the width and height we give it

        frame.add(canvas);
        // resize our frame a little so that we see all of our campus
        frame.pack();


    }
    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

}
