package edu.touro.ds;

import edu.touro.ds.ui.MainFrame;

import javax.swing.*;

/**
 * Main class for application that displays students and allows for the adding, searching
 * and sorting of students.
 * <p>
 * Launches the MainFrame in the Swing AWT event thread
 */
public class SwingStudentApp {

    public static void main(String[] args) {

        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            // handle exception
        }

        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}