
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class studentcontroller {

   static public int login(studentmodel stud){
        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select SRN,studentPassword from student where SRN ='"+stud.SRN +"' and studentPassword = '"+stud.studentPassword+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
                System.out.println("Login Successful and Logged in as SRN "+stud.SRN);
                con.close();
                return 1;
                
            }
            else{
                System.out.println("Login Unsuccessful");
                con.close();
                return 0;
                
            }
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return 0;
    }
    
    static public void register_student(){
        studentmodel.enter_student_details();
    }

}   
