package com.itvnue.Training.project.Repository;

import com.itvnue.Training.project.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findItemById(int itemId);

}
