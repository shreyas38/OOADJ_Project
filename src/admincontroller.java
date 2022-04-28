import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class admincontroller {

    static public int login(adminmodel admin){
        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select adminid,adminPassword from admin where adminid = "+admin.adminid+" and adminPassword = "+admin.adminPassword;
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
                System.out.println("Login Successful and Logged in as Admin Id "+admin.adminid);
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

    public static void get_all_teachers(){

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            int flag=1;
            String select = "select * from teacher";
            
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){
                flag=11;
                String teacherid = rs.getString("teacherid");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String department=rs.getString("department");

                System.out.println("Teacher ID  : "+teacherid);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("PhoneNumber : "+phoneNumber);
                System.out.println("Department  : "+department+"\n\n");
            }
            if(flag!=11){
                System.out.println("No Teachers Registered\n\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        

    }

    public static void get_all_students(){

        try  {
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from student";
    
            ResultSet rs = st.executeQuery(select);
            int flag=1;

            while(rs.next()){
                flag=11;
                String SRN = rs.getString("SRN");
                String firstName=rs.getString("firstName");
                String lastName=rs.getString("lastName");
                String phoneNumber=rs.getString("phoneNumber");
                String program=rs.getString("program");
                String department=rs.getString("department");

                System.out.println("Student SRN : "+SRN);
                System.out.println("Firstname   : "+firstName);
                System.out.println("Lastname    : "+lastName);
                System.out.println("PhoneNumber : "+phoneNumber);
                System.out.println("Program     : "+program);
                System.out.println("Department  : "+department+"\n\n");
            }

            if(flag!=11){
                System.out.println("No Students Registered\n\n");
            }
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        

    }

    public static void update_student_details(){
        
        studentmodel stud =new studentmodel();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter SRN: ");
        stud.SRN= sc.nextLine(); //reads
        System.out.println("Enter New First Name: ");
        stud.firstName= sc.nextLine(); //reads string.
        System.out.println("Enter New Last Name: ");
        stud.lastName= sc.nextLine(); //reads string.
        System.out.println("Enter New Phone No: ");
        stud.phoneNumber= sc.nextLine(); //reads string.
        System.out.println("Enter Program: ");
        stud.program= sc.nextLine(); //reads string.
        System.out.println("Enter New Department: ");
        stud.department= sc.nextLine(); //reads string.
        //sc.close();

        try  {

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String up="UPDATE student set firstName = '"+stud.firstName +"', lastName = '"+stud.lastName+"', phoneNumber = '"+stud.phoneNumber+"',program ='"+stud.program +"', department = '"+stud.department+"' where SRN ="+stud.SRN+"";
            st.executeUpdate(up);

            String select = "select SRN,firstName,lastName,phoneNumber,program,department from student where SRN = '"+stud.SRN+"' and firstName = '"+stud.firstName+"' and lastName = '"+stud.lastName+"' and phoneNumber = '"+stud.phoneNumber+"' and program = '"+stud.program+"' and department = '"+stud.department+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
            System.out.println("Updated Successfully");
             
             }
        else{
            System.out.println("Update Failed since SRN is Not Valid");
            con.close();
        }

            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    public static void update_teacher_details(){
        teachermodel stud =new teachermodel();
        Scanner sc2= new Scanner(System.in); //System.in is a standard input stream.
        System.out.println("Enter Teacher ID: ");
        stud.teacherid= sc2.nextLine(); //reads 
        System.out.println("Enter New First Name: ");
        stud.firstName= sc2.nextLine(); //reads string.
        System.out.println("Enter New Last Name: ");
        stud.lastName= sc2.nextLine(); //reads string.
        System.out.println("Enter New Phone No: ");
        stud.phoneNumber= sc2.nextLine(); //reads string.
        System.out.println("Enter New Department: ");
        stud.department= sc2.nextLine(); //reads string.
        
        try  {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            
            String up="UPDATE teacher set firstName = '"+stud.firstName +"', lastName = '"+stud.lastName+"', phoneNumber = '"+stud.phoneNumber+"',department = '"+stud.department+"' where teacherid ='"+stud.teacherid+"'";
            
            st.executeUpdate(up);
            String select = "select teacherid,firstName,lastName,phoneNumber,department from teacher where teacherid = '"+stud.teacherid+"' and firstName = '"+stud.firstName+"' and lastName = '"+stud.lastName+"' and phoneNumber = '"+stud.phoneNumber+"' and department = '"+stud.department+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
            System.out.println("Updated Successfully");
            con.close();
           
            
        }
        else{
            System.out.println("Update Failed Since Teacher Id is not Valid");
            con.close();
           
        }


            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    public static void register_admin(){
        adminmodel.enter_admin_details();
    }
    
}
