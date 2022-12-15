package com.miage.vehicle_sales_management.model.documents;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Class Invoice to manage the invoices
 */
public class Invoice {
    ArrayList<InvoiceDetail> invoiceDetail;
    private int id;
    private Date date;
    private String payment;
    private int nbMonth;
    private BigDecimal total;

    /**
     * Constructor of the class Invoice
     *
     * @param id      The id of the invoice
     * @param date    The date of the invoice
     * @param payment The payment of the invoice
     * @param nbMonth The number of month of the invoice
     * @param total   The total of the invoice
     */
    public Invoice(int id, Date date, String payment, int nbMonth, BigDecimal total) {
        this.id = id;
        this.date = date;
        this.payment = payment;
        this.nbMonth = nbMonth;
        this.total = total;
        this.invoiceDetail = new ArrayList<>();
    }

    /**
     * Get the id of the invoice
     *
     * @return the id of the invoice
     */
    public int getId() {
        return id;
    }

    /**
     * Get the date of the invoice
     *
     * @return the date of the invoice
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get the payment method of the invoice
     *
     * @return the payment method of the invoice
     */
    public String getPayment() {
        return payment;
    }

    /**
     * Get the number of months needed for the invoice payment method
     *
     * @return the number of month needed for the invoice payment method
     */
    public int getNbMonth() {
        return nbMonth;
    }

    /**
     * Get the total of the invoice
     *
     * @return the total of the invoice
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * Get the invoice details of the invoice
     *
     * @return the invoice details of the invoice
     */
    public ArrayList<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    /**
     * Add an invoice detail to the invoice
     *
     * @param invoiceDetail The invoice detail to add
     */
    public void addInvoiceDetail(InvoiceDetail invoiceDetail) {
        this.invoiceDetail.add(invoiceDetail);
    }
}
