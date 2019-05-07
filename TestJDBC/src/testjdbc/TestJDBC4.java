package testjdbc;

import java.sql.*;
import java.util.Scanner;

public class TestJDBC4 {
    static void AddRecord(int id,String fName,String lName){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Company","Student","Pa$$w0rd")){
                PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Staff values (?, ?, ?)");
                stmt.setInt(1,id);
                stmt.setString(2,fName);
                stmt.setString(3,lName);
                stmt.executeUpdate();
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    static void DeleteRecord(int id){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Company","Student","Pa$$w0rd")){
                PreparedStatement stmt = con.prepareStatement(
                    "DELETE FROM Staff WHERE ID = ?; ");
                stmt.setInt(1,id);
                stmt.executeUpdate();
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }
    static void UpdateRecord(int id,String fName,String lName){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Company","Student","Pa$$w0rd")){
                PreparedStatement stmt = con.prepareStatement(
                    "UPDATE Staff SET FirstName = ?, LastName = ? WHERE ID=?");
                stmt.setInt(3,id);
                stmt.setString(1,fName);
                stmt.setString(2,lName);
                stmt.executeUpdate();
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
    }    
    static void ReadRecords(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Company","Student","Pa$$w0rd")){
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT ID,FirstName FROM Staff");
                while(rs.next()){
                    System.out.println("ID:"+rs.getInt(1) + "\t\tFirst Name:" +
                        rs.getString(2));
                }
            }            
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }
    static void operation(int operates) {
        int ID;
        String fName;
        String lName; 
        Scanner sc = new Scanner(System.in);
        switch (operates){
            case 1:
                System.out.print("Enter ID>>");
                ID = Integer.parseInt(sc.nextLine());
                System.out.print("Enter FirstName>>");
                fName = sc.nextLine();
                System.out.print("Enter LastName>>");
                lName = sc.nextLine();
                AddRecord(ID,fName,lName);
                ReadRecords();   
            case 2:
                System.out.print("Enter ID>>");
                ID = Integer.parseInt(sc.nextLine());
                System.out.print("Enter FirstName>>");
                fName = sc.nextLine();
                System.out.print("Enter LastName>>");
                lName = sc.nextLine();
                UpdateRecord(ID,fName,lName);
                ReadRecords();                   
            case 3:
                System.out.print("Enter ID>>");
                ID = Integer.parseInt(sc.nextLine());
                DeleteRecord(ID);
                ReadRecords();   
            default:
        }
    }
    
    public static void main(String[] args) {
        int op;
        String input;
        ReadRecords(); 
        while(true){
            Scanner sc = new Scanner(System.in);
            
            System.out.println("===Menu===");
            System.out.println("1. Insert new record");
            System.out.println("2. Update new record");
            System.out.println("3. Remove new record");
            System.out.print("What operations you wish to do>>");
            input = sc.nextLine();
            if(input == "") break;
            op = Integer.parseInt(sc.nextLine());
            operation(op);
        }
        //AddRecord(ID,fName,lName);
        //UpdateRecord(2000,"Ing Kye","Ng");
        
    }
    
}
