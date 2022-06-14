
import java.sql.Connection;

import java.sql.DriverManager;

	public class DbConnection {
		static Connection connect()
		{
			Connection con=null;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Driver loaded...");
				con=(Connection) DriverManager.getConnection("jdbc:mysql://192.168.42.36:3306/narcoisback", "Rohan","");
				System.out.println("Connection Established.......");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
			
		}

	}
