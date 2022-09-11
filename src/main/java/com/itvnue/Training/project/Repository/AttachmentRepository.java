package com.itvnue.Training.project.Repository;

import com.itvnue.Training.project.Models.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository <Attachment, Integer> {
    Optional<Attachment> findAttachmentById(int attachmentId);

}
