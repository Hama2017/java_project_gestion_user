package gestion.user.dao;
import gestion.user.entites.DBConnection;
import gestion.user.entites.Role;
import gestion.user.entites.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements IUser {

        Connection con;
    @Override
    public boolean createUser(User user) {
        boolean is_success = false;
        con = DBConnection.createDBConnection();
        String query = "INSERT INTO users(email,password, password_hashed,id_role,date_created,date_last_edit) VALUES(?,?,?,?,NOW(),NOW())";
        try{
            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getPasswordHashed());
            pstm.setInt(4, user.getId_role());
            int cnt = pstm.executeUpdate();
            if (cnt!=0) is_success = true;

        }catch (Exception e){

            e.printStackTrace();
        }


        return is_success;
    }

    @Override
    public List<User> showAllUser() {


        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM users";

        List<User> users = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                User user = new User();
                user.setId(result.getInt("id_user"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setPasswordHashed(result.getString("password_hashed"));
                user.setId_role(result.getInt("id_role"));
                user.setDateCreated(result.getString("date_created"));
                user.setDateLastEdit(result.getString("date_last_edit"));
                users.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User showUserById(int id) {

        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM users WHERE id_user="+id;
        User user = new User();
        try {

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                user.setId(result.getInt("id_user"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setPasswordHashed(result.getString("password_hashed"));
                user.setId_role(result.getInt("id_role"));
                user.setDateCreated(result.getString("date_created"));
                user.setDateLastEdit(result.getString("date_last_edit"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(int id,String email, String password, String passwordHashed, int idRole) {

        boolean is_success=false;
        con = DBConnection.createDBConnection();
        String query = "UPDATE users SET email=?, password=?, password_hashed=?, id_role=?, date_last_edit=NOW()  WHERE id_user=?";
        try {

            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setString(2, password);
            pstm.setString(3, passwordHashed);
            pstm.setInt(4, idRole);
            pstm.setInt(5, id);
            int cnt = pstm.executeUpdate();
            if (cnt!=0) is_success = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return is_success;
    }

    @Override
    public boolean deleteUser(int id) {

        boolean is_success=false;
        con = DBConnection.createDBConnection();
        String query = "DELETE FROM users WHERE id_user=?";
        try {

            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setInt(1, id);
            int cnt = pstm.executeUpdate();
            if (cnt!=0) is_success = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return is_success;
    }
}
