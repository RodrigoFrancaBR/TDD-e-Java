package tdd;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.enun.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajustePorDesempenhoService;

public class ReajustePorDesempenhoServiceTest {

	@Test
	public void reajusteDeveSerDeTresPorcentoDoSalarioSeDesempenhoForADesejar() {

		ReajustePorDesempenhoService service = new ReajustePorDesempenhoService();

		Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000.00"));

		service.reajustarSalarioPorDesempenho(funcionario, Desempenho.A_DESEJAR);

		Assertions.assertEquals(funcionario.getSalario(), new BigDecimal("1030.00"));

	}
	
	@Test
	public void reajusteDeveSerDeQuinzePorcentoDoSalarioSeDesempenhoForBom() {

		ReajustePorDesempenhoService service = new ReajustePorDesempenhoService();

		Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000.00"));

		service.reajustarSalarioPorDesempenho(funcionario, Desempenho.BOM);

		Assertions.assertEquals(funcionario.getSalario(), new BigDecimal("1150.00"));

	}
	
	@Test
	public void reajusteDeveSerDeVintePorcentoDoSalarioSeDesempenhoForOtimo() {

		ReajustePorDesempenhoService service = new ReajustePorDesempenhoService();

		Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000.00"));

		service.reajustarSalarioPorDesempenho(funcionario, Desempenho.OTIMO);

		Assertions.assertEquals(funcionario.getSalario(), new BigDecimal("1200.00"));

	}
}
