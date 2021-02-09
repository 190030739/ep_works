package inlab2_2;

import java.sql.*;
import java.util.*;
class workandstu{
public static void main ( String args[] )throws Exception{
Driver dr = new oracle.jdbc.driver.OracleDriver();
DriverManager.registerDriver(dr);
Connection c =
DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
Statement st1 = c.createStatement();
Statement st2 = c.createStatement();
try{
st1.executeUpdate("alter table workshop add (name varchar2(20), email varchar2(20))");
}catch(Exception e){
System.out.println(e);
}
ResultSet rs = st1.executeQuery("select student_id, student_name, email from student13");
while(rs.next()){
//System.out.println(rs.getLong(1) +"\t"+ rs.getString(2));
st2.executeUpdate("Update workshop set email='"+rs.getString(3)+"', name='"+rs.getString(2)+"' where id="+rs.getLong(1));
}
}
}
