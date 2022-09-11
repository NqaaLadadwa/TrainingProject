package com.itvnue.Training.project.Models;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull
    @Column(name = "id")
    private int id;

    @Column(name = "descriptionn")
    private String description;

    @Column(name = "price")
    private Double price;

    public Item() {

    }

    public Item(int id,
                String description,
                Double price,
                Set<InvoiceItem> orders) {

        this.id = id;
        this.description = description;
        this.price = price;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        price = price;
    }

    //Relationships
    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST, orphanRemoval = true, fetch = FetchType.LAZY)
    Set<InvoiceItem> orders;

    public Set<InvoiceItem> getOrders() {
        return orders;
    }

    public void setOrders(Set<InvoiceItem> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", orders=" + orders +
                '}';
    }
}
