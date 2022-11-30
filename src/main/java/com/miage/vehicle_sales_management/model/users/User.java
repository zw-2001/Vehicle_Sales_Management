package com.miage.vehicle_sales_management.model.users;

/**
 * @author Lisa-Marie
 * User class : Define a simple user which is not a company, neither an admin
 */
public class User {

    private static User instance;
    private String type;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    /**
     * Man constructor of the User class
     *
     * @param type
     * @param email
     * @param firstName
     * @param lastName
     */
    private User(String type, String email, String firstName, String lastName) {
        this.type = type;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User("General", "", "", "");
        }
        return instance;
    }

    /**
     * Get the type of the user
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the user
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the Lastname of the user
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the Lastname of the user
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the Firstname of the user
     *
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the Firstname of the user
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the Email of the user
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the Email of the user
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the Password of the user
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the Password of the user
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public void logout() {
        instance = null;
    }
}
