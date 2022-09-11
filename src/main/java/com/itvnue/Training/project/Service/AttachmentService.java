package com.itvnue.Training.project.Service;

import com.itvnue.Training.project.Controller.dto.AttachmentDto;
import com.itvnue.Training.project.Models.Attachment;
import com.itvnue.Training.project.Repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;

    @Autowired
    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public List<Attachment> getAttachments() {
        return attachmentRepository.findAll();
    }

    public void addNewAttachment(AttachmentDto attachmentDto) {

        Attachment attachment = new Attachment();
        attachment.setId(attachmentDto.getId());
        attachment.setFileSize(attachmentDto.getFileSize());
        attachment.setFileName(attachmentDto.getFileName());
        attachment.setAttachmentNo(attachmentDto.getAttachmentNo());
        attachment.setUrl(attachmentDto.getUrl());
        attachmentRepository.save(attachment);
    }

    public void deleteAttachment(int attachmentId) {
        boolean exists =  attachmentRepository.existsById(attachmentId);
        if (!exists){
            throw new IllegalStateException("invoice with id" + attachmentId + "does not exist");
        }
        attachmentRepository.deleteById(attachmentId);
    }
    public Attachment updateAttachment(Attachment attachment){
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(attachment.getId());
        //Check if the item is not existed (if not, add item)
        if (!attachmentOptional.isPresent()) {
            return attachmentRepository.save(attachment);

        }
        Attachment attachment1 = attachmentOptional.get();
        attachment1.setAttachmentNo(attachment.getAttachmentNo());
        attachment1.setFileSize(attachment.getFileSize());
        attachment1.setFileName(attachment.getFileName());
        attachment1.setFileType(attachment.getFileType());
        attachment1.setUrl(attachment.getUrl());

        return attachmentRepository.save(attachment1);

    }
}

  /*  @Transactional
    public Attachment updateAttachment(AttachmentDto attachment, int attachmentId){

        Attachment attachment1 = attachmentRepository.findById(attachmentId).get();

        if (Objects.nonNull(attachment.getAttachmentNo())
                && !"".equalsIgnoreCase(
                String.valueOf((int) attachment.getAttachmentNo()))) {
            attachment1.setAttachmentNo(
                    attachment.getAttachmentNo());
        }
        if (Objects.nonNull(attachment.getFileSize())
                && !"".equalsIgnoreCase(
                String.valueOf((Double) attachment.getFileSize()))) {
            attachment1.setFileSize(
                    attachment.getFileSize());
        }

        if (Objects.nonNull(
                attachment.getFileName())
                && !"".equalsIgnoreCase(
                attachment.getFileName())) {
            attachment1.setFileName(
                    attachment.getFileName());
        }

        if (Objects.nonNull(
                attachment.getFileType())
                && !"".equalsIgnoreCase(
                attachment.getFileType())) {
            attachment1.setFileName(
                    attachment.getFileType());
        }
        if (Objects.nonNull(
                attachment.getUrl())
                && !"".equalsIgnoreCase(
                attachment.getUrl())) {
            attachment1.setUrl(
                    attachment.getUrl());
        }
        return attachmentRepository.save(attachment1);

    }
*/

