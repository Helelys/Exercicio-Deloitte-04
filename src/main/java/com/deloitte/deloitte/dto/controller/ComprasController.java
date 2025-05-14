package com.deloitte.deloitte.dto.controller;

import com.deloitte.deloitte.dto.model.dto.ComprasDTO;
import com.deloitte.deloitte.dto.service.ComprasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class ComprasController {

    private final ComprasService comprasService;

    @PostMapping("/{clienteId}")
    public ResponseEntity<String> adicionarCompras(
            @PathVariable Long clienteId,
            @RequestBody List<Long> produtoIds
    ) {
        return comprasService.adicionarComprasParaCliente(clienteId, produtoIds);
    }

    @GetMapping
    public ResponseEntity<List<ComprasDTO>> exibirTodasAsCompras() {
        return comprasService.exibirTodasAsCompras();
    }
}
