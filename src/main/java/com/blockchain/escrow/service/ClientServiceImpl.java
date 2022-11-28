package com.blockchain.escrow.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.blockchain.escrow.dto.ClientDto;
import com.blockchain.escrow.entity.Client;
import com.blockchain.escrow.repository.ClientRepository;
import com.blockchain.escrow.utils.exceptions.AppException;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ClientDto registerClient(ClientDto clientDto) {
        if (clientRepository.findByPhoneNumber(clientDto.getPhoneNumber()) != null) {
            throw new AppException("Phone number already exist", HttpStatus.BAD_REQUEST);
        }
        Client client = new Client();
        client.setClientName(clientDto.getClientName())
        .setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);
        clientDto = modelMapper.map(client, ClientDto.class);
        return clientDto;
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        if(clients.size() > 0) {
            return clients.stream().map(client -> modelMapper.map(client, ClientDto.class)).collect(Collectors.toList());
        }
        return null;
    }

}
