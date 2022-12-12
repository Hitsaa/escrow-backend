package com.blockchain.escrow.service;

import java.util.List;

import com.blockchain.escrow.dto.DeveloperDto;
import com.blockchain.escrow.entity.Developer;

public interface DeveloperService {
    public DeveloperDto registerDeveloper(DeveloperDto developerDto);

    public List<DeveloperDto> getAllDevelopers();

    public Developer getDeveloperById(Integer id);
}
