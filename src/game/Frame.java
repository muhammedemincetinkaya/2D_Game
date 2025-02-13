package game;

import javax.swing.*;

public class Frame extends JFrame {
    public Frame(View view){
        this.add(view);                                                             //Add to view to the frame
        this.setFocusable(true);                                                    //Set the focus to the frame so the key listeners work.
        // enable the frame to quit the application
        // when the x button is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        // don't let the frame be resized
        this.setResizable(false);
        // size the frame to fit the world view
        this.pack();
        // finally, make the frame visible
        this.setVisible(true);
        //optional: draw a 1-metre grid over the view
        //view.setGridResolution(1);

    }
}
