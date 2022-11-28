package com.blockchain.escrow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.escrow.entity.Client;
import com.blockchain.escrow.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{
    Project findByAddress(String address);

    List<Project> findByClient(Client client);
}   
