package com.itvnue.Training.project.Controller;

import com.itvnue.Training.project.Controller.dto.InvoiceDto;
import com.itvnue.Training.project.Models.Attachment;
import com.itvnue.Training.project.Models.Invoice;
import com.itvnue.Training.project.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }


    @GetMapping
    public List<Invoice> getInvoices() {
        return invoiceService.getInvoices();
    }

    @PostMapping
    public void addNewInvoice(@RequestBody InvoiceDto invoiceDto) {
        invoiceService.addNewInvoice(invoiceDto);
    }

    @DeleteMapping(path = "{invoiceId}")
    public void deleteInvoice(@PathVariable("invoiceId") int invoiceId) {
        invoiceService.deleteInvoice(invoiceId);
    }

    @PutMapping(path = "{invoiceId}")
    public void updateInvoice(@RequestBody Invoice invoice) {

        invoiceService.updateInvoice(invoice);

    }
}