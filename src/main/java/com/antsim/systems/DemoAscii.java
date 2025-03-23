/*
package com.antsim.systems;

import asciiPanel.AsciiFont;
import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DemoAscii {
    // Declare variables for the AsciiPanel terminal, JFrame, random generator, and the title string
    private static AsciiPanel terminal;
    private static JFrame frame;
    private static Random rand;
    private static String TITLE = "Demo AsciiPanel";

    public static void main(String[] args) {
        // Initialize the frame, terminal, and random number generator
        // JFrame is the container for the terminal
        frame = new JFrame(TITLE);  // Create a new JFrame with the title "Demo AsciiPanel"
        terminal = new AsciiPanel();  // Create a new AsciiPanel instance (the terminal)
        rand = new Random();  // Initialize the random generator for background color selection

        // Write the title in the center of the terminal at row 2
        terminal.writeCenter(TITLE, 2);

        // Write the text "Red color" in red at row 5
        terminal.writeCenter("Red color", 5, AsciiPanel.red);

        // Random generation loop: write spaces with random background colors
        // Iterate through a specific region (from x = 15 to 45, y = 10 to 20)
        for (int x = 15; x < 45; x++) {
            for (int y = 10; y < 20; y++) {
                // Randomly choose a background color (either blue or green)
                if (rand.nextInt(2) == 0) {
                    terminal.setDefaultBackgroundColor(AsciiPanel.blue);  // Set background color to blue
                } else {
                    terminal.setDefaultBackgroundColor(AsciiPanel.green);  // Set background color to green
                }

                // Write a space character (" ") at the current position (x, y) with the selected background color
                terminal.write(" ", x, y);
            }
        }

        // Add the terminal to the frame
        // Set the frame properties: make it non-resizable, pack it to fit the terminal, and set default close operation
        frame.add(terminal);
        frame.setResizable(false);  // Disable resizing of the window
        frame.pack();  // Adjust the window size to fit the terminal size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Ensure the application exits when the window is closed
        frame.setVisible(true);  // Make the window visible to the user
    }
}
*/