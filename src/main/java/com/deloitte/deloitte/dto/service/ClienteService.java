package com.deloitte.deloitte.dto.service;

import com.deloitte.deloitte.dto.model.dto.ClienteDTO;
import com.deloitte.deloitte.dto.model.entity.Cliente;
import com.deloitte.deloitte.dto.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    //Get
    public ResponseEntity<List<ClienteDTO>> exibirTodosOsClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteDTO> dtos = clientes.stream()
                .map(ClienteDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    //Post
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO dto) {
        Cliente cliente = ClienteDTO.toEntity(dto);
        Cliente salvo = clienteRepository.save(cliente);
        return ResponseEntity.ok(new ClienteDTO(salvo));
    }
}
