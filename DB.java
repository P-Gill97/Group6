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
