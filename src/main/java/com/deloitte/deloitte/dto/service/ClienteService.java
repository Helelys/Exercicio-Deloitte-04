package com.deloitte.deloitte.dto.service;

import com.deloitte.deloitte.dto.model.entity.Cliente;
import com.deloitte.deloitte.dto.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    //Get
    public ResponseEntity<List<Cliente>> exibirTodosOsClientes() {
        return ResponseEntity.ok(clienteRepository.findAll());
    }


}
