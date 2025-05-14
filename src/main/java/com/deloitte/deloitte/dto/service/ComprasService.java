package com.deloitte.deloitte.dto.service;

import com.deloitte.deloitte.dto.model.dto.ComprasDTO;
import com.deloitte.deloitte.dto.model.entity.Cliente;
import com.deloitte.deloitte.dto.model.entity.Compras;
import com.deloitte.deloitte.dto.model.entity.Produto;
import com.deloitte.deloitte.dto.repository.ClienteRepository;
import com.deloitte.deloitte.dto.repository.ComprasRepository;
import com.deloitte.deloitte.dto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComprasService {

    private final ComprasRepository comprasRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    //Get
    public ResponseEntity<List<ComprasDTO>> exibirTodasAsCompras() {
        List<Compras> compras = comprasRepository.findAll();
        List<ComprasDTO> dtos = compras.stream()
                .map(ComprasDTO::new)
                .toList();
        return ResponseEntity.ok(dtos);
    }

    //Compras
    public ResponseEntity<String> adicionarComprasParaCliente(Long clienteId, List<Long> produtoIds) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        List<Produto> produtos = produtoRepository.findAllById(produtoIds);
        if (produtos.isEmpty()) {
            return ResponseEntity.badRequest().body("Nenhum produto válido encontrado");
        }
        List<Compras> comprasList = produtos.stream().map(produto -> {
            Compras compra = new Compras();
            compra.setCliente(cliente);
            compra.setProduto(produto);
            return compra;
        }).toList();
        comprasRepository.saveAll(comprasList);
        return ResponseEntity.ok("Compras adicionadas com sucesso.");
    }

}
