package sampletester;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQuery_SampleCode {

	public static void main(String[] args) throws Throwable {
		 Connection conn =null;
		try {
		Driver driverref=new Driver();//load driver
	
	DriverManager.registerDriver(driverref);//register driver
	
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");//establish connection
       
       System.out.println("connection is done");
       
      Statement stst = conn.createStatement();//create statement//method chaining concept
       
		String query="select * from student_info;";
		
		ResultSet resultset = stst.executeQuery(query);//execute query
		
		while(resultset.next())
		{
			System.out.println(resultset.getString(1)+" "+resultset.getString(2)+" "+resultset.getString(3)
			+" "+resultset.getString(4));
		}
		}catch(Exception e) {
		}finally {
			conn.close();//close connection
		}
		
	}
}
