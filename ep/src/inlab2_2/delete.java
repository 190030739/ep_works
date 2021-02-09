package inlab2_2;

import java.sql.*;
import java.util.*;
class delete{
public static void main ( String args[] )throws Exception{
Driver dr = new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(dr);
Connection c =
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manger");
Statement st = c.createStatement();
Scanner sc = new Scanner (System.in);
char op = 'y';
System.out.print("Do you want to delete your details?(Yes/No) : ");
String opt = sc.nextLine();
if(opt.equals("No") || opt.equals("no") || opt.equals("NO"))
op = 'n';
while(op == 'y'){
System.out.print("Enter the ID number : ");
int id = sc.nextInt();
try{
st.executeUpdate("delete from workshop where id = "+id);
}
catch(Exception e){
System.out.println(e);
}
System.out.print("Do you want to delete your details?(Yes/No) : ");
opt = sc.next();
if(opt.equals("No") || opt.equals("no") || opt.equals("NO"))
op = 'n';
}
ResultSet rs = st.executeQuery("Select * from workshop");
while(rs.next()){
System.out.println(rs.getInt(1)+"\t"+rs.getLong(2));
}
}
}