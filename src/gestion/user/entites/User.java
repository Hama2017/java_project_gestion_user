package gestion.user.entites;

public class User extends Algorithm {
    private int id;
    private int id_role;
    private String email;
    private String dateCreated;
    private String dateLastEdit;
    private String password;
    private String password_hashed;

    public User(int id, int id_role, String email, String dateCreated, String dateLastEdit, String password, String password_hashed) {
        this.id = id;
        this.id_role = id_role;
        this.email = email;
        this.dateCreated = dateCreated;
        this.dateLastEdit = dateLastEdit;
        this.password = password;
        this.password_hashed = password_hashed;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDate_last_edit() {
        return dateLastEdit;
    }

    public void setDateLastEdit(String dateLastEdit) {
        this.dateLastEdit = dateLastEdit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getDateLastEdit() {
        return dateLastEdit;
    }

    public String getPasswordHashed() {
        return password_hashed;
    }

    public void setPasswordHashed(String passwordHashed) {
        this.password_hashed =  crypter(passwordHashed) ;
    }
}
