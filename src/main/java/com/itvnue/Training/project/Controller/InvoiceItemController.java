package com.itvnue.Training.project.Controller;

import com.itvnue.Training.project.Controller.dto.InvoiceItemDto;
import com.itvnue.Training.project.Models.Attachment;
import com.itvnue.Training.project.Models.Invoice;
import com.itvnue.Training.project.Models.InvoiceItem;
import com.itvnue.Training.project.Service.InvoiceItemService;
import com.itvnue.Training.project.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoiceitem")
public class InvoiceItemController {

    private final InvoiceItemService invoiceItemService;

    @Autowired
    public InvoiceItemController(InvoiceItemService invoiceItemService) {
        this.invoiceItemService = invoiceItemService;
    }


    @GetMapping
    public List<InvoiceItem> getInvoiceItem() {
        return invoiceItemService.getInvoiceItems();
    }

    @PostMapping
    public void addNewInvoiceItem(@RequestBody InvoiceItemDto invoiceItemDto){
        invoiceItemService.addNewInvoiceItem(invoiceItemDto);
    }

    @DeleteMapping(path = "{invoiceItemId}")
    public void deleteInvoiceItem(@PathVariable("invoiceItemId") int invoiceItemId){
        invoiceItemService.deleteInvoiceItem(invoiceItemId);
    }

    @PutMapping(path = "{invoiceItemId}")
    public void updateInvoiceItem(@RequestBody InvoiceItem invoiceItem){

        invoiceItemService.updateInvoiceItem(invoiceItem);
    }

   /* @PutMapping(path = "{invoiceItemId}")
    public void updateInvoiceItem(@PathVariable("invoiceItemId") int invoiceItemId){

        invoiceItemService.updateInvoiceItem(invoiceItemId);

    }*/
}
