import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class NewUserInterface extends JFrame implements ActionListener {
    private static JPanel screenController;
    private static JButton newRepo, oldRepolist, addRepoButton, cancelDeleteButton, deleteButton, cancelButton, runMetricsButton, addNewRepoButton,deleteRepoButton;
    private  JComboBox<String> repoDopdownList;
    private static String[] reposArray = {"repo 1", "https://github.com/CSC131Fall2018/Group6", "repo 3"};
    private static JTextField repoInputField;

    public NewUserInterface(){
        super("Group 6 GitHub Metrics"); //Title of program
        setLayout(new GridLayout(0,1));
        pack();
        setSize(650,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //First Screen - Screen when program is opened
        JPanel defaultScreen = new JPanel(new GridLayout(1,2));
        newRepo = new JButton("Add new repo");
        oldRepolist = new JButton("List of Repo Metrics");
        defaultScreen.add(newRepo);
        defaultScreen.add(oldRepolist);

        newRepo.addActionListener(this);
        oldRepolist.addActionListener(this);

        //Second screen - Screen when "Add repo" is chosen
        JPanel addRepoScreen = new JPanel(new GridLayout(0,2));
        JLabel label = new JLabel();
        JTextField repoInputField = new JTextField(20);
        addRepoButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        label.setText("Enter Github repo URL:");

        addRepoScreen.add(label);
        addRepoScreen.add(repoInputField);
        addRepoScreen.add(addRepoButton);
        addRepoScreen.add(cancelButton);

        addRepoButton.addActionListener(this);
        cancelButton.addActionListener(this);

        //Third Screen - The main screen
        JPanel mainScreen = new JPanel(new GridLayout(0,2));
        repoDopdownList = new JComboBox<>(reposArray);
        runMetricsButton = new JButton("Run Metrics");
        addNewRepoButton = new JButton("Add New Repo");
        deleteRepoButton = new JButton("Delete this Repo");

        JLabel linesHeader = new JLabel("Lines");
        JLabel wordsHeader = new JLabel("Words");

        //first row
        mainScreen.add(repoDopdownList);
        mainScreen.add(runMetricsButton);

        //second row
        mainScreen.add(addNewRepoButton);
        mainScreen.add(deleteRepoButton);

        //third row
        mainScreen.add(linesHeader);
        mainScreen.add(wordsHeader);

        addNewRepoButton.addActionListener(this);
        deleteRepoButton.addActionListener(this);
        runMetricsButton.addActionListener(this);

        //Fourth Screen - Delete Screen
        JPanel deleteScreen = new JPanel(new GridLayout(0,2));
        deleteButton = new JButton("Delete");
        cancelDeleteButton = new JButton("Cancel");

        JLabel header = new JLabel("<html>&nbsp;Would you like to delete the following repo?&nbsp;&nbsp;</html>");
        JLabel repoAddressLabel = new JLabel("<html><li>" + repoDopdownList.getSelectedItem() + "&nbsp;&nbsp;</html>");

        deleteScreen.add(header);
        deleteScreen.add(repoAddressLabel);
        deleteScreen.add(deleteButton);
        deleteScreen.add(cancelDeleteButton);

        deleteButton.addActionListener(this);
        cancelDeleteButton.addActionListener(this);


        //Adds the different screens to the "main screen"
        screenController = new JPanel(new CardLayout());
        screenController.add(defaultScreen, "Default Screen");
        screenController.add(addRepoScreen, "Add Repo Screen");
        screenController.add(mainScreen, "Main Screen");
        screenController.add(deleteScreen, "Delete Screen");

        getContentPane().add(screenController);
        setVisible(true);
    }








    public void actionPerformed(ActionEvent e) {
        CardLayout screen = (CardLayout) screenController.getLayout();
        Object source = e.getSource();

        //If button is pressed, do this
        if (source == newRepo){
            showAddRepoScreen();
        }

        if (source == oldRepolist){
            showMainScreen();
        }

        if (source == addRepoButton) {
            //reposArray.add(repoInputField.getText());
           showMainScreen();
        }

        if (source == cancelButton) {
           showMainScreen();
        }

        if (source == addNewRepoButton) {
            showAddRepoScreen();
        }

        if (source == deleteRepoButton) {
            showDeleteScreen();
        }

        if (source == deleteButton) {
            //delete from database
            showMainScreen();
        }

        if (source == cancelDeleteButton) {
            showMainScreen();
        }

        if (source == runMetricsButton) {
            //run metrics on selected repo
        }

    }

    public void showMainScreen() {
        CardLayout screen = (CardLayout) screenController.getLayout();
        screen.show(screenController, "Main Screen");
    }

    public void showAddRepoScreen(){
        CardLayout screen = (CardLayout) screenController.getLayout();
        screen.show(screenController, "Add Repo Screen");
    }

    public void showDeleteScreen(){
        CardLayout screen = (CardLayout) screenController.getLayout();
        screen.show(screenController, "Delete Screen");
    }


    public static void main(String[] args) {
        NewUserInterface start = new NewUserInterface();
    }
}
