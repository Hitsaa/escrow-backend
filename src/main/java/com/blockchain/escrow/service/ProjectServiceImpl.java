package com.blockchain.escrow.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blockchain.escrow.dto.ProjectDto;
import com.blockchain.escrow.entity.Client;
import com.blockchain.escrow.entity.Project;
import com.blockchain.escrow.repository.ProjectRepository;
import com.blockchain.escrow.utils.exceptions.AppException;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ClientService clientService;
    
    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Client client = clientService.getClientById(projectDto.getClientId());
        
        if(projectRepository.findByAddress(projectDto.getAddress()) != null) {
            throw new AppException("Address already exist", HttpStatus.BAD_REQUEST);
        }
        Project project = new Project();
        project.setAddress(projectDto.getAddress())
                .setProjectName(projectDto.getProjectName())
                .setClient(client);
        projectRepository.save(project);
        projectDto = modelMapper.map(project, ProjectDto.class);
        // client.getProject().add(project);
        // clientRepository.save(client);
        return projectDto;
    }

    @Override
    public List<ProjectDto> getProjectsByClientId(Integer id) {
        Client client = clientService.getClientById(id);
        List<Project> projectList = projectRepository.findByClient(client);
        return  projectList.stream().map(project -> modelMapper.map(project, ProjectDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Project getProjectById(Integer id) {
        return projectRepository.findById(id).orElseThrow(
            () -> new AppException("Project Not found by given project id", HttpStatus.BAD_REQUEST));
    }

}
