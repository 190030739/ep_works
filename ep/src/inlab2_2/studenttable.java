package inlab2_2;

import java.sql.*;
import java.util.*;

public class studenttable {
	public static void main(String args[]) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		PreparedStatement pstmt=con.prepareStatement("create table student13(student_id int primary key,student_name varchar(20),email varchar(20),dob varchar(20))");
		pstmt.executeUpdate();
		con.close();
	}

}




