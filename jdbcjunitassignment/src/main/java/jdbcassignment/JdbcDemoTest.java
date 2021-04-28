package jdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JdbcDemoTest {

@Test
void testInsert() {
try {
Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetail?user=root&password=root");
    JdbcDemo jc = new JdbcDemo();
    jc.insert(1, "shreya");
//     assertEquals(1, i);
    String query = "select * from employee1";
    Statement stmt = con.createStatement();
   ResultSet rs= stmt.executeQuery(query);
   assertEquals(1,rs.getInt(1));
   assertEquals("shreya",rs.getString(2));
   con.close();
   
} catch (Exception e) {
e.getMessage();
}
}
@Test
void testUpdate() {
try {
Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetail?user=root&password=root");
    JdbcDemo jc = new JdbcDemo();
    jc.update(1, "srk");
//    assertEquals(1, i);
    String query = "select * from student";
    Statement stmt = con.createStatement();
   ResultSet rs= stmt.executeQuery(query);
   assertEquals("srk", rs.getString(2));
   con.close();
} catch (Exception e) {
e.getMessage();
}

}

@Test
void testSelect() {
JdbcDemo jc = new JdbcDemo();
ArrayList<Object> obj=jc.select();
assertEquals(obj!=null, true);
}



@Test
void testDelete() {
try {
Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedetail?user=root&password=root");
    JdbcDemo jc = new JdbcDemo();
    jc.delete(1);
//     assertEquals(1, i);
    String query = "select * from student";
    Statement stmt = con.createStatement();
   ResultSet rs= stmt.executeQuery(query);
   assertEquals(rs.next(), false);
   con.close();
} catch (Exception e) {
e.getMessage();
}
}

}