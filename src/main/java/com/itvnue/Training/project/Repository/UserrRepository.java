package com.itvnue.Training.project.Repository;
import com.itvnue.Training.project.Models.RoleName;
import com.itvnue.Training.project.Models.Userr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserrRepository extends JpaRepository<Userr, Integer> {
   // Optional<Userr> findUserById(int userId);

    Optional<Userr> findByUserEmail(String userEmail);

    @Transactional
    @Modifying
    @Query("UPDATE Userr a " +
            "SET a.enabled = TRUE WHERE a.userEmail = ?1")
    int enableUserr(String userEmail);
}
