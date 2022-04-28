import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class examinationcontroller{

    public static void take_exam(studentmodel exam ){
        examinationmodel stud=new examinationmodel();
        stud.srn=exam.SRN;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Course Code: ");
        stud.coursecode= sc.nextLine(); //reads int.
        System.out.println("Enter Course Name : ");
        stud.coursename= sc.nextLine(); //reads int.


        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from question_paper where coursecode = '"+stud.coursecode+"' and coursename = '"+stud.coursename +"'" ;
            //st.executeUpdate(select);
            ResultSet rs = st.executeQuery(select);
            

            while(rs.next()){
                String mcq_answer="",short_answer="",long_answer="",mark="";
                String coursecode = rs.getString("coursecode");
                String coursename=rs.getString("coursename");
                String marks=rs.getString("marks");
                String mcq_question=rs.getString("mcq_question");
                String short_question=rs.getString("short_question");
                String long_question=rs.getString("long_question");
               // String durationString=rs.getString("duration");
                String no="no";

                

                System.out.println("Course Code : "+coursecode);
                System.out.println("Course Name : "+coursename);
                System.out.println("srn         : "+marks);
                //System.out.println("Duration    : "+durationString);
                System.out.println("Mcq_question    : "+mcq_question+"\nEnter Option");
                mcq_answer= sc.nextLine();
                System.out.println("Short_question  : "+short_question+"\nEnter Answer");
                short_answer= sc.nextLine();
                System.out.println("Long_question   : "+long_question+"\nEnter Answer");
                long_answer= sc.nextLine();

                Statement st1 = con.createStatement();
                String ins = "INSERT INTO answer_script VALUES ('" + stud.srn+ "','"+ stud.coursecode + "','" + stud.coursename + "','" + mcq_answer + "','" +short_answer+"','"+long_answer+"','"
                + mark + "','" + no +"')";
                st1.executeUpdate(ins);
            }



            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        
    }

} 