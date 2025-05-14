package com.deloitte.deloitte.dto.service;

import com.deloitte.deloitte.dto.model.dto.ProdutoDTO;
import com.deloitte.deloitte.dto.model.entity.Produto;
import com.deloitte.deloitte.dto.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
}
