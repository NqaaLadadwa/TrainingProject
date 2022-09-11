package com.itvnue.Training.project.Controller.dto;

import java.time.LocalDate;

public class InvoiceDto {

    private int id;

    private int invoiceNo;

    private LocalDate invoiceDate ;

    private Double totalCost;

    private Double tax ;

    private String customerInformation ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(int invoiceNo) {
        invoiceNo = invoiceNo;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        invoiceDate = invoiceDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        totalCost = totalCost;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        tax = tax;
    }

    public String getCustomerInformation() {
        return customerInformation;
    }

    public void setCustomerInformation(String customerInformation) {
        customerInformation = customerInformation;
    }

}
