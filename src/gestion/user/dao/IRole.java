package gestion.user.dao;


import gestion.user.entites.Role;

import java.util.List;

public interface IRole {
    public boolean createRole(Role role);
    public List<Role> showAllRole();
    public Role showRoleById(int id);
    public boolean updateRole(int id, String name);
    public boolean deleteRole(int id);
}
