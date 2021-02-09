package postlab;
import java.sql.*;
import java.util.*;
public class table {
	public static void main(String args[]) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		PreparedStatement pstmt=con.prepareStatement("create table forest(name varchar2(40),category varchar2(40),image blob,destination clob)");
		pstmt.executeUpdate();
		System.out.println("Table Created");
		con.close();
	}

}