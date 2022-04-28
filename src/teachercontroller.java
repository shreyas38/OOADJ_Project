
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class teachercontroller {

    static public int login( teachermodel teach){
        try  {
            
           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select teacherid,teacherPassword from teacher where teacherid ="+teach.teacherid +" and teacherPassword = "+teach.teacherPassword;
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
                System.out.println("Login Successful and Logged in as Admin Id "+teach.teacherid);
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

    static void register_teacher(){
        teachermodel.enter_teacher_details();
    }

    public static void main(String[] args) {
        

        
    }
    


}
