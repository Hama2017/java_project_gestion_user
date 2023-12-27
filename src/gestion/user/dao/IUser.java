package gestion.user.dao;

import gestion.user.entites.User;

public interface IUser {

    public void createUser(User user);
    public void showAllUser();
    public void showUserById(int id);
    public void updateUser(int id);
    public void deleteUser(int id);

}
