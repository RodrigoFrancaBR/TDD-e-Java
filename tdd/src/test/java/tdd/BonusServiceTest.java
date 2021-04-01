package tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

	@Test
	public void bonusZeroSeDezPorCentoDoSalarioForMaiorQueMil() {

		BonusService bonusService = new BonusService();

		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10001.0")));

		assertEquals(BigDecimal.ZERO, bonus);

	}
	
	@Test
	public void bonusDeDezPorCentoDoSalarioSeDezPorCentoDoSalarioForMenorQueMil() {

		BonusService bonusService = new BonusService();

		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("9999.0")));

		Assertions.assertEquals(new BigDecimal("999.90"), bonus);

	}
	

	@Test
	public void bonusDeDezPorCentoDoSalarioSeDezPorCentoDoSalarioForIgualAMil() { 

		BonusService bonusService = new BonusService();

		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000.0")));

		Assertions.assertEquals(new BigDecimal("1000.00"), bonus);

	}
}
