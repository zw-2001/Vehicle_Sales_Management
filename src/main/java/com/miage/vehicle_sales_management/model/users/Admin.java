package com.miage.vehicle_sales_management.model.users;
/**
 * @author Lisa-Marie
 * Admin class : Define an admin, which is not a companu
 */
public class Admin extends User {
    /**
     * Main constructor of the Admin class, herite of the user class
     * @param ID_User
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     */
    public Admin(String lastName, String firstName, String email, String password) {
        super(lastName, firstName, email, password);
    }
    /**
     * Check if the user is an admin, return true because it's the case here
     * @return false
     */
    public boolean isAdmin () {
        return true;
    }
}
