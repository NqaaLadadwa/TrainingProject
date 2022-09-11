package com.itvnue.Training.project.Repository;


import com.itvnue.Training.project.Models.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {
    Optional<InvoiceItem> findInvoiceItemById(int invoiceItemId);
}
