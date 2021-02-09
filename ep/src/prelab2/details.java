package prelab2;
import java.sql.*;
import java.util.*;
public class details {
public static void main(String[] args)throws Exception {
Driver dre=new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(dre);
Connection con =
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
System.out.println("Enter the no of Records:");
Scanner sc = new Scanner(System.in);
int n=sc.nextInt();
PreparedStatement ps;
for(int i=0;i<n;i++) {
System.out.println("Enter the Id,Name,Age of the student:");
int x=sc.nextInt();
String y=sc.next()+sc.nextLine();
int z=sc.nextInt();
ps = con.prepareStatement("insert into student2 values(?,?,?)");
ps.setInt(1,x);
ps.setString(2,y);
ps.setInt(3,z);
ps = con.prepareStatement("select * from student2 where age<21");
ps.executeUpdate();
}
}
}