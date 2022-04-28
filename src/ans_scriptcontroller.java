import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;


public class ans_scriptcontroller {

    static void correct_script(){
        String srn,coursecode,coursename;
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter SRN: ");
        srn= sc.nextLine(); //reads 
        System.out.println("Enter Course Code: ");
        coursecode= sc.nextLine(); //reads int.
        System.out.println("Enter Course Name : ");
        coursename= sc.nextLine(); //reads int.

        try  {
            
           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from answer_script where coursecode = '"+coursecode+"' and coursename = '"+coursename +"' and srn ='" +srn+"'" ;
            
            ResultSet rs = st.executeQuery(select);
        
            while(rs.next()){
                
                String marks=rs.getString("marks");
                String mcq_answer=rs.getString("mcq_ans");
                String short_answer=rs.getString("short_ans");
                String long_answer=rs.getString("long_ans");
                String yes="yes";
               

                System.out.println("Course Code : "+coursecode);
                System.out.println("Course Name : "+coursename);
                System.out.println("srn         : "+srn);
                System.out.println("Mcq_question answer   : "+mcq_answer);
                System.out.println("Short_question  : "+short_answer);
                System.out.println("Long_question   : "+long_answer);
                System.out.println("Enter marks   : ");
                marks= sc.nextLine();

                Statement st1 = con.createStatement();
                String del="delete from answer_script where srn ='"+srn+"' and coursecode = '"+coursecode+"'and coursename = '"+coursename+"'";
                String ins = "INSERT INTO answer_script VALUES ('" + srn+ "','"+coursecode + "','" + coursename + "','" + mcq_answer + "','" +short_answer+"','"+long_answer+"','"
                + marks + "','" + yes + "')";
                st1.executeUpdate(del);
                st1.executeUpdate(ins);
            }



            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
    

    static public void check_answer_script(studentmodel stud){
        
        ans_scriptmodel.view_script(stud);
    }

    static public void check_result(studentmodel stud){
        ans_scriptview.view_result(stud);
    }

}
