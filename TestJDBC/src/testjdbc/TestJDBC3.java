package testjdbc;
import java.sql.*;
import java.util.*;

class Staff{
  int ID;
  String FirstName;
  String LastName;
  public Staff(int id, String firstName, String lastName){
    ID = id;
    FirstName = firstName;
    LastName = lastName;
  }
}
public class TestJDBC3 {
  static void AddRecords(ArrayList<Staff> staffs){
    try {
      Class.forName("com.mysql.jdbc.Driver");
      try (Connection con = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/Company", "Student", "Pa$$w0rd")) {
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO Staff values (?, ?, ?)");
        con.setAutoCommit(false);
        try{
          for(Staff staff:staffs){
            stmt.setInt(1, staff.ID);        
            stmt.setString(2, staff.FirstName);
            stmt.setString(3, staff.LastName);
            stmt.executeUpdate();
          }
          con.commit();
        }
        catch(Exception ex){
          con.rollback();
        }
        finally{
          con.setAutoCommit(true);
        }
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
    ArrayList<Staff> staff2017 = new ArrayList<>();
//    staff2017.add(new Staff(5001,"Ali","Ahmad"));
//    staff2017.add(new Staff(5002,"Abu","Abu Bakar"));
//    staff2017.add(new Staff(5005,"Fatimah","Halim"));
    staff2017.add(new Staff(6001,"John","Handson"));
    staff2017.add(new Staff(5002,"Latin","Alba"));
    staff2017.add(new Staff(6005,"Nor","Adnan"));
    AddRecords(staff2017);
    ReadRecords();
  }
}