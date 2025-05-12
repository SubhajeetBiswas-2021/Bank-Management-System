
import java.sql.*;                  //imported sql library
public class Conn {

    Connection c;
    Statement s;

    public Conn(){
        try{
            c = DriverManager.getConnection("url","root","Password"); //create connection
            s = c.createStatement();              //create Statement
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
//it is creating connection with database
//we will just create object of this class and use it
//5 steps for jdbc connectivity
/*1.Register the Driver
2.create connection
3.create Statement
4.execute query
5.close connection.*/
//Exception Handling done as mysql is an external entity so chances of error coming is more ,error can come in run time .
//jdbc:mysql  = connecting jdbc with mysql
///bankmanagementsystem   = database name