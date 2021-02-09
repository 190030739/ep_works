package inlab2_2;

import java.sql.*;
import java.util.*;

class studentdetails {
	public static void main(String[] args) throws Exception {
		Driver d = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
		if (con != null) {
			System.out.println("connected");
		} else {
			System.out.println("not connected");
		}
		PreparedStatement stmt = con.prepareStatement("insert into student12 values(?,?,?,?)");
		int student_id;
		String student_name;
		String email;
		String dob;
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("enter sid");
			student_id = sc.nextInt();
			stmt.setInt(1, student_id);
			System.out.println("enter name");
			student_name = sc.next();
			stmt.setString(2, student_name);
			System.out.println("enter email");
			email = sc.next();
			stmt.setString(3, email);
			System.out.println("enter dob");
			dob = sc.next();
			stmt.setString(4, dob);
			int i = stmt.executeUpdate();
			System.out.println("Do U want to continue?? yes/no");
			String a = sc.next();
			if (a.equals("yes"))
				flag = true;
			else
				flag = false;
		}
		con.close();
	}
}