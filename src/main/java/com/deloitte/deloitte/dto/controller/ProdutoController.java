package com.deloitte.deloitte.dto.controller;

import com.deloitte.deloitte.dto.model.dto.ProdutoDTO;
import com.deloitte.deloitte.dto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> exibirTodosOsProdutos() {
        return produtoService.exibirTodosOsProdutos();
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return produtoService.criarProduto(produtoDTO);
    }
}
