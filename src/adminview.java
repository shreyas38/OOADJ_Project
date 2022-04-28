import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class adminview {
    
    public static void get_admin_info(){
        

        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from admin";
            //st.executeUpdate(select);
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String adminid = rs.getString("adminid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");

                System.out.println("Admin ID    : "+adminid);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("PhoneNumber : "+phoneNumber);
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        
    
    }

}
