package com.jpmorgan.report.command;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.jpmorgan.report.design.command.impl.SettlementDateCommand;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.enums.CurrencyType;
import com.jpmorgan.report.enums.TradeType;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SettlementDateCommand.class)
public class SettlementDateCommandTest {

	@Test
	public void testSettlementDateMethod() {
		LocalDate settlementDate;
		try {
			settlementDate = Whitebox.invokeMethod(new SettlementDateCommand(), "settlementDate",
					new ClientEntity("Richar P", 1001, TradeType.BUY, BigDecimal.valueOf(0.50), CurrencyType.AED,
							LocalDate.of(2018, 10, 11), BigDecimal.valueOf(200), BigDecimal.valueOf(100.25)));
			assertEquals(LocalDate.of(2018, 10, 11), settlementDate);
		} catch (final Exception e) {

			e.printStackTrace();
		}

	}

}
