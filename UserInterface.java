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

        frame.pack(); // sizes window to fit everything
        frame.setVisible(true); // display
    }

    private static void addNewRepo() {
        makeEmptyFrame();

        // create text field for github repo and button
        JTextField repoInputField = new JTextField(20);
        JButton addRepoButton = new JButton("add");

        // add text box and button
        frame.add(repoInputField);
        frame.add(addRepoButton);

        frame.pack(); // sizes window to fit everything
        frame.setVisible(true); // display
    }

}