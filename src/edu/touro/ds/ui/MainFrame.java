package edu.touro.ds.ui;

import edu.touro.ds.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


/**
 * The main application frame for UI of Student application
 */
public class MainFrame extends JFrame {
    protected JButton buttonAdd = new JButton("Add New Student");
    protected JButton buttonSearch = new JButton("Search Students");
    protected JButton buttonSort = new JButton("Sort Students");
    protected JButton buttonDemo = new JButton("Add Demo Students");

    protected JList<LanderStudent> listPerson = new JList<>();
    protected SwingListModel<LanderStudent> listModel;
    protected java.util.List<LanderStudent> persons = new ArrayList<>();

    /**
     * Construct the main frame of the Student application. Typically
     * instantiated by main() application method.
     */
    public MainFrame() {
        super("Student Management Application");

        initComponents();

        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Initialize the UI components of the Student App.
     */
    protected void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addPerson();
            }
        });

        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortPersons();
            }
        });

        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchPersons();
            }
        });

        buttonDemo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addDemoPersons();
            }
        });


        panelButton.add(buttonAdd);
        panelButton.add(buttonSearch);
        panelButton.add(buttonSort);
        panelButton.add(buttonDemo);

        add(panelButton);

        listPerson.setPreferredSize(new Dimension(400, 360));

        listModel = new SwingListModel<LanderStudent>(persons);
        listPerson.setModel(listModel);

        // initial test model data
        // listModel.addElement(new LanderStudent("Student, Perpetual", 2000));

        add(listPerson);
    }



    /**
     * Event handler code for adding a new person
     */
    private void addPerson() {
        StudentEntryDlg sdlg = new StudentEntryDlg();
        LanderStudent newStudent = sdlg.studentPrompt("Enter New Student Info");
        if (newStudent != null) {
            listModel.addElement(newStudent);

        }
    }

    /**
     * Event handler code for sorting all data
     */
    private void sortPersons() {
        //MJC Collections.sort(persons);
        LanderStudentUtils.bubbleSort(persons);
        listModel.fireDataChanged();
    }

    /**
     * Event handler code for when a Search is requested
     */
    private void searchPersons() {
        String personName = JOptionPane.showInputDialog(this, "Enter person lastname, firstname to search for:");

        if (personName == null) {
            return;
        }

        //Collections.sort(persons);
        LanderStudentUtils.bubbleSort(persons);

        int foundIndex = Collections.binarySearch(persons, new LanderStudent(personName, 9999));

        if (foundIndex >= 0) {
            listPerson.setSelectedIndex(foundIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Could not find the person " + personName);
        }
    }


    /**
     * Event handler code when add Demonstration data is requested
     */
    private void addDemoPersons() {
        listModel.addElements(LanderStudentUtils.generateDemoStudents());
    }
}