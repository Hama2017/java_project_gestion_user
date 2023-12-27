package gestion.user.dao;
import gestion.user.entites.DBConnection;
import gestion.user.entites.User;
import java.sql.Connection;

public class UserImpl implements IUser {

        Connection con;
    @Override
    public void createUser(User user) {
        con = DBConnection.createDBConnection();
        String query = "";

    }

    @Override
    public void showAllUser() {

    }

    @Override
    public void showUserById(int id) {

    }

    @Override
    public void updateUser(int id) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
