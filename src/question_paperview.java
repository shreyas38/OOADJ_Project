import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class question_paperview {

    public static void get_question_paper_info(){
        

        try  {
            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from question_paper";
           
            int flag=1;
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                flag=11;
                String coursecode = rs.getString("coursecode");
                String coursename=rs.getString("coursename");
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
            if(flag!=11){
                System.out.println("No Question Paper Set\n\n");
            }
            con.close();
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }

    }
    
}
