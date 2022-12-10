package com.miage.vehicle_sales_management.dao;

import com.miage.vehicle_sales_management.model.vehicles.Vehicle;
import com.miage.vehicle_sales_management.model.documents.Invoice;
import com.miage.vehicle_sales_management.model.documents.InvoiceDetail;
import com.miage.vehicle_sales_management.model.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HistoryDao {

    private Connection con = ConnectionManager.getConnection();


    public int showHistoryAdmin() {
        String sql = "SELECT Invoice.Id_Invoice, Date, Payment, NbMonth, Total\n" +
                "FROM Invoice, User\n" +
                "WHERE Invoice.Id_User = User.Id_User;";
        return selectInvoiceDetails(sql);
    }

    public int showHistory() {
        String sql = "SELECT Invoice.Id_Invoice, Date, Payment, NbMonth, Total\n" +
                "FROM Invoice, User\n" +
                "WHERE Invoice.Id_User = ?";
        return selectInvoiceDetails(sql);
    }

    private int selectInvoiceDetails(String sql) {
        String sql2 = "SELECT Invoice.Id_Invoice, Quantity, Vehicle.Id_Vehicle, Vehicle, Type, Brand, Price, Energy, Gearbox, Seat, Image, InvoiceDetail.Total AS Total\n" +
                "FROM Invoice, InvoiceDetail, Vehicle\n" +
                "WHERE Invoice.Id_Invoice = InvoiceDetail.Id_Invoice\n" +
                "AND InvoiceDetail.Id_Vehicle = Vehicle.Id_Vehicle\n" +
                "AND Invoice.Id_Invoice = ?;";

        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                User user = User.getInstance();
                if (!user.getType().equals("Administrator")) {
                    ps.setInt(1, user.getId());
                }
                ResultSet rs = ps.executeQuery();
                user.clearInvoices();
                while (rs.next()) {
                    user.addInvoice(
                            new Invoice(
                                    rs.getInt("Id_Invoice"),
                                    rs.getDate("Date"),
                                    rs.getString("Payment"),
                                    rs.getInt("NbMonth"),
                                    rs.getBigDecimal("Total")
                            )
                    );
                    PreparedStatement ps2 = con.prepareStatement(sql2);
                    ps2.setInt(1, rs.getInt("Id_Invoice"));
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs2.next()) {
                        user.getInvoice(rs2.getInt("Id_Invoice")).addInvoiceDetail(
                                new InvoiceDetail(
                                        new Vehicle(
                                                rs2.getInt("Id_Vehicle"),
                                                rs2.getString("Vehicle"),
                                                rs2.getString("Type"),
                                                rs2.getString("Brand"),
                                                rs2.getFloat("Price"),
                                                rs2.getString("Energy"),
                                                rs2.getString("Gearbox"),
                                                rs2.getString("Seat"),
                                                null,
                                                0,
                                                null,
                                                0
                                        ),
                                        rs2.getInt("Quantity"),
                                        rs2.getBigDecimal("Total")
                                )
                        );
                    }
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
