import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.PreparedStatement;
public class connectionpoolmanager {
	public static ComboPooledDataSource getDataSource() throws PropertyVetoException
	
	    {

	        ComboPooledDataSource cpds = new ComboPooledDataSource();
	        cpds.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        cpds.setJdbcUrl("jdbc:sqlserver://"+"192.168.1.93"+";"+"DatabaseName="+"CXi_BH_Test01"+";"+"user="+"sa"+";"+"password="+"pointel@10");
	
	        cpds.setUser("sa");
	
	        cpds.setPassword("pointel@10");

	 
	
	        // Optional Settings
	
	cpds.setInitialPoolSize(5);
    cpds.setMinPoolSize(5);
	
	        cpds.setAcquireIncrement(5);
	
	        cpds.setMaxPoolSize(20);
	
	cpds.setMaxStatements(100);
	
	
	        return cpds;
	
	    }
	
	    public static void main(String[] args) throws SQLException
	
	    {
	
	        Connection connection = null;
	
	        java.sql.PreparedStatement pstmt = null;
	
	        ResultSet resultSet = null;

	        try

	        {

	            ComboPooledDataSource dataSource = connectionpoolmanager.getDataSource();

	            connection = dataSource.getConnection();

	            pstmt = connection.prepareStatement("SELECT * FROM transaction_file");
         

	            System.out.println("The Connection Object is of Class: " + connection.getClass());

	             
	
	            resultSet = pstmt.executeQuery();
	         while (resultSet.next())
	
	            {
	
	                System.out.println(resultSet.getString(1) + "," + resultSet.getString(2) + "," + resultSet.getString(3));

	            }

	 

	        }
	
	        catch (Exception e)
	
	        {
	
	           // connection.rollback();
	
	            e.printStackTrace();
	
	        }
	
	    }

	/*private static ComboPooledDataSource comboPooledDataSource = null;
	private static Connection connection = null;
public static void main(String args[])
{
	     connectionpoolmanager cp=new connectionpoolmanager();
	     cp.funcall();
}
public static Connection getConnection()
{
	comboPooledDataSource = new ComboPooledDataSource();
	boolean a;
	try {
		comboPooledDataSource.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		comboPooledDataSource.setJdbcUrl("jdbc:sqlserver://"+"192.168.1.93"+";"+"DatabaseName="+"CXi_BH_Test01"+";"+"user="+"sa"+";"+"password="+"pointel@10");
		comboPooledDataSource.setUser("sa");                                  
		comboPooledDataSource.setPassword("pointel@10"); 
		comboPooledDataSource.setMinPoolSize(10);                                     
		comboPooledDataSource.setAcquireIncrement(5);
		comboPooledDataSource.setMaxPoolSize(20);
		System.out.println("connected");
		System.out.println();
	} catch (PropertyVetoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;   
}
public void funcall()
{
	for(int i=0;i<150;i++)
	{
		getConnection();
	}
}*/
}
