import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class teacherView {
    void get_teacher_info(){
        
        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from teacher";
            //st.executeUpdate(select);
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String teacherid = rs.getString("teacherid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String department=rs.getString("department");
                

                System.out.println("SRN         : "+teacherid);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("PhoneNumber : "+phoneNumber);
                //System.out.println("Program     : "+stud.program);
                System.out.println("Department  : "+department);
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        
    }
}