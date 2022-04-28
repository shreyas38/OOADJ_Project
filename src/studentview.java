
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;

public class studentview {
    
    static void get_student_info(studentmodel stud){


        try  {
            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from student";
           
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String SRN = rs.getString("teacherid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String program=rs.getString("program");
                String department=rs.getString("department");

                System.out.println("SRN         : "+SRN);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("PhoneNumber : "+phoneNumber);
                System.out.println("Program     : "+program);
                System.out.println("Department  : "+department+"\n\n");
                

            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        
        
    }
    
    
}
