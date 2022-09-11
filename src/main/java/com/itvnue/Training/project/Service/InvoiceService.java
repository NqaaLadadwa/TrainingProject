package com.itvnue.Training.project.Service;
import com.itvnue.Training.project.Controller.dto.InvoiceDto;
import com.itvnue.Training.project.Models.Attachment;
import com.itvnue.Training.project.Models.Invoice;
import com.itvnue.Training.project.Models.Item;
import com.itvnue.Training.project.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoices() {
        return invoiceRepository.findAll();
    }

    @PostMapping("all/")
    public void addNewInvoice(InvoiceDto invoiceDto) {

        Invoice invoice = new Invoice();
        invoice.setId(invoiceDto.getId());
        invoice.setInvoiceNo(invoiceDto.getInvoiceNo());
        invoice.setTotalCost(invoiceDto.getTotalCost());
        invoice.setTax(invoiceDto.getTax());
        invoice.setCustomerInformation(invoiceDto.getCustomerInformation());

        invoiceRepository.save(invoice);
    }

    public void deleteInvoice(int invoiceId) {
       boolean exists =  invoiceRepository.existsById(invoiceId);
       if (!exists){
           throw new IllegalStateException("invoice with id" + invoiceId + "does not exist");
       }
       invoiceRepository.deleteById(invoiceId);
    }
    public Invoice updateInvoice(Invoice invoice){
        Optional<Invoice> invoiceOptional = invoiceRepository.findById(invoice.getId());
        //Check if the item is not existed (if not, add item)
        if (!invoiceOptional.isPresent()) {
            return invoiceRepository.save(invoice);

        }
        Invoice invoice1 = invoiceOptional.get();
        invoice1.setInvoiceNo(invoice.getInvoiceNo());
        invoice1.setTotalCost(invoice.getTotalCost());
        invoice1.setTax(invoice.getTax());
        invoice1.setInvoiceDate(invoice.getInvoiceDate());
        invoice1.setCustomerInformation(invoice.getCustomerInformation());

        return invoiceRepository.save(invoice1);

    }

}
