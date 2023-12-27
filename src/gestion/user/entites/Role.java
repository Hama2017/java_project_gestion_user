package gestion.user.entites;

public class Role {

    private int id;
    private String name;
    private  String dateCreated;
    private  String dateLastEdit;

    public Role(int id, String name, String dateCreated, String dateLastEdit) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateLastEdit = dateLastEdit;
    }

    public Role() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateLastEdit() {
        return dateLastEdit;
    }

    public void setDateLastEdit(String dateLastEdit) {
        this.dateLastEdit = dateLastEdit;
    }
}
