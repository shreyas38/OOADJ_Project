import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class adminmodel {

    String adminid;
    String adminPassword;
    String firstName;
    String lastName;
    String phoneNumber;

    static void enter_admin_details  (){
        adminmodel stud =new adminmodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Admin ID: ");
        stud.adminid= sc.nextLine(); //reads 
        System.out.println("Enter Admin Password: ");
        stud.adminPassword= sc.nextLine(); //reads int.
        System.out.println("Enter First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
        //sc.close();

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String ins = "INSERT INTO admin VALUES ('" + stud.adminid + "','"+ stud.adminPassword + "','" + stud.firstName + "','" + stud.lastName + "','" +stud.phoneNumber+"')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }


    }
    
}
