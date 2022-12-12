package com.blockchain.escrow.service;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blockchain.escrow.dto.DeveloperDto;
import com.blockchain.escrow.dto.ProjectDto;
import com.blockchain.escrow.entity.Client;
import com.blockchain.escrow.entity.Developer;
import com.blockchain.escrow.entity.Project;
import com.blockchain.escrow.repository.DeveloperRepository;
import com.blockchain.escrow.repository.ProjectRepository;
import com.blockchain.escrow.utils.exceptions.AppException;

@Service
public class DeveloperServiceImpl implements DeveloperService{

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public DeveloperDto registerDeveloper(DeveloperDto developerDto) {
        if (developerRepository.findByPhoneNumber(developerDto.getPhoneNumber()) != null) {
            throw new AppException("Phone number already exist", HttpStatus.BAD_REQUEST);
        }
        Developer developer = new Developer();
        developer.setDeveloperName(developerDto.getDeveloperName())
                 .setPhoneNumber(developerDto.getPhoneNumber())
                 .setAddress(developerDto.getAddress());
        developerRepository.save(developer);
        developerDto = modelMapper.map(developer, DeveloperDto.class);
        return developerDto;
    }

    @Override
    public List<DeveloperDto> getAllDevelopers() {
        List<Developer> developerList = developerRepository.findAll();
        List<DeveloperDto> developerDtoList = developerList.stream().map(developer -> modelMapper.map(developer, DeveloperDto.class))
        .collect(Collectors.toList());
        return developerDtoList;
    }

    @Override
    public Developer getDeveloperById(Integer id) {
        return developerRepository.findById(id)
        .orElseThrow(() -> new AppException("Developer not found by given id.", HttpStatus.BAD_REQUEST));
    }
    
}
