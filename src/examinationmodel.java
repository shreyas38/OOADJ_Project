import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class examinationmodel{

    String coursecode;
    String coursename;
    String srn;
    String duration;


    public static void enter_examination_details  (examinationmodel stud){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Course Code: ");
        stud.coursecode= sc.nextLine(); //reads int.
        System.out.println("Enter Course Name : ");
        stud.coursename= sc.nextLine(); //reads int.
        System.out.println("Enter : SRN ");
        stud.srn= sc.nextLine(); //reads string.
        System.out.println("Enter Duration: ");
        stud.duration= sc.nextLine(); //reads string.
        //sc.close();

        try  {
            // connect way #1
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String ins = "INSERT INTO examination VALUES ('" + stud.coursecode + "','"+ stud.coursename + "','" + stud.srn + "','" + stud.duration +"')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

}