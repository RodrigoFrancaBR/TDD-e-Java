package tdd;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.enun.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajustePorDesempenhoService;

public class ReajustePorDesempenhoServiceTest {

	private static ReajustePorDesempenhoService service;
	private Funcionario funcionario;
	private static int contador = 1;

	@BeforeAll
	public static void beforeAll() {
		service = new ReajustePorDesempenhoService();
	}

	@BeforeEach
	public void beforeEach() {
		funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000.00"));
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Rodando teste: " + contador++);
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("Todos os testes passaram.");
	}

	@Test
	public void reajusteDeveSerDeTresPorcentoDoSalarioSeDesempenhoForADesejar() {

		service.reajustarSalarioPorDesempenho(funcionario, Desempenho.A_DESEJAR);
		Assertions.assertEquals(funcionario.getSalario(), new BigDecimal("1030.00"));
	}

	@Test
	public void reajusteDeveSerDeQuinzePorcentoDoSalarioSeDesempenhoForBom() {

		service.reajustarSalarioPorDesempenho(funcionario, Desempenho.BOM);
		Assertions.assertEquals(funcionario.getSalario(), new BigDecimal("1150.00"));
	}

	@Test
	public void reajusteDeveSerDeVintePorcentoDoSalarioSeDesempenhoForOtimo() {

		service.reajustarSalarioPorDesempenho(funcionario, Desempenho.OTIMO);
		Assertions.assertEquals(funcionario.getSalario(), new BigDecimal("1200.00"));

	}
}
