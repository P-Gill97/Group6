

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB 
{
	static Connection connect=null;
	static String databaseName= "";
	static String url = "jdbc:mysql://localhost:3306/FileDB?"+databaseName;
	
	//original code wont compile
	//static String url = "jdbc:mysql://localhost:3306/FileDB?useSSL=false"+databaseName;
	static String username ="root";
    static String password = "SJ9Qwq27md9XcpK";
   
	
    public static void main(String[] args)throws InstantiationException,IllegalAccessException,ClassNotFoundException, SQLException
    {
    	
    	
    	String txt= "11th.txt";
    	Class.forName("com.mysql.jdbc.Driver").newInstance();
    	connect = DriverManager.getConnection(url,username,password);
    	PreparedStatement ps= connect.prepareStatement("INSERT INTO `FileDB`.`Files`(`FileName`) VALUES ('"+txt+"');");
    	//PreparedStatement ps= connection.prepareStatement("INSERT INTO `FileDB`.`Files`(`FileName`) VALUES ('"+txt+"');");
    	
    	
    	int status =ps.executeUpdate();
   
    	if(status !=0 ) 
    	{
    		System.out.println("Database was Connceted");
    		System.out.println("Record WAS INSERTED");
    	}
    	new DisplayQuery();
    }

	//this should work
	public void deleteRecord(String repo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, username, password);

			String sql = "Delete FROM FileDB " +
					"WHERE FileName = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, repo);
			pstmt.executeUpdate(sql);

			conn.close();




		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}


//include DisplayQueryResults


/* Querie to Delete
DELETE 
FROM Files
WHERE FileName='2nd.txt' AND
FileName='3nd.txt';
*/

/*Querie to Display all
Select *
From Files ;
*/