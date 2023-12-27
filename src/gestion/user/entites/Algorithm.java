package gestion.user.entites;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Algorithm {

    static Connection con;

    protected static String crypter(String texteClair) {
        StringBuilder texteCrypte = new StringBuilder();

        for (int i = 0; i < texteClair.length(); i++) {
            char caractere = texteClair.charAt(i);
            int nouveauCodeASCII = (int) caractere + 1;

            texteCrypte.append((char) nouveauCodeASCII);
        }

        return texteCrypte.toString();
    }
    protected  String decrypter(String texteCrypte) {
            StringBuilder texteClair = new StringBuilder();

            for (int i = 0; i < texteCrypte.length(); i++) {
                char caractere = texteCrypte.charAt(i);
                int nouveauCodeASCII = (int) caractere - 1;

                texteClair.append((char) nouveauCodeASCII);
            }

            return texteClair.toString();
        }

     protected static boolean isUserExist(int idUser){

         con = DBConnection.createDBConnection();
         String query = "SELECT COUNT(*) AS count FROM users WHERE id_user=" + idUser;

         try {
             Statement stmt = con.createStatement();
             ResultSet result = stmt.executeQuery(query);
             if (result.next()) {
                 int count = result.getInt("count");
                 return count > 0; // Retourne true si le compte est supérieur à 0, sinon false
             }
         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             try {
                 if (con != null) {
                     con.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
         return false;

     }


    protected static boolean isRoleExist(int idRole){

        con = DBConnection.createDBConnection();
        String query = "SELECT COUNT(*) AS count FROM roles  WHERE id_role=" + idRole;

        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                int count = result.getInt("count");
                return count > 0; // Retourne true si le compte est supérieur à 0, sinon false
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

}
