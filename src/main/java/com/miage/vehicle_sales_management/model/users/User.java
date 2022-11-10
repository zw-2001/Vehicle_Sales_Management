package com.miage.vehicle_sales_management.model.users;

import com.miage.vehicle_sales_management.dao.UserDao;
/**
 * @author Lisa-Marie
 * User class : Define a simple user which is not a company, neither an admin
 */
public class User {
    private int ID_User;
    private String lastName;
    private String firstName;
    private String email;
    private String password;

    /**
     * Main constructor of the User class
     * @param ID_User
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     */
    public User(int ID_User, String lastName, String firstName, String email, String password) {
        this.ID_User = ID_User;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }

    /**
     * Second constructor of the User class
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     */
    public User(String lastName, String firstName, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
    }
    /**
     * Get the ID of the user
     * @return ID_User
     */
    public int getID_User() {
        return ID_User;
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
     * @param ID_User
     */
    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
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
    /**
     * Check if the user is an admin, return false because it's not the case here for
     * a simple user
     * @return false
     */
    public boolean isAdmin () {
        return false;
    }
    /**
     * Check if the user is a company, return false because it's not the case here for
     * a simple user
     * @return false
     */
    public boolean isCompany () {
        return false;
    }
    /**
     * Create an array of users in order to get all the user data
     * @return Object[] user
     */
    public Object[] user() {
        return new Object[]{lastName, firstName, email, password, isAdmin(), isCompany()};
    }

}
