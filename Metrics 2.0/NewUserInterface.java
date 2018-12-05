import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewUserInterface extends JFrame implements ActionListener {
    private static JPanel screenController;
    private static JButton newRepo, oldRepolist, addRepoButton, cancelRepo, deleteButton, cancelButton;

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








        //Adds the different screens to the "main screen"
        screenController = new JPanel(new CardLayout());
        screenController.add(defaultScreen, "Default Screen");
        screenController.add(addRepoScreen, "Add repo Screen");






        getContentPane().add(screenController);
        setVisible(true);
    }








    public void actionPerformed(ActionEvent e) {
        CardLayout screen = (CardLayout) screenController.getLayout();
        Object source = e.getSource();

        //If button is pressed, do this
        if (source == newRepo){
            screen.show(screenController, "Add Repo Screen");
        }

        if (source == oldRepolist){
            screen.show(screenController, "Main Screen");
        }
    }

    public static void main(String[] args) {
        NewUserInterface start = new NewUserInterface();
    }
}
