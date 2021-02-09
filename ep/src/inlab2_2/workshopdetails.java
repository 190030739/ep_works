package inlab2_2;

import java.sql.*;
import java.util.*;
class de{
public static void main ( String args[] )throws Exception{
Driver dr = new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(dr);
Connection c =
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st = c.createStatement();
Scanner sc = new Scanner (System.in);
char op = 'y';
System.out.print("Do you want to insert your details?(Yes/No) : ");
String opt = sc.nextLine();
if(opt.equals("No") || opt.equals("no") || opt.equals("NO"))
op = 'n';
while(op == 'y'){
System.out.print("Enter the ID number : ");
int id = sc.nextInt();
System.out.print("Enter the contact number : ");
long pn = sc.nextLong();
try{
st.executeUpdate("Insert into workshop values("+id+","+pn+")");
}
catch(Exception e){
System.out.println(e);
System.out.println("Data not inserted");
}
System.out.print("Do you want to insert your details?(Yes/No) : ");
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