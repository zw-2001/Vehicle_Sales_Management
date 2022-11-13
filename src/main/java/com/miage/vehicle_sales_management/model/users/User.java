package com.miage.vehicle_sales_management.model.users;

/**
 * @author Lisa-Marie
 * User class : Define a simple user which is not a company, neither an admin
 */
public class User {

    private static User instance;
    private int userId;
    private String type;
    private String email;
    private String password;
    private String lastName;
    private String firstName;

    /**
     * Man constructor of the User class
     * @param userId
     * @param type
     * @param email
     * @param password
     * @param lastName
     * @param firstName
     */
    private User(int userId, String type, String email, String password,  String lastName, String firstName) {
        this.userId = userId;
        this.type = type;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User(-1, "", "", "", "", "");
        }
        return instance;
    }
    /**
     * Get the id of the user
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Get the type of the user
     * @return type
     */
    public String getType() {
        return type;
    }
    /**
     * Get the Lastname of the user
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Get the Firstname of the user
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Get the Email of the user
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Get the Password of the user
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Set the ID of the user
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setType(String type) {
        this.type = type;
    }
    /**
     * Set the Lastname of the user
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Set the Firstname of the user
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Set the Email of the user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Set the Password of the user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
