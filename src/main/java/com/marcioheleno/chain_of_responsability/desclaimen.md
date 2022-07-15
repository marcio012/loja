# Aplicabilidade do Pardão Strategy.

## Principais característica de seu uso

- Repertição de codigo e diminuição de ponto para manutenção
- Evita o crescimento da classe. 

Exemplos:

Classe padrão que simula um entidade: 

~~~ java
package com.marcioheleno.strategy.orcamento;

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

}
    
~~~

Um Tipo Enum para representação: 

~~~java
package com.marcioheleno.strategy.imposto;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public enum TipoImposto {
    ICMS,
    ISS
}
~~~

A Classe na qual observamos o problema ocorrer

~~~java
package com.marcioheleno.strategy.imposto;

import com.marcioheleno.strategy.problema.imposto.TipoImposto;
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
    }
}

~~~

O problema na classe a cima é.

E aí pessoal. Continuando aqui. Na última aula nós implementamos a 
"CalculadoraDeImpostos" e ela ficou com esse código aqui. 
Embora esteja funcionando e eu consiga adicionar outros tipos de impostos, 
nós discutimos que esse tipo de código não está muito legal porque a classe 
sempre vai crescer. Sempre que tiver um novo imposto eu vou ter que colocar 
um novo "case".

Então vai ficar um código gigante e com todos os tipos de cálculos, todas as 
estratégias de cálculo de impostos possíveis tudo amarrado, tudo vinculado 
aqui dentro dessa mesma classe. Então a ideia para resolvermos esse problema 
de uma maneira mais elegante seria tentar extrair cada tipo de cálculo desse 
daqui. Então em vez de usar um "enum" nós poderíamos extrair cada cálculo desse 
para uma classe separada e aí cada classe tem o seu único cálculo específico.

Então eu tenho a classe do "ICMS", do "ISS" e assim sucessivamente. Então vamos 
lá. O que vamos fazer? Vamos aqui no pacote imposto criar uma nova classe, 
"class" e o nome dessa classe vai ser "ICMS". Então o objetivo dessa classe 
é justamente representar o imposto de ICMS, representar o cálculo do imposto 
de ICMS. Então aqui eu vou criar aquele método public BigDecimal calcular e 
ele recebe como parâmetro o orçamento.

## Solução

A classe que representa nosso modelo

~~~java
package com.marcioheleno.strategy.solucao.orcamento;

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

}

~~~

Aplica o padrão Strategy cada imposto tem sua implementação de 
calclular seu valor.

- ICMS

~~~java
package com.marcioheleno.strategy.solucao.imposto;

import com.marcioheleno.strategy.solucao.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public class ICMS implements Imposto{

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}

~~~

- ISS
~~~java
package com.marcioheleno.strategy.solucao.imposto;

import com.marcioheleno.strategy.solucao.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public class ISS implements Imposto{

    @Override
    public BigDecimal calcular(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.06"));
    }
}

~~~

- Inteeface pois o metodo calcular repete varias vezes. 

~~~java

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

~~~

- implementação fica mais coesa

~~~java
package com.marcioheleno.strategy.solucao.imposto;

import com.marcioheleno.strategy.solucao.orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * @author marciopessoa
 * @date 15/07/22
 */
public class CalculadoraDeImpostos {

    public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
        return imposto.calcular(orcamento);
    }

}
~~~

- Class de teste

~~~java
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
public class TesteImpostoStrategy {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        var calcularImposto = new CalculadoraDeImpostos();
        System.out.println(calcularImposto.calcular(orcamento, new ICMS()));
        System.out.println(calcularImposto.calcular(orcamento, new ISS()));
    }
}

~~~