package gestion.user.dao;

import gestion.user.entites.Role;
import gestion.user.entites.User;

import java.util.List;

public interface IUser {

    public boolean createUser(User user);
    public List<User> showAllUser();
    public User showUserById(int id);
    public boolean updateUser(int id,String email, String password, String passwordHashed, int idRole);
    public boolean deleteUser(int id);

}
