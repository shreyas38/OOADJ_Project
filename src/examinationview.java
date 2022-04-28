import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class examinationview{
    public static void get_examination_info(){
        
        try  {
            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from examination";
            
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String coursecode = rs.getString("coursecode");
                String coursename=rs.getString("coursename");
                String srn=rs.getString("srn");
                String durationString=rs.getString("duration");

                System.out.println("Course Code : "+coursecode);
                System.out.println("Course Name : "+coursename);
                System.out.println("srn         : "+srn);
                System.out.println("Duration    : "+durationString+"\n\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        
    
    }  
}