package com.blockchain.escrow.service;

import java.util.List;

import com.blockchain.escrow.dto.ClientDto;

public interface ClientService {
    public ClientDto registerClient(ClientDto clientDto);

    public List<ClientDto> getAllClients();
}
