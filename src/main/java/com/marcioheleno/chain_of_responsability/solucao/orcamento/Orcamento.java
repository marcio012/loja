package com.marcioheleno.chain_of_responsability.solucao.orcamento;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */

@Data
@AllArgsConstructor
public class Orcamento {

    private BigDecimal valor;
    private int quantidadeItens;

}
