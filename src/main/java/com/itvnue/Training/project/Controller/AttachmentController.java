package com.itvnue.Training.project.Controller;

import com.itvnue.Training.project.Controller.dto.AttachmentDto;
import com.itvnue.Training.project.Models.Attachment;
import com.itvnue.Training.project.Models.Invoice;
import com.itvnue.Training.project.Service.AttachmentService;
import com.itvnue.Training.project.Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/attachment")
public class AttachmentController {

    private final AttachmentService attachmentService;

    @Autowired
    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }


    @GetMapping
    public List<Attachment> getAttachments() {
        return attachmentService.getAttachments();
    }

    @PostMapping
    public void addNewAttachment(@RequestBody AttachmentDto attachmentDto) {

        attachmentService.addNewAttachment(attachmentDto);
    }

    @DeleteMapping(path = "{attachmentId}")
    public void deleteAttachment(@PathVariable("attachmentId") int attachmentId) {
        attachmentService.deleteAttachment(attachmentId);
    }

    @PutMapping(path = "{attachmentId}")
    public void updateAttachment(@RequestBody Attachment attachment) {

        attachmentService.updateAttachment(attachment);

    }
}
