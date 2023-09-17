package internship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class StudentManagementSystem
{
     public static void main(String[] args) throws ClassNotFoundException,SQLException
    {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/internship","root","ritika");
           Statement st = con.createStatement();
           Scanner sc = new Scanner(System.in);
           String choice;
           int choice1;
           for( ; ; )
           {
               JOptionPane.showMessageDialog(null, " 1. Add new Student\n 2. Update Student information\n 3. Search student\n 4. Display All Student Info\n 5. Exit\n");
               
                choice=JOptionPane.showInputDialog("Enter your choice");
                choice1=Integer.parseInt(choice);
                
                switch (choice1)
                {
                   case 1:
                       PreparedStatement ps =con.prepareStatement("insert into student(rollno,name,grade,email,age) values(?,?,?,?,?)");
                 
                       String rollno1=JOptionPane.showInputDialog("Enter the Roll Number:");
                       int roll=Integer.parseInt(rollno1);
                       
                       String name1=JOptionPane.showInputDialog("Enter the Name:");
                       
                       String grade1=JOptionPane.showInputDialog("Enter the Grade:");
                       
                       String email1=JOptionPane.showInputDialog("Enter the Email id:");
                       
                       String age1=JOptionPane.showInputDialog("Enter the Age:");
                       int age11 =Integer.parseInt(age1);
                       
                       ps.setInt(1, roll);
                       ps.setString(2, name1);
                       ps.setString(3, grade1);
                       ps.setString(4, email1);
                       ps.setInt(5, age11);
                       
                       ps.execute();
                       JOptionPane.showMessageDialog(null, "Student data added sucessfully");
                       break;
                       
                   case 2:
                       String query="update student set name=?,grade=?,email=?,age=? where rollno=?";
                       PreparedStatement ps2 =con.prepareStatement(query);
                       
                       String name2=JOptionPane.showInputDialog("Enter new Name:");
                       
                       String grade2=JOptionPane.showInputDialog("Enter new Grade:");
                       
                       String email2=JOptionPane.showInputDialog("Enter new Email id:");
                       
                       String age2=JOptionPane.showInputDialog("Enter new Age:");
                       int age22 =Integer.parseInt(age2);
                       
                
                       String rollno2=JOptionPane.showInputDialog(null,"Enter the student rollno:");
                       int rollno22=Integer.parseInt(rollno2);
                       
                      
                       ps2.setString(1,name2);
                       ps2.setString(2, grade2);
                       ps2.setString(3, email2);
                       ps2.setInt(4, age22);
                       ps2.setInt(5, rollno22);
                       int r =ps2.executeUpdate();
                       if(r>0)
                       {
                       JOptionPane.showMessageDialog(null, "Data updated sucessfuliy");
                       }
                       else
                       {
                         JOptionPane.showMessageDialog(null, "Please enter currect record"); 
                       }
                       break;
                       
                   case 3:
                       JOptionPane.showMessageDialog(null, "Searching for a Student Informationbased on Roll number:");
                       PreparedStatement ps3 =con.prepareStatement("select * from student where rollno=?");
                       
                       String rollno3 =JOptionPane.showInputDialog("Enter your Roll Number:");
                       int rollno33=Integer.parseInt(rollno3);
                       
                       ps3.setInt(1, rollno33);
                       
                       ResultSet rs=ps3.executeQuery();
                       while (rs.next())
                       {                           
                             System.out.println(rs.getInt(1));
                             System.out.println(rs.getString(2));
                             System.out.println(rs.getString(3));
                             System.out.println(rs.getString(4));
                             System.out.println(rs.getInt(5)); 
                       }
                       JOptionPane.showMessageDialog(null, "Student information Search sucessfully");
                       break;
                       
                   case 4:
                       JOptionPane.showMessageDialog(null, "Display all Student Information:");
                       PreparedStatement ps4 =con.prepareStatement("select * from student");
                       
                 
                       ResultSet rs1=ps4.executeQuery();
                       while (rs1.next())
                       {                           
                             System.out.println(rs1.getInt(1));
                             System.out.println(rs1.getString(2));
                             System.out.println(rs1.getString(3));
                             System.out.println(rs1.getString(4));
                             System.out.println(rs1.getInt(5));
                       }
                       JOptionPane.showMessageDialog(null, "Display all Student information sucessfully");
                       break;
                       
                   case 5:
                       JOptionPane.showMessageDialog(null, "Exit the student management system");
                       System.exit(0);
                       break;
                       
                   default:
                           JOptionPane.showMessageDialog(null, "Please enter correct option");
                           break;
                       
               }
           }
           
    }    
}
