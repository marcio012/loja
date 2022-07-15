package com.marcioheleno.strategy.solucao.teste;

import com.marcioheleno.strategy.solucao.imposto.CalculadoraDeImpostos;
import com.marcioheleno.strategy.solucao.imposto.ICMS;
import com.marcioheleno.strategy.solucao.imposto.ISS;
import com.marcioheleno.strategy.solucao.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public class TesteImposto {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        var calcularImposto = new CalculadoraDeImpostos();
        System.out.println(calcularImposto.calcular(orcamento, new ICMS()));
        System.out.println(calcularImposto.calcular(orcamento, new ISS()));
    }
}
