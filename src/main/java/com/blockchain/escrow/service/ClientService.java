package com.blockchain.escrow.service;

import java.util.List;

import com.blockchain.escrow.dto.ClientDto;
import com.blockchain.escrow.entity.Client;

public interface ClientService {
    public ClientDto registerClient(ClientDto clientDto);

    public List<ClientDto> getAllClients();

    public Client getClientById(Integer id);
}
