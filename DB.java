import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB 
{
	static Connection connect=null;
	static String databaseName= "";
	//static String url = "jdbc:mysql://localhost:3306/FileDB?"+databaseName;
	
	//original code wont compile
	static String url = "jdbc:mysql://localhost:3306/FileDB?useSSL=false"+databaseName;
	static String username ="root";
    static String password = "SJ9Qwq27md9XcpK";
    public static void main(String[] args)throws InstantiationException,IllegalAccessException,ClassNotFoundException, SQLException
    {
    	
    	
    	String txt= "10th.txt";
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	connect = DriverManager.getConnection(url,username,password);
    	PreparedStatement ps= connect.prepareStatement("INSERT INTO `FileDB`.`Files`(`FileName`) VALUES ('"+txt+"');");
    	//PreparedStatement ps= connection.prepareStatement("INSERT INTO `FileDB`.`Files`(`FileName`) VALUES ('"+txt+"');");
    	
    	
    	int status =ps.executeUpdate();