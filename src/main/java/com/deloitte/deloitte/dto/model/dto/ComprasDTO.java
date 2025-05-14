package com.deloitte.deloitte.dto.model.dto;

import com.deloitte.deloitte.dto.model.entity.Cliente;
import com.deloitte.deloitte.dto.model.entity.Compras;
import com.deloitte.deloitte.dto.model.entity.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComprasDTO {
    private Long id;
    private Cliente cliente;
    private Produto produto;

    public static Compras toEntity(ComprasDTO comprasDTO) {
        Compras compras = new Compras();
        compras.setId(comprasDTO.getId());
        compras.setCliente(comprasDTO.getCliente());
        comprasDTO.setProduto(comprasDTO.getProduto());
        return compras;
    }

    public ComprasDTO(Compras compras) {
        this.id = compras.getId();
        this.cliente = compras.getCliente();
        this.produto = compras.getProduto();
    }
}
