package com.blockchain.escrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.escrow.entity.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer>{
    
    Developer findByPhoneNumber(String phoneNumber);
}
