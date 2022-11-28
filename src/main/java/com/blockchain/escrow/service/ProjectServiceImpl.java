package com.blockchain.escrow.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blockchain.escrow.dto.ProjectDto;
import com.blockchain.escrow.entity.Client;
import com.blockchain.escrow.entity.Project;
import com.blockchain.escrow.repository.ClientRepository;
import com.blockchain.escrow.repository.ProjectRepository;
import com.blockchain.escrow.utils.exceptions.AppException;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProjectRepository projectRepository;

    private final ClientRepository clientRepository;
    public ProjectServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    @Override
    public ProjectDto createProject(ProjectDto projectDto) {
        Client client = this.getClientById(projectDto.getClientId());
        
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
        Client client = this.getClientById(id);
        List<Project> projectList = projectRepository.findByClient(client);
        return  projectList.stream().map(project -> modelMapper.map(project, ProjectDto.class)).collect(Collectors.toList());
    }

    private Client getClientById(Integer id) {
        return clientRepository.findById(id).orElseThrow(
            () -> new AppException("Client Not found", HttpStatus.BAD_REQUEST));
    }

}
