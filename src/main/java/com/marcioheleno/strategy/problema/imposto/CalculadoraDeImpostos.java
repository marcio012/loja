package com.marcioheleno.strategy.problema.imposto;

import com.marcioheleno.strategy.problema.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public class CalculadoraDeImpostos {

    public BigDecimal calcular(Orcamento orcamento, TipoImposto tipoImposto) {

        // Problema da implementação
        // a classe vai sempre crescer
        // pois elea varia pelo tipo de imposto
        switch (tipoImposto) {
            case ICMS:
                return orcamento.getValor().multiply(new BigDecimal("0.1"));
            case ISS:
                return orcamento.getValor().multiply(new BigDecimal("0.06"));
            default:
                return BigDecimal.ZERO;
        }

        // solução :
        // usar um padrão de projeto o Strategy
    }
}
