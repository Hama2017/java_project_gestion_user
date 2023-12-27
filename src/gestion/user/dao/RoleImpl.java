package gestion.user.dao;

import gestion.user.entites.DBConnection;
import gestion.user.entites.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoleImpl implements IRole {

    Connection con;
    @Override
    public boolean createRole(Role role) {

        boolean is_success = false;
        con = DBConnection.createDBConnection();
        String query = "INSERT INTO roles(name,date_created, date_last_edit) VALUES(?,?,?)";

        try{
            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setString(1, role.getName());
            pstm.setString(2, role.getDateCreated());
            pstm.setString(3, role.getDateLastEdit());
            int cnt = pstm.executeUpdate();
            if (cnt!=0) is_success = true;

        }catch (Exception e){

            e.printStackTrace();
        }


        return is_success;
    }

    @Override
    public List<Role> showAllRole() {

        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM roles ORDER BY id_role DESC";

        List<Role> roles = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while (result.next()){
                Role role = new Role();
                role.setId(result.getInt("id_role"));
                role.setName(result.getString("name"));
                role.setDateCreated(result.getString("date_created"));
                role.setDateLastEdit(result.getString("date_last_edit"));
                roles.add(role);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return roles;

    }

    @Override
    public Role showRoleById(int id) {

        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM roles WHERE id_role="+id;
        Role role = new Role();
        try {

            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()){
                role.setId(result.getInt("id_role"));
                role.setName(result.getString("name"));
                role.setDateCreated(result.getString("date_created"));
                role.setDateLastEdit(result.getString("date_last_edit"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return role;

    }

    @Override
    public boolean updateRole(int id, String name) {

        boolean is_success=false;
        con = DBConnection.createDBConnection();
        String query = "UPDATE roles SET name=?, date_last_edit=NOW()   WHERE id_role=?";
        try {

            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setString(1, name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if (cnt!=0) is_success = true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return is_success;

    }

    @Override
    public boolean deleteRole(int id) {

        boolean is_success=false;
        con = DBConnection.createDBConnection();
        String query = "DELETE FROM roles WHERE id_role=?";
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
