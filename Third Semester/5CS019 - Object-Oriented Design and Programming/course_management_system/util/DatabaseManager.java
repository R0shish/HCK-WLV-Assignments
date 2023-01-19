package course_management_system.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
    String url = "jdbc:mysql://localhost";
    String username = "root";
    String password = "root";
    void checkConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection(url,username,password);
               
            if(!connect.isClosed()) {
                System.out.println("Open");
            }
            connect.close();
        }catch (Exception exp){
            System.out.println(exp);
        }
    }
}