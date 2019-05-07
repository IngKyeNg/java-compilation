package testjdbc;
import javax.sql.rowset.*;

public class TestJDBC {
  static RowSetFactory rowSetFactory = null;
  static String databaseUrl = "jdbc:mysql://localhost:3306/Company";
  static String username = "Student";
  static String password = "Pa$$w0rd";
  static void CreateRowSetFactory(){
    try {
      rowSetFactory = RowSetProvider.newFactory("com.sun.rowset.RowSetFactoryImpl", null);
    }
    catch (Exception ex) {
      ex.printStackTrace();
      return;
    }
  }
  public static void main(String[] args) {
    CreateRowSetFactory();
    try (JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();) {
      rowSet.setUrl(databaseUrl);
      rowSet.setUsername(username);
      rowSet.setPassword(password);
      rowSet.setCommand("SELECT * FROM Staff");
      rowSet.execute();
      while (rowSet.next()) {
        System.out.println(rowSet.getInt("ID") + " - "
            + rowSet.getString("FIRSTNAME"));
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }  
  }
}
