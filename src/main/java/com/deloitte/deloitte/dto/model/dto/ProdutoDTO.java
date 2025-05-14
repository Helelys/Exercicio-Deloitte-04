package com.deloitte.deloitte.dto.model.dto;

import com.deloitte.deloitte.dto.model.entity.Produto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nomeDoProduto;

    public static Produto toEntity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setNomeDoProduto(produtoDTO.getNomeDoProduto());
        return produto;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nomeDoProduto = produto.getNomeDoProduto();
    }
}
