package gestion.user.entites;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;
    public static Connection createDBConnection(){

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://db5014940269.hosting-data.io:3306/dbs12419174";
            String username="dbu4732734";
            String password="xU674U2j3dmKxmQcPXBs3CUAdxwXG";
            con = DriverManager.getConnection(url, username, password);

        }catch (Exception e){
            e.printStackTrace();
        }

        return con;
    }


}
