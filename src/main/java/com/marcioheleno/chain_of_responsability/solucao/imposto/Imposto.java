package com.marcioheleno.chain_of_responsability.solucao.imposto;

import com.marcioheleno.chain_of_responsability.solucao.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public interface Imposto {

    BigDecimal calcular(Orcamento orcamento);
}
