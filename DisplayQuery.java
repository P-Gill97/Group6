
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class DisplayQuery extends JFrame 
{
	//database URL,username and password
	static final String DATABASE_URL="jdbc:mysql://localhost:3306/FileDB?";
		
		//GAVE PublicKeyRetrival not allowed
		//because of useSSL=false????
		//useSSL was used to handle exception
		//static final "jdbc:mysql://localhost:3306/FileDB?useSSL=false";
	
	static final String USERNAME="root";
	static final String PASSWORD="SJ9Qwq27md9XcpK";