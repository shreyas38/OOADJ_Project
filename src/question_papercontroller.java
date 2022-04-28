import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class question_papercontroller {

    public static void get_question_paper_info(){
        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from question_paper";
            //st.executeUpdate(select);
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

                String coursecode = rs.getString("coursecode");
                String coursename=rs.getString("coursecode");
                String marks=rs.getString("marks");
                String department=rs.getString("department");
                String mcq_question=rs.getString("mcq_question");
                String short_question=rs.getString("short_question");
                String long_question=rs.getString("long_question");

                System.out.println("Course Code     : "+coursecode);
                System.out.println("Course Name     : "+coursename);
                System.out.println("Marks           : "+marks);
                System.out.println("Mcq_question    : "+mcq_question);
                System.out.println("Short_question  : "+short_question);
                System.out.println("Long_question   : "+long_question);
                System.out.println("Department      : "+department+"\n\n\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }
    
    public static void set_question_paper(){
        question_papermodel.enter_question_paper_details();
    }

    public static void see_question_paper(){

        question_paperview.get_question_paper_info();

    }
}
