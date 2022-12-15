package com.miage.vehicle_sales_management.model.users;

import com.miage.vehicle_sales_management.model.country.Country;
import com.miage.vehicle_sales_management.model.documents.Invoice;
import com.miage.vehicle_sales_management.model.shop.Cart;

import java.util.ArrayList;

/**
 * Class User to manage the users of the website
 */
public class User {

    private static User instance;
    private static Cart cart;
    private int id;
    private Country country;
    private String type;
    private String email;
    private String firstName;
    private String lastName;
    private ArrayList<Invoice> invoices;


    /**
     * Constructor of the class User
     *
     * @param id        The id of the user
     * @param country   The country of the user
     * @param type      The type of the user
     * @param email     The email of the user
     * @param firstName The first name of the user
     * @param lastName  The last name of the user
     */
    private User(int id, String country, String type, String email, String firstName, String lastName) {
        this.id = id;
        this.country = new Country(1, country, 20);
        this.type = type;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.invoices = new ArrayList<>();
        this.cart = Cart.getInstance();
    }

    /**
     * Design pattern Singleton
     * Get the instance of the user
     *
     * @return the instance of the user
     */
    public static User getInstance() {
        if (instance == null) {
            instance = new User(0, "France", "General", "", "", "");
        }
        return instance;
    }

    /**
     * Get the country of the user
     *
     * @return the country of the user
     */
    public Country getCountry() {
        return country;
    }

    /**
     * Set the country of the user
     *
     * @param country the country of the user
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * Get the id of the user
     *
     * @return the id of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id of the user
     *
     * @param id the id of the user
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the type of the user
     *
     * @return the type of the user
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the user
     *
     * @param type the type of the user
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the Lastname of the user
     *
     * @return the Lastname of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the Lastname of the user
     *
     * @param lastName the Lastname of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the Firstname of the user
     *
     * @return firstname the Firstname of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the Firstname of the user
     *
     * @param firstName the Firstname of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the Email of the user
     *
     * @return email the Email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the Email of the user
     *
     * @param email the Email of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the invoices of the user
     *
     * @return invoices the invoices of the user
     */
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * Set the invoices of the user
     *
     * @param invoices the invoices of the user
     */
    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    /**
     * Log out method to disconnect the user from the website, clear the invoices, the cart and set the user to null
     */
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

    /**
     * Add an invoice to the user
     *
     * @param invoice the invoice to add
     */
    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    /**
     * Get an invoice by its id
     * If the invoice doesn't exist, return null
     *
     * @param id the id of the invoice
     * @return the invoice
     */
    public Invoice getInvoice(int id) {
        for (Invoice invoice : invoices) {
            if (invoice.getId() == id) {
                return invoice;
            }
        }
        return null;
    }

    /**
     * Cleat the invoices of the user
     */
    public void clearInvoices() {
        invoices.clear();
    }

    /**
     * Get the cart of the user
     *
     * @return the cart of the user
     */
    public Cart getCart() {
        return cart;
    }
}
