package com.marcioheleno.chain_of_responsability.problema.teste;

import com.marcioheleno.chain_of_responsability.problema.imposto.CalculadoraDeImpostos;
import com.marcioheleno.chain_of_responsability.problema.imposto.TipoImposto;
import com.marcioheleno.chain_of_responsability.problema.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public class TesteDescontos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        var calcularImposto = new CalculadoraDeImpostos();
        System.out.println(calcularImposto.calcular(orcamento, TipoImposto.ICMS));
        System.out.println(calcularImposto.calcular(orcamento, TipoImposto.ISS));
    }
}
