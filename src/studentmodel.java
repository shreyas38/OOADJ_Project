import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class studentmodel {

    String SRN;
    String studentPassword;
    String firstName;
    String lastName;
    String phoneNumber;
    String program;
    String department;

    static void enter_student_details(){
        studentmodel stud=new studentmodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter SRN: ");
        stud.SRN= sc.nextLine(); //reads String.
        System.out.println("Enter Student Password: ");
        stud.studentPassword= sc.nextLine(); //reads string.
        System.out.println("Enter First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
        System.out.println("Enter Program: ");
        stud.program= sc.nextLine(); //reads string.
        System.out.println("Enter Department: ");
        stud.department= sc.nextLine(); //reads string.
        

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String ins = "INSERT INTO student VALUES ('" + stud.SRN+ "','"+ stud.studentPassword + "','" + stud.firstName + "','" + stud.lastName + "','" +stud.phoneNumber+"','"+stud.program+"','"+
            stud.department  + "')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    

    
}
