package gestion.user.entites;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;
    public static Connection createDBConnection(){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://srv570.hstgr.io:3306/u668028993_javagestionuse";
            String username="u668028993_javagestionuse";
            String password="Nacera@2020";
            con = DriverManager.getConnection(url, username, password);

        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }


}
