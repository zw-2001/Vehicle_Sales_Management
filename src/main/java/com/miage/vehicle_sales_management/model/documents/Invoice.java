package com.miage.vehicle_sales_management.model.documents;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

public class Invoice {
    private int id;
    private Date date;
    private String payment;
    private int nbMonth;
    private BigDecimal total;
    ArrayList<InvoiceDetail> invoiceDetail;

    public Invoice(int id, Date date, String payment, int nbMonth, BigDecimal total) {
        this.id = id;
        this.date = date;
        this.payment = payment;
        this.nbMonth = nbMonth;
        this.total = total;
        this.invoiceDetail = new ArrayList<InvoiceDetail>();
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getPayment() {
        return payment;
    }

    public int getNbMonth() {
        return nbMonth;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public ArrayList<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    public void addInvoiceDetail(InvoiceDetail invoiceDetail) {
        this.invoiceDetail.add(invoiceDetail);
    }
}
