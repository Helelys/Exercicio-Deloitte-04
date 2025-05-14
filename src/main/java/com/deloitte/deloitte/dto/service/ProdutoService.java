package com.deloitte.deloitte.dto.service;

import com.deloitte.deloitte.dto.model.dto.ProdutoDTO;
import com.deloitte.deloitte.dto.model.entity.Produto;
import com.deloitte.deloitte.dto.repository.ProdutoRepository;
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
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    //Get
    public ResponseEntity<List<ProdutoDTO>> exibirTodosOsProdutos(){
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> dtos = produtos.stream()
                .map(ProdutoDTO::new)
                .toList();

        return ResponseEntity.ok(dtos);
    }

    //Post
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO dto) {
        Produto produto = ProdutoDTO.toEntity(dto);
        Produto salvo = produtoRepository.save(produto);
        return ResponseEntity.ok(new ProdutoDTO(salvo));
    }

    //Put
    public ResponseEntity<ProdutoDTO> alterarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<Produto> existe = produtoRepository.findById(id);
        if (existe.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontraodo");
        }
        Produto produtoAtualizado = ProdutoDTO.toEntity(produtoDTO);
        produtoAtualizado.setId(id);
        Produto salvo = produtoRepository.save(produtoAtualizado);
        return ResponseEntity.ok(new ProdutoDTO(salvo));
    }
}
