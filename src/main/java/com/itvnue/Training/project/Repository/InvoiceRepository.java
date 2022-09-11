package com.itvnue.Training.project.Repository;

import com.itvnue.Training.project.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itvnue.Training.project.Models.Invoice;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    //Select * from Invoice where id = ?
   //@Query("SELECT i FROM Invoice i WHERE i.id=?1")
    Optional<Invoice> findInvoiceById(Integer invoiceId);
}
