package prelab2;

import java.sql.*;
import java.util.*;

public class createtable {
	public static void main(String args[]) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		PreparedStatement pstmt=con.prepareStatement("create table student2(id int,name varchar2(10),age int)");
		pstmt.executeUpdate();
		System.out.println("Table Created")
		con.close();
	}

}