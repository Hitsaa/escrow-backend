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
import com.blockchain.escrow.dto.DeveloperDto;
import com.blockchain.escrow.dto.ProjectDto;
import com.blockchain.escrow.service.ClientService;
import com.blockchain.escrow.service.DeveloperService;
import com.blockchain.escrow.service.ProjectService;


@RestController
@RequestMapping("/api/escrow-app/developer")
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    final ProjectService projectService;
    DeveloperController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/register")
    public ResponseEntity<DeveloperDto> registerDeveloper(@Valid @RequestBody DeveloperDto developerDto) {
        return ResponseEntity.ok(developerService.registerDeveloper(developerDto));
    }

    @GetMapping("/list/all")
    public ResponseEntity<List<DeveloperDto>> getAllDevelopers() {
        return ResponseEntity.ok(developerService.getAllDevelopers());
    }

}
