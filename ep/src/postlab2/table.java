package postlab2;

import java.sql.*;
import java.io.*;
import java.util.*;
public class table{
public static void main(String[]args)throws Exception {
Scanner sc= new Scanner(System.in);
Driver d= new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(d);
Connection
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manger");
PreparedStatement st= con.prepareStatement("select * from forest");
ResultSet rs=st.executeQuery();
while(rs.next()){
Blob b= rs.getBlob(3);
byte a[] = b.getBytes(1,(int)b.length());
String check=rs.getString(2);
if(check.equals("animal")){
FileOutputStream fout=new
FileOutputStream("C:\\Users\\Kanya\\Desktop\\animals\\"+rs.getString(1)+".jpg");
fout.write(a);
fout.close();
}
else{
FileOutputStream fout = new
FileOutputStream("C:\\Users\\Kanya\\Desktop\\plants\\"+rs.getString(1)+".jpg");
fout.write(a);
fout.close();
}
Clob c= rs.getClob(4);
Reader r =c.getCharacterStream();
if(check.equals("animal")){
FileWriter fw = new
FileWriter("C:\\Users\\Kanya\\Desktop\\animals\\"+rs.getString(1)+".txt");
int i;
while((i=r.read())!=-1){
fw.write((char)i);
}
fw.close();
}
else{

FileWriter fw = new
FileWriter("C:\\Users\\Kanya\\Desktop\\plants\\"+rs.getString(1)+".txt");
int i;
while((i=r.read())!=-1){
fw.write((char)i);
}
fw.close();
}
}con.close();
System.out.println("Success");
}
}