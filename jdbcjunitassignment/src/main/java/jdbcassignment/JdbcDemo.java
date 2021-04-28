package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class JdbcDemo implements JdbcConnectivity {



@Override
public void insert(int id, String name) {
try {
Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetail?user=root&password=root");
String query = "insert into employee1 values(?,?);";
PreparedStatement pm = con.prepareStatement(query);
pm.setInt(1, id);
pm.setString(2, name);

pm.execute();
con.close();
}catch (Exception e) {
e.getMessage();
}




}

@Override
public ArrayList<Object> select() {
ArrayList<Object> obj=null;
try {
Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetail?user=root&password=root");
    String query = "select * from employee1";
    Statement stmt = con.createStatement();
   ResultSet rs= stmt.executeQuery(query);
   obj = new ArrayList<Object>();
   while(rs.next())
   {
    int i1= rs.getInt("id");
    obj.add(i1);
    String s1 = rs.getString("name");
    obj.add(s1);
   }
   

   con.close();
} catch (Exception e) {
e.getMessage();
}

return obj;
}

@Override
public void update(int id, String name) {
try {
Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetail?user=root&password=root");
    String query = "upadte student set name=? where id=?;";
PreparedStatement pm = con.prepareStatement(query);
pm.setString(1, name);
pm.setInt(2, id);


pm.execute();
con.close();
} catch (Exception e) {
e.getMessage();
}

}

@Override
public void delete(int id) {
try {
Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
    String query = "delete from employee1 where id=?;";
PreparedStatement pm = con.prepareStatement(query);

pm.setInt(1, id);


pm.execute();
con.close();
} catch (Exception e) {
e.getMessage();
}

}



}