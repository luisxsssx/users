package com.example.demousers.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demousers.Repositoy.ClientRepository;
import com.example.demousers.User.Client;
import jakarta.transaction.Transactional;

@Transactional
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientId(Long Id) {
        return clientRepository.findById(Id).orElse(null);
    }

    public List<Client> allClient() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client updateClient(Long Id, Client updateClient) {
        Client client = clientRepository.findById(Id).orElse(null);
        if (client == null) {
            return null;
        }

        client.setName(updateClient.getName());
        client.setEmail(updateClient.getEmail());
        client.setPhone(updateClient.getPhone());

        return updateClient;
    }

    public void deleteClient(Long Id) {
        clientRepository.deleteById(Id);
    }
}