package com.miage.vehicle_sales_management.model.users;
/**
 * @author Lisa-Marie
 * Company class : Define a company, which is not an admin
 */
public class Company extends User {
    /**
     * Main constructor of the Company class, herite of the user class
     * @param ID_User
     * @param lastName
     * @param firstName
     * @param email
     * @param password
     */
    public Company(String lastName, String firstName, String email, String password) {
        super(lastName, firstName, email, password);
    }
    /**
     * Check if the user is a company, return true because it's the case here
     * @return false
     */
    public boolean isCompany () {
        return true;
    }
}
