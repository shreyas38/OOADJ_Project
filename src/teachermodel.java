import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class teachermodel {

    String teacherid;
    String teacherPassword;
    String firstName;
    String lastName;
    String phoneNumber;
    String department;

    static void enter_teacher_details(){
        teachermodel stud =new teachermodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Teacher ID: ");
        stud.teacherid= sc.nextLine(); //reads int.
        System.out.println("Enter Teacher Password: ");
        stud.teacherPassword= sc.nextLine(); //reads int.
        System.out.println("Enter First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
        //System.out.println("Enter Program: ");
        //stud.program= sc.nextLine(); //reads string.
        System.out.println("Enter Department: ");
        stud.department= sc.nextLine(); //reads string.
       // sc.close();

        try  {
            // connect way #1
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String ins = "INSERT INTO teacher VALUES ('" + stud.teacherid + "','"+ stud.teacherPassword + "','" + stud.firstName + "','" + stud.lastName + "','" +stud.phoneNumber+"','"
            + stud.department  + "')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }


    
}
