package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.enun.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajustePorDesempenhoService {

	public void reajustarSalarioPorDesempenho(Funcionario funcionario, Desempenho desempenho) {

		BigDecimal percentual = desempenho.obterPercentualReajuste();
		
		BigDecimal reajusteSalarial = funcionario.obterValorPercentualDoSalario(percentual);
		
		funcionario.reajustarSalario(reajusteSalarial);
				
	}

}
