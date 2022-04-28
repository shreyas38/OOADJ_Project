import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class course_regmodel {

    String SRN;
    String coursecode;
    String coursename;


    
    static public void reg(studentmodel regs){

        course_regmodel stud= new course_regmodel();
        stud.SRN=regs.SRN;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Course Code: ");
        stud.coursecode= sc.nextLine(); //reads int.
        System.out.println("Enter Course Name : ");
        stud.coursename= sc.nextLine(); //reads int.
    
        try  {
            // connect way #1
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String ins = "INSERT INTO course_reg VALUES ('" +stud.SRN + "','"+ stud.coursecode + "','"+ stud.coursename +"')";
            
    
            st.executeUpdate(ins);
    
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    
    }

}
