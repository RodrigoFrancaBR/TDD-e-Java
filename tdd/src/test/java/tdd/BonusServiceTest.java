package tdd;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

	@Test
	public void deveLancarIllegalArgumentExceptionSeDezPorCentoDoSalarioForMaiorQueMil() {

		BonusService bonusService = new BonusService();
		
		Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10001.0"));
		
		assertThrows(IllegalArgumentException.class, () -> bonusService
				.calcularBonus(funcionario));
	}

	@Test
	public void bonusDeDezPorCentoDoSalarioSeDezPorCentoDoSalarioForMenorQueMil() {

		BonusService bonusService = new BonusService();
		
		Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("9999.0"));
		
		BigDecimal bonus = bonusService
				.calcularBonus(funcionario);

		Assertions.assertEquals(bonus, new BigDecimal("999.90"));

	}

	@Test
	public void bonusDeDezPorCentoDoSalarioSeDezPorCentoDoSalarioForIgualAMil() {

		BonusService bonusService = new BonusService();
		
		Funcionario funcionario = new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000.0"));
		
		BigDecimal bonus = bonusService
				.calcularBonus(funcionario);

		Assertions.assertEquals(bonus, new BigDecimal("1000.00"));

	}
}
