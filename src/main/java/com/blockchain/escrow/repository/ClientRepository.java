package com.blockchain.escrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.escrow.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
    Client findByPhoneNumber(String phoneNumber);
}
