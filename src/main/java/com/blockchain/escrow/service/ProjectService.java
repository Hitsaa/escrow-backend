package com.blockchain.escrow.service;

import java.util.List;

import com.blockchain.escrow.dto.ProjectDto;
import com.blockchain.escrow.entity.Project;

public interface ProjectService {
    public ProjectDto createProject(ProjectDto projectDto);
    
    public List<ProjectDto> getProjectsByClientId(Integer id);

    public Project getProjectById(Integer id);
}
