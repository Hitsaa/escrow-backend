package com.blockchain.escrow.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blockchain.escrow.dto.DeveloperProjectDto;
import com.blockchain.escrow.service.DeveloperProjectService;

@RestController
@RequestMapping("/api/escrow-app/developer-project")
public class DeveloperProjectController {
    @Autowired
    DeveloperProjectService developerProjectService;

    @PostMapping("/propose")
    public ResponseEntity<DeveloperProjectDto> proposeDeveloperProject(@Valid @RequestBody DeveloperProjectDto developerProjectDto) {
        return ResponseEntity.ok(developerProjectService.proposeDeveloperProject(developerProjectDto));
    }

}
