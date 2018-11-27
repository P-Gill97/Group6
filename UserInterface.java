import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Exception;

public class UserInterface {
    private static JFrame frame;
    private final static String frameName = "Group 6 GitHub Metrics";

    // START TEST CODE //////////////////////////////////////
    public static void main(String[] args) {

        run();

    }
    // END TEST CODE ////////////////////////////////////////


    /**
     * This will intake the database of git repos
     * Then it will run the JFrames
     */
    public static void run() {
        try {
            init();
        } catch (Exception e) {
            // catch works on init exceptions, but doesn't catch entire program?
            e.printStackTrace(); // print to console
            handleError(e);
        }
    }

    /**
     * UTILITY FUNCTION
     *
     * This function will be used any time the frame needs to be wiped
     * it remakes a new frame in the exact position of the last one.
     * This is the case even if the user manually moves the frame.
     */
    private static void makeEmptyFrame() {
        // initialize location
        Point location = new Point();
        boolean existingFrame = false;

        // check if frame already exists
        if (frame != null) {
            existingFrame = true;

            // get old frame's location (if exists, otherwise null?)
            location = frame.getLocation();

            frame.dispose();
        }

        frame = new JFrame(frameName); // name can be changed later. Or this is fine.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (existingFrame) {
            // set location to the same as previous location
            frame.setLocation((int) location.getX(), (int) location.getY());
        } else {
            // set location to center screen
            setFrameCentered();
        }

    }

    /**
     * UTILITY FUNCTION
     *
     * This will set the frame to the center of the user's screen.
     */
    private static void setFrameCentered() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    /**
     * This function creates the initial frame
     * it will consist of two buttons only
     * one will allow the user to input a new github repo
     * the other will allow the user to select between repos that they already have used
     */
    private static void init() throws Exception {
        makeEmptyFrame();

        // create buttons
        // ask user if they want to add new repo
        JButton newRepo = new JButton("Add new repo");
        frame.add(newRepo);
        JButton oldRepoList = new JButton("List of Repo Metrics");
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

    /**
     * resets frame to allow user to add new github repo to the database.
     * will then go to list of repos to get metrics.
     */
    private static void addNewRepo() {
        makeEmptyFrame();

        // create text field for github repo and button
        JLabel label = new JLabel();
        JTextField repoInputField = new JTextField(20);
        JButton addRepoButton = new JButton("add");

        label.setText("Enter GitHub repo URL:");

        // add frame elements
        JPanel panel = new JPanel();
        // set layout as a grid of width 2, height variable
        panel.setLayout(new GridLayout(0,1));
        frame.add(panel);

        // add text box and button
        panel.add(label);
        panel.add(repoInputField);
        panel.add(addRepoButton);

        frame.pack();
        frame.setVisible(true); // display

        addRepoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // add text box repo to database
                /*
                    NEED TO ACCESS AND ADD TO REPO DATABASE
                 */

                repoListBox();
            }
        });
    }

    /**
     * takes in URL for repo and deletes it from database
     *
     * @param repoAddress
     */
    private static void deleteRepo(String repoAddress) {

    }

    /**
     * this is the main frame. It will display a drop down list
     * of the repos. It will also display metrics and a button
     * that allows the user to refresh the metrics
     */
    private static void repoListBox() {
        makeEmptyFrame();

        // drop down list of repos
        /*
            NEED TO ACCESS OLD REPOS
            reposArray will be filled from database
         */
        String[] reposArray = {"repo 1", "https://github.com/CSC131Fall2018/Group6", "repo 3"};

        JComboBox<String> repoDropdownList = new JComboBox<String>(reposArray);

        // button to run metrics
        JButton runMetricsButton = new JButton("Run Metrics");
        // button to go back to addNewRepo()
        JButton addNewRepoButton = new JButton("Add New Repo");
        // button to delete this repo
        JButton deleteRepoButton = new JButton("Delete This Repo");
        // metrics
        // metrics labels
        JLabel linesHeader = new JLabel();
        linesHeader.setText("Lines");
        JLabel wordsHeader = new JLabel();
        wordsHeader.setText("Words");


        // add frame elements
        JPanel panel = new JPanel();
        // set layout as a grid of width 2, height variable
        panel.setLayout(new GridLayout(0,2));

        // first row
        frame.add(panel);
        panel.add(repoDropdownList);
        panel.add(runMetricsButton);
        // second row, buttons
        panel.add(addNewRepoButton);
        panel.add(deleteRepoButton);



        // third row, metrics headers
        panel.add(linesHeader);
        panel.add(wordsHeader);

        frame.pack();

        frame.setVisible(true);

        // action listeners on buttons
        addNewRepoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                addNewRepo();
            }
        });

        deleteRepoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                deleteRepo(repoDropdownList.getSelectedItem().toString());
            }
        });

        runMetricsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // run metrics and update
                /*
                    NEED ACCESS TO METRICS
                 */
            }
        });
    }

    /**
     * this will take any exceptions and open a jframe
     * that will display the error message to user
     *
     * @param e is the exception that is thrown
     */
    private static void handleError(Exception e) {
        // error caught, close everything, make empty frame
        makeEmptyFrame();

        JLabel errorHeader = new JLabel();
        errorHeader.setText("Caught an error: ");
        JLabel errorText = new JLabel();
        errorText.setText("<html>"+ e.toString() +"</html>");

        // set location and bounds of text
        errorHeader.setBounds(1, 1, 100, 100);
        errorText.setBounds(100, 100, 100, 100);

        frame.add(errorHeader);
        frame.add(errorText);

        frame.setSize(e.toString().length() * 10, 200);
        frame.setVisible(true);
    }

}