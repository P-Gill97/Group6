// A TableModel that supplies ResultSet data to a JTable.
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ResultSetTableModel extends AbstractTableModel
{
	
	//variable that contains query results
	private ResultSet resultSet;
	private ResultSetMetaData metaData;
	private int numberOfRows;
	//will be used to establish connection to database