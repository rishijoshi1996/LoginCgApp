package com.cgapp.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgapp.entity.Nomination;

@Repository
public interface NominationRepository extends JpaRepository<Nomination, Integer> {

}
