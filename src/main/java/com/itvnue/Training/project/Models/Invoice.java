package com.itvnue.Training.project.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "invoice_no")
    private int invoiceNo;

    @NotNull
    @Column(name = "invoice_date")
    private LocalDate invoiceDate ;

    @NotNull
    @Column(name = "total_cost")
    private Double totalCost;

    @NotNull
    @Column(name = "tax")
    private Double tax ;

    @NotNull
    @Column(name = "customer_information")
    private String customerInformation ;


    public Invoice() {
    }

    public Invoice(int id, int invoiceNo, LocalDate invoiceDate, Double totalCost, Double tax, String customerInformation) {
        this.id = id;
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.totalCost = totalCost;
        this.tax = tax;
        this.customerInformation = customerInformation;
    }

    public Invoice(int invoiceNo, LocalDate invoiceDate, Double totalCost, Double tax, String customerInformation) {
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.totalCost = totalCost;
        this.tax = tax;
        this.customerInformation = customerInformation;
    }

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

    //Relationships
    //Relationship with Attachment class
    @OneToMany( mappedBy="parentInvoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private List<Attachment> attachments;

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    //Relationship with Userr class
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private Userr parentUser;

    public Userr getParentUser() {
        return parentUser;
    }

    public void setParentUser(Userr parentUser) {
        this.parentUser = parentUser;
    }

    //Relationship with Invoice_Item class
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    Set<InvoiceItem> orders;

    public Set<InvoiceItem> getOrders() {
        return orders;
    }

    public void setOrders(Set<InvoiceItem> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceNo=" + invoiceNo +
                ", invoiceDate=" + invoiceDate +
                ", totalCost=" + totalCost +
                ", tax=" + tax +
                ", customerInformation='" + customerInformation + '\'' +
                ", attachments=" + attachments +
                ", parentUser=" + parentUser +
                ", orders=" + orders +
                '}';
    }
}
