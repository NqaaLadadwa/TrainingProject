package com.itvnue.Training.project.Service;

import com.itvnue.Training.project.Controller.dto.InvoiceItemDto;
import com.itvnue.Training.project.Models.Attachment;
import com.itvnue.Training.project.Models.InvoiceItem;
import com.itvnue.Training.project.Models.Item;
import com.itvnue.Training.project.Repository.InvoiceItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InvoiceItemService {

    private final InvoiceItemRepository invoiceItemRepository;

    @Autowired
    public InvoiceItemService(InvoiceItemRepository invoiceItemRepository) {
        this.invoiceItemRepository = invoiceItemRepository;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItemRepository.findAll();
    }

    @PostMapping("all/")
    public void addNewInvoiceItem(InvoiceItemDto invoiceItemDto) {

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(invoiceItemDto.getId());
        invoiceItem.setQuantity(invoiceItemDto.getQuantity());

        // todo: this should be in the put operations, read about idempotency
      //  Optional<InvoiceItem> invoiceItemOptional = invoiceItemRepository.findInvoiceItemById(invoiceItem.getId());
       /* //Check if the invoice is present:
        if (invoiceItemOptional.isPresent()){
            throw new IllegalStateException("ID taken");
        }*/
        invoiceItemRepository.save(invoiceItem);
        //  System.out.println(invoice);
    }

    public void deleteInvoiceItem(int invoiceItemId) {
        boolean exists =  invoiceItemRepository.existsById(invoiceItemId);
        if (!exists){
            throw new IllegalStateException("invoiceItem with id" + invoiceItemId + "does not exist");
        }
        invoiceItemRepository.deleteById(invoiceItemId);
    }

    public InvoiceItem updateInvoiceItem(InvoiceItem invoiceItem){
        Optional<InvoiceItem> invoiceItemOptional = invoiceItemRepository.findById(invoiceItem.getId());
        //Check if the item is not existed (if not, add item)
        if (!invoiceItemOptional.isPresent()) {
            return invoiceItemRepository.save(invoiceItem);

        }
        InvoiceItem invoiceItem1 = invoiceItemOptional.get();
        invoiceItem1.setQuantity(invoiceItem.getQuantity());


        return invoiceItemRepository.save(invoiceItem1);

    }


  /*  @Transactional
    public void updateInvoiceItem(int invoiceItemId){

        // todo in update, if exists in the db update, if not insert

        Optional<InvoiceItem> invoiceItemOptional = invoiceItemRepository.findById(invoiceItemId);

        if (!invoiceItemOptional.isPresent()) {
            // insert new item
            return;
        }

        InvoiceItem invoiceItem = invoiceItemOptional.get();
        // if available update the fields, then saave to db



    }*/
}
