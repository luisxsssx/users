package com.example.demousers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demousers.Models.Client;
import com.example.demousers.Repositoy.ClientRepository;
import com.example.demousers.Service.ClientService;

@Controller
@RequestMapping("/customers")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewCustomers(@RequestBody Client client) {
        try {
            clientRepository.save(client);
            return new ResponseEntity<>("Saved", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Client>> getAllClient() {
        Iterable<Client> client = clientRepository.findAll();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updateClient) {
        Client client = clientService.updateClient(id, updateClient);
        if (client == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}