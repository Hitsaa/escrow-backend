package com.blockchain.escrow.service;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blockchain.escrow.dto.DeveloperDto;
import com.blockchain.escrow.dto.DeveloperProjectDto;
import com.blockchain.escrow.dto.ProjectDto;
import com.blockchain.escrow.entity.Client;
import com.blockchain.escrow.entity.Developer;
import com.blockchain.escrow.entity.DeveloperProject;
import com.blockchain.escrow.entity.Project;
import com.blockchain.escrow.repository.DeveloperProjectRepository;
import com.blockchain.escrow.repository.DeveloperRepository;
import com.blockchain.escrow.repository.ProjectRepository;
import com.blockchain.escrow.utils.enums.Status;
import com.blockchain.escrow.utils.exceptions.AppException;

@Service
public class DeveloperProjectServiceImpl implements DeveloperProjectService {

    @Autowired
    DeveloperService developerService;

    @Autowired
    ProjectService projectService;

    @Autowired
    DeveloperProjectRepository developerProjectRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    @Transactional
    public DeveloperProjectDto proposeDeveloperProject(DeveloperProjectDto developerProjectDto) {
        Developer developer = developerService.getDeveloperById(developerProjectDto.getDeveloper().getId());
        Project project = projectService.getProjectById(developerProjectDto.getProject().getId());
        DeveloperProject developerProject = new DeveloperProject();
        developerProject.setDeveloper(developer)
                        .setProject(project)
                        .setStatus(Status.PROPOSED.name());

        developerProject = developerProjectRepository.save(developerProject);

        return modelMapper.map(developerProject, DeveloperProjectDto.class);
    }
    
}
