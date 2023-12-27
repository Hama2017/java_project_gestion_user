package gestion.user.entites;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;
    public static Connection createDBConnection(){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/gestion_users";
            String username="hama";
            String password="Hama";
            con = DriverManager.getConnection(url, username, password);

        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }


}
