package edu.touro.ds.ui;

import edu.touro.ds.model.LanderStudent;

import javax.swing.*;

/**
 * A dialog that can be used for adding a new student, or specifying
 * fields of a student to be searched on.
 */
public class StudentEntryDlg {
    String[] labels = {"Last Name: ", "First Name", "Birth Year", "Address: "};
    JTextField[] textFields = {new JTextField(10), new JTextField(10), new JTextField(10), new JTextField(10)};
    int numPairs = labels.length;

    JPanel p;


    //Create and populate the panel.
    public StudentEntryDlg() {
        p = new JPanel(new SpringLayout());
        for (int pair = 0; pair < numPairs; pair++) {
            JLabel l = new JLabel(labels[pair], JLabel.TRAILING);
            p.add(l);
            JTextField textField = textFields[pair];
            l.setLabelFor(textField);
            p.add(textField);
        }

        //Lay out the panel with pairs of label/input each on a separate line
        SpringUtilities.makeCompactGrid(p,
                numPairs, 2, //rows, cols
                6, 6,        //initX, initY
                6, 6);       //xPad, yPad

    }

    /**
     * prompt user to enter student info into a dialog box,
     * data returned in a student object.
     *
     * @param msg - message to display with prompt
     * @return an object filled with provided data
     */
    public LanderStudent studentPrompt(String msg) {
        LanderStudent ls = null;
        int result = JOptionPane.showConfirmDialog(null, this.p, msg,
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            ls = new LanderStudent(textFields[0].getText(), textFields[1].getText(), true, Integer.parseInt(textFields[2].getText()));
        } else {
            System.out.println("Cancelled");
        }

        return ls;
    }


    /// Test purposes only
    public static void main(String[] args) {
        StudentEntryDlg se = new StudentEntryDlg();
        LanderStudent student = se.studentPrompt("Enter student to search for");
        System.out.println("Got student: " + student);

        /**
         int result = JOptionPane.showConfirmDialog(null, se.p, "Test",
         JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
         if (result == JOptionPane.OK_OPTION) {

         // New-style with Stream
         Stream.of(se.p.getComponents())
         .filter(c -> c instanceof JTextField)
         .map(c -> ((JTextField) c).getText())
         .forEach(System.out::println);
         } else {
         System.out.println("Cancelled");
         }
         **/
    }

}
