import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class question_papermodel {
    
    String coursecode;
    String coursename;
    String marks;
    String mcq_question;
    String short_question;
    String long_question;
    String department;


    public static void enter_question_paper_details(){
        question_papermodel stud=new question_papermodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Course Code: ");
        stud.coursecode= sc.nextLine(); //reads 
        System.out.println("Enter Course Name: ");
        stud.coursename= sc.nextLine(); //reads 
        System.out.println("Enter Marks: ");
        stud.marks= sc.nextLine(); //reads string.
        System.out.println("Enter Mcq_question: ");
        stud.mcq_question= sc.nextLine(); //reads string.
        System.out.println("Enter Short_question: ");
        stud.short_question= sc.nextLine(); //reads string.
        System.out.println("Enter long_question: ");
        stud.long_question= sc.nextLine(); //reads string.
        System.out.println("Enter Department: ");
        stud.department= sc.nextLine(); //reads string.
        //sc.close();

        try  {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String ins = "INSERT INTO question_paper VALUES ('" + stud.coursecode + "','"+ stud.coursename + "','"+  stud.marks + "','"+stud.mcq_question + "','" + stud.short_question + "','"+ stud.long_question + "','" + stud.department +"')";
            st.executeUpdate(ins);

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

}
