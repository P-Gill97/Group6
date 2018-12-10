import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.lang.Exception;
import java.util.*;
import java.util.ArrayList;

public class UserInterface {
    private static JFrame frame;
    private final static String frameName = "Group 6 GitHub Metrics";
    private static JLabel blankLabel = new JLabel("");
    private static ArrayList<String> reposList = new ArrayList<>();

    public static void main(String[] args)
    {
        run();
    }

    /**
     * This will intake the database of git repos
     * Then it will run the JFrames
     */
    public static void run(){
        try {
            File repos = new File("repos.txt");
            repos.createNewFile();
            File history = new File("history.txt");
            history.createNewFile();

            init();
        } catch (Exception e) {
            // catch works on init exceptions, but doesn't catch entire program?
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
        Rectangle size = new Rectangle(); // can be used to base new frame off previous frame size
        boolean existingFrame = false;

        // check if frame already exists
        if (frame != null) {
            existingFrame = true;

            // get old frame's location (if exists, otherwise null?)
            location = frame.getLocation();
            size = frame.getBounds(); // can be used to base new frame off previous frame size

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
    private static void setFrameCentered(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    /**
     * This function creates the initial frame
     * it will consist of two buttons only
     * one will allow the user to input a new github repo
     * the other will allow the user to select between repos that they already have used
     */
    private static void init() throws Exception{
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
        oldRepoList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                // add text box repo to database

                try {
                    repoListBox();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        JLabel label = new JLabel("Enter GitHub repo URL:");
        JTextField repoInputField = new JTextField(20);
        JButton addRepoButton = new JButton("Add");
        JButton cancelButton = new JButton("Cancel");

        // add frame elements
        JPanel panel = new JPanel();
        // set layout as a grid of width 2, height variable
        panel.setLayout(new GridLayout(0, 2));
        frame.add(panel);

        // add text box and button
        panel.add(label);
        panel.add(repoInputField);
        panel.add(addRepoButton);
        panel.add(cancelButton);

        frame.pack();
        frame.setVisible(true); // display

        addRepoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String string = repoInputField.getText().trim();
                try {
                    FileWriter fw = new FileWriter("repos.txt", true);
                    fw.write(string + "\n");
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    repoListBox();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    repoListBox();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * takes in URL for repo and deletes it from database
     *
     * @param repoAddress
     */
    private static void deleteRepo(String repoAddress){
        makeEmptyFrame();

        JLabel header = new JLabel("<html>&nbsp;Would you like to delete the following repo?&nbsp;&nbsp;</html>");
        JLabel repoAddressLabel = new JLabel("<html><li>" + repoAddress + "&nbsp;&nbsp;</html>");
        JButton deleteButton = new JButton("Delete");
        JButton cancelButton = new JButton("Cancel");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        frame.add(panel);

        panel.add(header);
        panel.add(repoAddressLabel);
        panel.add(deleteButton);
        panel.add(cancelButton);

        frame.pack();
        frame.setVisible(true);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                File inputFile = new File("repos.txt");
                File tempFile = new File("temp.txt");

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                    String repoToDelete = repoAddress;
                    String currentLine;
                    while((currentLine = reader.readLine()) != null) {
                        String trimmedLine = currentLine.trim();
                        if(trimmedLine.equals(repoToDelete)) continue;
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                    writer.close();
                    reader.close();
                    System.out.println(inputFile.delete());
                    System.out.println(tempFile.renameTo(inputFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }




                try {
                    repoListBox();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    repoListBox();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * this is the main frame. It will display a drop down list
     * of the repos. It will also display metrics and a button
     * that allows the user to refresh the metrics
     */
    private static void repoListBox() throws IOException {
        makeEmptyFrame();

        Scanner reader;
        try {
            reader = new Scanner(new File("repos.txt"));
        } catch(Exception e) {
            System.out.println("file not found, didn't create?");
            throw new IOException();
        }

        reposList = new ArrayList<>();
        while (reader.hasNextLine()) {
            String temp = reader.nextLine();
            reposList.add(temp);
        }

        Collections.reverse(reposList);
        JComboBox<String> repoDropdownList = new JComboBox<>(reposList.toArray(new String[reposList.size()]));

        // button to run metrics
        JButton runMetricsButton = new JButton("Run Metrics");
        // button to go back to addNewRepo()
        JButton addNewRepoButton = new JButton("Add New Repo");
        // button to delete this repo
        JButton deleteRepoButton = new JButton("Delete This Repo");
        // button to go to history
        JButton historyRepoButton = new JButton("Get Repo History");

        // metrics
        // metrics labels
        JLabel linesHeader = new JLabel("Lines");
        JLabel wordsHeader = new JLabel("Words");
        JLabel charsHeader = new JLabel("Characters");
        JLabel sourceHeader = new JLabel("Source Lines");
        JLabel commentHeader = new JLabel("Comment Lines");

        // metrics numbers
        JLabel lines = new JLabel("-");
        JLabel words = new JLabel("-");
        JLabel chars = new JLabel("-");
        JLabel sources = new JLabel("-");
        JLabel comments = new JLabel("-");


        // add frame elements
        JPanel panel = new JPanel();
        // set layout as a grid of width 2, height variable
        panel.setLayout(new GridLayout(0,2));

        // first row
        frame.add(panel);
        panel.add(repoDropdownList);
        panel.add(runMetricsButton);

        //  buttons
        panel.add(addNewRepoButton);
        panel.add(deleteRepoButton);
        panel.add(historyRepoButton);
        panel.add(blankLabel); //blank spot

        // metrics definitions
        panel.add(linesHeader);
        panel.add(wordsHeader);



        panel.add(lines);
        panel.add(words);
        panel.add(charsHeader);
        panel.add(sourceHeader);
        panel.add(chars);
        panel.add(sources);
        panel.add(commentHeader);
        JLabel blankLabel2 = new JLabel("");
        panel.add(blankLabel2);
        panel.add(comments);

        frame.pack();

        frame.setVisible(true);



        // action listeners on buttons
        addNewRepoButton.addActionListener(new ActionListener(){
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
                retMets temp = new retMets();
                try {
                    ArrayList metrics = temp.getMetrics(repoDropdownList.getSelectedItem().toString());
                    lines.setText(String.valueOf(((SingleFileMetrics) metrics.get(0)).getLines()));
                    words.setText(String.valueOf(((SingleFileMetrics) metrics.get(0)).getWord()));
                    chars.setText(String.valueOf(((SingleFileMetrics) metrics.get(0)).getCharacters()));
                    sources.setText(String.valueOf(((SingleFileMetrics) metrics.get(0)).getSourcelines()));
                    comments.setText(String.valueOf(((SingleFileMetrics) metrics.get(0)).getCommentlines()));

                    String historyLine = ((SingleFileMetrics) metrics.get(0)).getDate()+" "+((SingleFileMetrics) metrics.get(0)).getUrl()+" "+metrics.get(0)+" "+((SingleFileMetrics) metrics.get(0)).getWord()+" "+((SingleFileMetrics) metrics.get(0)).getCharacters()+" "+((SingleFileMetrics) metrics.get(0)).getSourcelines()+" "+((SingleFileMetrics) metrics.get(0)).getCommentlines();

                    System.out.println(historyLine);
                } catch (Exception e) {
                    e.printStackTrace();
                    handleError(e);
                }



            }
        });

        historyRepoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    repoHistoryBox(repoDropdownList.getSelectedItem().toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    /**
     * this will take in the repo that is selected in repoListBox()
     * and get a history of progress for the repo's metrics
     *
     * @param repoToGet is from the dropdown in repoListBox()
     */
    private static void repoHistoryBox(String repoToGet) throws FileNotFoundException {
        makeEmptyFrame();

        // row one, header
        JLabel header = new JLabel("<html>&nbsp;&nbsp;Repo History:&nbsp;&nbsp;</html>");
        JLabel repoLabel = new JLabel("<html>" + repoToGet + "&nbsp;&nbsp;</html>");
        JButton backButton = new JButton("Back");

        // row two, metrics headers
        // date/time, lines, words, chars, source lines, comment lines
        JLabel timestamp = new JLabel("<html>&nbsp;&nbsp;Timestamp</html>");
        JLabel lines = new JLabel("Lines");
        JLabel words = new JLabel("Words");
        JLabel chars = new JLabel("Characters");
        JLabel sources = new JLabel("Source Lines");
        JLabel comments = new JLabel("<html>Comment Lines&nbsp;&nbsp;</html>");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,6));
        frame.add(panel);

        // adding row one
        panel.add(header);
        panel.add(repoLabel);
        for (int i = 0; i < 3; i++) {
            JLabel blankLabelRepeater = new JLabel("");
            panel.add(blankLabelRepeater);
        }
        panel.add(backButton);

        // adding row two
        panel.add(timestamp);
        panel.add(lines);
        panel.add(words);
        panel.add(chars);
        panel.add(sources);
        panel.add(comments);

        // add metrics history
        Scanner reader = new Scanner(new File("history.txt"));
        boolean found = false;
        while (reader.hasNextLine()) {
            String temp = reader.nextLine();
            if (temp.equalsIgnoreCase(repoToGet)) {
                found = true;
                break;
            } else continue;
        }

        // found repo
        while (reader.hasNextLine() && found) {
            String[] historyLine = reader.nextLine().split("\\s+");
            if (historyLine[0].equalsIgnoreCase("EOR")) {
                break; // previous was last
            }

            panel.add(new JLabel("<html>&nbsp;&nbsp;" + historyLine[0] + "</html>"));
            for (int i = 1; i < historyLine.length; i++) {
                panel.add(new JLabel(historyLine[i]));
            }
        }

        frame.pack();
        setFrameCentered();
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    repoListBox();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    /**
     * this will take any exceptions and open a jframe
     * that will display the error message to user
     *
     * @param e is the exception that is thrown
     */
    private static void handleError(Exception e){
        // error caught, close everything, make empty frame
        makeEmptyFrame();
        e.printStackTrace(); // print to console

        JLabel errorHeader = new JLabel("<html>&nbsp;Caught an error:&nbsp;</html>");
        JLabel errorText = new JLabel("<html>&nbsp;"+ e.toString() +"&nbsp;</html>");
        JButton restartButton = new JButton("Restart Program");
        JButton exitProgramButton = new JButton("Exit Program");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        panel.add(errorHeader);
        panel.add(errorText);
        panel.add(restartButton);
        panel.add(exitProgramButton);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        // button listeners

        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // add text box repo to database
                try {
                    init();
                } catch (Exception e) {

                    handleError(e);
                }
            }
        });

        exitProgramButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // add text box repo to database
                frame.dispose();
                System.exit(0);
            }
        });
    }

}