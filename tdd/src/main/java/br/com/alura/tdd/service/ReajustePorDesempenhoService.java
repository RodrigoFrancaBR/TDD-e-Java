package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.enun.Desempenho;

public class ReajustePorDesempenhoService {

	public BigDecimal reajustarSalario(BigDecimal salario, Desempenho desempenho) {

		BigDecimal divide = BigDecimal.ZERO;

		if (desempenho.equals(Desempenho.a_desejar)) {
			divide = new BigDecimal("0.03").multiply(salario).setScale(1);
		}

		return divide;
	}

}
