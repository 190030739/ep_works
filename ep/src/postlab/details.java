package postlab;

import java.sql.*;
import java.io.*;
import java.util.*;
public class details{
public static void main(String[]args)throws Exception {
Scanner sc= new Scanner(System.in);
Driver d= new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(d);
Connection
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manger");
int cont=1;
while(cont==1){
PreparedStatement st =con.prepareStatement("insert into forest values(?,?,?,?)");
System.out.println("Enter the name of the plant/animal ?");
String name =sc.next();
 System.out.println("Enter the category ?");
String category=sc.next();
System.out.println("Enter the path of the image");
String ipath=sc.next();
System.out.println("Enter the path of the text file");
String fpath=sc.next();
st.setString(1,name);
st.setString(2,category);
FileInputStream f =new FileInputStream(ipath);
st.setBinaryStream(3,f,f.available());
File fs = new File(fpath);
FileReader fr=new FileReader(fs);
st.setCharacterStream(4,fr,(int)fs.length());
st.executeUpdate();
System.out.println("Do you want to Continue(yes/no) :");
String flag = sc.next();
if(flag.equals("yes")){
cont=1;
}
else{
cont=0;

}
}
con.close();
}
}