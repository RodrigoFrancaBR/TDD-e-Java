package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		
		BigDecimal valorDeDezPorcentoDoSalario = funcionario.obterValorBaseadoNoPercentualDoSalario(new BigDecimal("0.1"));
		
		int compareTo = valorDeDezPorcentoDoSalario.compareTo(new BigDecimal("1000.00"));
		
		if (compareTo > 0) {
			throw new IllegalArgumentException("Não é possível calcular bonus, aonde dez porcento do salário é maior do que 1000.00");
		}
		
		return valorDeDezPorcentoDoSalario;
	}

}
