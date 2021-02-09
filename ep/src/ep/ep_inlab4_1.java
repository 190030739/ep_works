package ep;

import java.sql.*;
import java.util.*;

public class ep_inlab4_1 {
	public static void main(String args[]) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
		PreparedStatement pstmt=con.prepareStatement("create table saless(id number,iname varchar2(30),cost number)");
		pstmt.executeUpdate();
		con.close();
	}

}