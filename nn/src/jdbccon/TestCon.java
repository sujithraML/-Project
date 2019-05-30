package jdbccon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestCon {

	public static void main(String[] args) {
		Connection con=null;
		try {
			java.util.Properties p=new java.util.Properties();
			String driverName="net.sourceforge.jtds.jdbc.Driver";
			
			Class.forName(driverName);
			p.put("user", "sa");
			p.put("password", "aspire@123");
			String url="jdbc:jtds:sqlserver://localhost:1433;databaseName=Northwind";
			
			con=DriverManager.getConnection(url,p);
			boolean flag=con.isClosed();
			if(!flag) {
				System.out.println("Connection Open");
			}
			else {
				System.out.println("Connection Closed");
			}
		}
		catch(SQLException sqe) {
			System.out.println("SQLException : "+sqe.getMessage());
		}
		catch(Exception e2){
			System.out.println("Exception : "+e2.getMessage());
		}
			finally {
				try {
					if(con!=null) {
						if(!con.isClosed()) {
							con.close();
						}
					}
				}
				catch(Exception e) {
					System.out.println("Error is closing connection : "+e);
				}
			}
	}

}
