package com.itvnue.Training.project.Controller.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class InvoiceItemDto {

    private Integer id;
    private Integer quantity ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
