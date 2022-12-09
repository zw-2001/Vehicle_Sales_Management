package com.miage.vehicle_sales_management.model.users;

import com.miage.vehicle_sales_management.model.documents.Invoice;
import com.miage.vehicle_sales_management.model.shop.Cart;

import java.util.ArrayList;

/**
 * @author Lisa-Marie
 * User class : Define a simple user which is not a company, neither an admin
 */
public class User {

    private static User instance;
    private int id;
    private String type;
    private String email;
    private String firstName;
    private String lastName;
    private ArrayList<Invoice> invoices;

    private static Cart cart;

    /**
     * Man constructor of the User class
     *
     * @param type
     * @param email
     * @param firstName
     * @param lastName
     */
    private User(int id, String type, String email, String firstName, String lastName) {
        this.id = id;
        this.type = type;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.invoices = new ArrayList<>();
        this.cart = Cart.getInstance();
    }

    public static User getInstance() {
        if (instance == null) {
            instance = new User(0, "General", "", "", "");
        }
        return instance;
    }

    /**
     * Get the type of the user
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the type of the user
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
     * Get the invoices of the user
     *
     * @return invoices
     */
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * Set the invoices of the user
     *
     * @param invoices
     */
    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    public void logout() {
        instance = null;
        id = 0;
        type = "";
        email = "";
        firstName = "";
        lastName = "";
        invoices.clear();
        cart.clearCart();
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public Invoice getInvoice(int id) {
        for (Invoice invoice : invoices) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    public void clearInvoices() {
        invoices.clear();
    }

    public Cart getCart() {
        return cart;
    }
}
