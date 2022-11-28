package com.blockchain.escrow.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.escrow.dto.ClientDto;
import com.blockchain.escrow.dto.ProjectDto;
import com.blockchain.escrow.service.ClientService;
import com.blockchain.escrow.service.ProjectService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/escrow-app/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    final ProjectService projectService;
    ClientController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/register")
    public ResponseEntity<ClientDto> registerClient(@Valid @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.registerClient(clientDto));
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<ClientDto>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping(value="project/{id}")
    public ResponseEntity<List<ProjectDto>> getMethodName(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok(projectService.getProjectsByClientId(id));
    }
    
    
}
