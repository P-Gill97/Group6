import javax.swing.*;
import java.awt.*;

public class UserInterface {
    private static JFrame frame;

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
        frame = new JFrame("Group 6 GitHub Metrics"); // name can be changed later. Or this is fine.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void init() {
        makeEmptyFrame();

        //frame.setPreferredSize(new Dimension(400, 300)); // may be useless. Keeping in case it's needed

        // create buttons
        // ask user if they want to add new repo
        JButton newRepo = new JButton("Add new repo");
        frame.add(newRepo);
        JButton oldRepoList = new JButton("List of old repos");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.add(oldRepoList);

        frame.pack(); // sizes window to fit everything
        frame.setVisible(true); // display
    }

    private static void addNewRepo() {
        makeEmptyFrame();

        // add text field for github repo

        JTextField repoInputField = new JTextField(20);


        frame.add(repoInputField);
    }

}