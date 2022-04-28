import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class ans_scriptmodel {

    String srn;

    static void view_script(studentmodel reg){

        String coursecode,coursename;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Course Code: ");
        coursecode= sc.nextLine(); //reads int.
        System.out.println("Enter Course Name : ");
        coursename= sc.nextLine(); //reads int.

        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String yes="yes";
            String select = "select * from answer_script where coursecode = '"+coursecode+"' and coursename = '"+coursename +"' and srn ='" +reg.SRN+"' and evaluate ='"+yes+"' " ;
            //st.executeUpdate(select);
            ResultSet rs = st.executeQuery(select);
        
            while(rs.next()){
                
                String mcq_answer=rs.getString("mcq_ans");
                String short_answer=rs.getString("short_ans");
                String long_answer=rs.getString("long_ans");
                String mark=rs.getString("marks");

                System.out.println("Course Code : "+coursecode);
                System.out.println("Course Name : "+coursename);
                System.out.println("srn         : "+reg.SRN);
                System.out.println("Mcq answer  : "+mcq_answer);
                System.out.println("Short answer: "+short_answer);
                System.out.println("Long answer : "+long_answer);
                System.out.println("Marks       : "+mark) ;
            }



            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }

    

    
}
