import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;
//import java.sql.PreparedStatement;
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
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from teacher";
            //st.executeUpdate(select);
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

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
            con.close();
        }
         catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        

    }

    public static void get_all_students(){

        try  {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            String select = "select * from student";
            //st.executeUpdate(select);
            ResultSet rs = st.executeQuery(select);

            while(rs.next()){

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
        System.out.println("Enter Teacher ID: ");
        stud.SRN= sc.nextLine(); //reads int.
        //System.out.println("Enter New Teacher Password: ");
        //stud.teacherPassword= sc.nextLine(); //reads int.
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
            String up="UPDATE student set firstName = '"+stud.firstName +"', lastName = '"+stud.lastName+"', phoneNumber = '"+stud.phoneNumber+"',program ='"+stud.program +"',department = '"+stud.department+"' where teacherid ='"+stud.SRN+"'";
            st.executeUpdate(up);

            String select = "select SRN,firstName,lastName,phoneNumber,program,department from teacher where teacherid = '"+stud.SRN+"' and firstName = '"+stud.firstName+"' and lastName = '"+stud.lastName+"' and phoneNumber = '"+stud.phoneNumber+"' and program = "+stud.phoneNumber+"' and department = '"+stud.department+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
            System.out.println("Updated Successfully");
             
        }
        else{
            System.out.println("Update Failed since SRN is Not Valid");
            con.close();
           // return 0;
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
        stud.teacherid= sc2.nextLine(); //reads int.
        //System.out.println("Enter New Teacher Password: ");
        //stud.teacherPassword= sc.nextLine(); //reads int.
        System.out.println("Enter New First Name: ");
        stud.firstName= sc2.nextLine(); //reads string.
        System.out.println("Enter New Last Name: ");
        stud.lastName= sc2.nextLine(); //reads string.
        System.out.println("Enter New Phone No: ");
        stud.phoneNumber= sc2.nextLine(); //reads string.
        //System.out.println("Enter Program: ");
        //stud.program= sc.nextLine(); //reads string.
        System.out.println("Enter New Department: ");
        stud.department= sc2.nextLine(); //reads string.
        //sc2.close();
        try  {
            // connect way #1
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","password");
            Statement st = con.createStatement();
            
            String up="UPDATE teacher set firstName = '"+stud.firstName +"', lastName = '"+stud.lastName+"', phoneNumber = '"+stud.phoneNumber+"',department = '"+stud.department+"' where teacherid ='"+stud.teacherid+"'";
            //String ins = "INSERT INTO teacher VALUES ('" + stud.teacherid + "','"+ stud.teacherPassword + "','" + stud.firstName + "','" + stud.lastName + "','" +stud.phoneNumber+"','"
            //+ stud.department  + "')";
            st.executeUpdate(up);
            String select = "select teacherid,firstName,lastName,phoneNumber,department from teacher where teacherid = '"+stud.teacherid+"' and firstName = '"+stud.firstName+"' and lastName = '"+stud.lastName+"' and phoneNumber = '"+stud.phoneNumber+"' and department = '"+stud.department+"'";
            ResultSet rs = st.executeQuery(select);
            if(rs.next()){
            System.out.println("Updated Successfully");
            con.close();
           // return 1;
            
        }
        else{
            System.out.println("Update Failed Since Teacher Id is not Valid");
            con.close();
           // return 0;
        }


            con.close();
        }
         catch (SQLException ex) {
            //System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }

    public static void register_admin(){
        adminmodel.enter_admin_details();
    }
    
}
