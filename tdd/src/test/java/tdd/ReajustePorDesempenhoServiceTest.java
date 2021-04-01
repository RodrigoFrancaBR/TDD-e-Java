package tdd;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.enun.Desempenho;
import br.com.alura.tdd.service.ReajustePorDesempenhoService;

public class ReajustePorDesempenhoServiceTest {

	@Test
	public void reajusteDeveSerDeTresPorcentoDoSalarioSeDesempenhoForADesejar() {
		
		ReajustePorDesempenhoService service = new ReajustePorDesempenhoService();
		
		BigDecimal reajusteSalarial = service.reajustarSalario(new BigDecimal("1000.0"), Desempenho.a_desejar);
		
		Assertions.assertEquals(reajusteSalarial, new BigDecimal("30.0"));
		
	}
}
