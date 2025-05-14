package com.deloitte.deloitte.dto.service;

import com.deloitte.deloitte.dto.model.dto.ClienteDTO;
import com.deloitte.deloitte.dto.model.entity.Cliente;
import com.deloitte.deloitte.dto.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    //Put
    public ResponseEntity<ClienteDTO> alterarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Optional<Cliente> existe = clienteRepository.findById(id);
        if (existe.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        Cliente clienteAtualizado = ClienteDTO.toEntity(clienteDTO);
        clienteAtualizado.setId(id);
        Cliente salvo = clienteRepository.save(clienteAtualizado);
        return ResponseEntity.ok(new ClienteDTO(salvo));
    }
}
