import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface {
    private static JFrame frame;
    private final static String frameName = "Group 6 GitHub Metrics";

    // START TEST CODE //////////////////////////////////////
    public static void main(String[] args) {
        run();
    }
    // END TEST CODE ////////////////////////////////////////



    public static void run() {
        // need to input database
        init();
        // call to get metrics?
    }

    private static void makeEmptyFrame() {
        frame.dispose();
        frame = new JFrame(frameName); // name can be changed later. Or this is fine.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This function creates the initial frame
     * it will consist of two buttons only
     * one will allow the user to input a new github repo
     * the other will allow the user to select between repos that they already have used
     */
    private static void init() {
        frame = new JFrame(frameName); // name can be changed later. Or this is fine.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.setPreferredSize(new Dimension(400, 300)); // may be useless. Keeping in case it's needed

        // create buttons
        // ask user if they want to add new repo
        JButton newRepo = new JButton("Add new repo");
        frame.add(newRepo);
        JButton oldRepoList = new JButton("List of old repos");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(oldRepoList);

        // add newRepo button listener
        newRepo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                addNewRepo();
            }
        });

        // go straight to previous list
        oldRepoList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // add text box repo to database

                repoListBox();
            }
        });

        frame.pack(); // sizes window to fit everything
        frame.setVisible(true); // display
    }

    private static void addNewRepo() {
        makeEmptyFrame();

        // create text field for github repo and button
        JLabel label = new JLabel();
        JTextField repoInputField = new JTextField(20);
        JButton addRepoButton = new JButton("add");

        label.setText("Enter GitHub repo URL:");
        label.setBounds(10, 10, 100, 100);
        addRepoButton.setBounds(100, 100, 140, 40);
        repoInputField.setBounds(110, 50, 130, 30);


        // add text box and button
        frame.add(repoInputField);
        frame.add(addRepoButton);
        frame.add(label);

        frame.setSize(300, 300);
        frame.setLayout(null);

        frame.setVisible(true); // display

        addRepoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // add text box repo to database

                repoListBox();
            }
        });
    }

    private static void repoListBox() {

    }

}