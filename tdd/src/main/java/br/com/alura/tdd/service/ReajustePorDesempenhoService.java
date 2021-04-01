package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.enun.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajustePorDesempenhoService {

	public void reajustarSalarioPorDesempenho(Funcionario funcionario, Desempenho desempenho) {

		if (desempenho.equals(Desempenho.A_DESEJAR)) {

			BigDecimal reajusteSalarial = new BigDecimal("0.03").multiply(funcionario.getSalario()).setScale(2);

			funcionario.reajustarSalario(reajusteSalarial);
		}
	}

}
