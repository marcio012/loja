package com.marcioheleno.chain_of_responsability.solucao.teste;

import com.marcioheleno.chain_of_responsability.solucao.imposto.CalculadoraDeImpostos;
import com.marcioheleno.chain_of_responsability.solucao.imposto.ICMS;
import com.marcioheleno.chain_of_responsability.solucao.imposto.ISS;
import com.marcioheleno.chain_of_responsability.solucao.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public class TesteImpostoStrategy {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        var calcularImposto = new CalculadoraDeImpostos();
        System.out.println(calcularImposto.calcular(orcamento, new ICMS()));
        System.out.println(calcularImposto.calcular(orcamento, new ISS()));
    }
}
