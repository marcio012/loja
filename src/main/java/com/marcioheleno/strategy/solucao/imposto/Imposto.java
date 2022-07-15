package com.marcioheleno.strategy.solucao.imposto;

import com.marcioheleno.strategy.solucao.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public interface Imposto {

    BigDecimal calcular(Orcamento orcamento);
}
