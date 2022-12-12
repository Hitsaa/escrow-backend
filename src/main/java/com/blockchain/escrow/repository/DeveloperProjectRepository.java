package com.blockchain.escrow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blockchain.escrow.entity.Developer;
import com.blockchain.escrow.entity.DeveloperProject;
import com.blockchain.escrow.entity.Project;

@Repository
public interface DeveloperProjectRepository extends JpaRepository<DeveloperProject, Integer>{
    
    List<DeveloperProject> findAllDeveloperByProject(Project project);
    List<DeveloperProject> findAllProjectByDeveloper(Developer developer);
}
