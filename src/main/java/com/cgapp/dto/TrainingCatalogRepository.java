package com.cgapp.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgapp.entity.TrainingCatalog;

@Repository
public interface TrainingCatalogRepository extends JpaRepository<TrainingCatalog, Integer> {

}
