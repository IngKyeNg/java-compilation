package testjdbc;
import java.sql.*;

public class TestJDBC2 {
  static void AddRecord(int id, String fName,String lName){
    try {
      Class.forName("com.mysql.jdbc.Driver");
      try (Connection con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/Company", "Student", "Pa$$w0rd")) {
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO Staff values (?, ?, ?)");
        stmt.setInt(1, id);        
        stmt.setString(2, fName);        
        stmt.setString(3, lName);
        stmt.executeUpdate();
      }
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e);
    }
  }
  
  static void ReadRecords(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
      try (Connection con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/Company", "Student", "Pa$$w0rd")) {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT ID,FirstName FROM Staff");
        while (rs.next()) {
          System.out.println("ID:"+rs.getInt(1) + "\t\tFirst Name:" + 
                  rs.getString(2));
        }
      }
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println(e);
    }
  }
  
  public static void main(String args[]) {
    AddRecord(2000,"Mee","Low");
    ReadRecords();
  }
}