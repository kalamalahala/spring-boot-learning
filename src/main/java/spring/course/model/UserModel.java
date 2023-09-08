package spring.course.model;

public class UserModel {

    private String username;
    private String firstName;
    private String lastName;
    private Integer id;
    private String dateTimeCreated;

    public UserModel() {

    }

    public UserModel(String username, String firstName, String lastName, Integer id, String dateTimeCreated) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getDateTimeCreated() {
        return dateTimeCreated;
    }

    public void setDateTimeCreated(String dateTimeCreated) {
        this.dateTimeCreated = dateTimeCreated;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
