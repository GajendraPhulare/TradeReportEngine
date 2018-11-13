package com.jpmorgan.report.command;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.jpmorgan.report.design.command.impl.CalculateTradeAmountCommand;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.enums.CurrencyType;
import com.jpmorgan.report.enums.TradeType;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CalculateTradeAmountCommand.class)
public class CalculateTradeAmountCommandTest {

	@Test
	public void testExecuteMethod() {

		final CalculateTradeAmountCommand calculateTradeAmountCommand = new CalculateTradeAmountCommand();
		final List<ClientEntity> clientEntityList = new ArrayList();

		final ClientEntity clientEntity_1 = new ClientEntity("Richar P", 1001, TradeType.BUY, BigDecimal.valueOf(0.50),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(200), BigDecimal.valueOf(100.25));
		final ClientEntity clientEntity_2 = new ClientEntity("Ricardo ", 1002, TradeType.SELL, BigDecimal.valueOf(0.55),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(230), BigDecimal.valueOf(100.55));

		clientEntityList.add(clientEntity_1);
		clientEntityList.add(clientEntity_2);
		final List<ClientEntity> resultedClientEntityList = calculateTradeAmountCommand.execute(clientEntityList);

		assertTrue(BigDecimal.valueOf(601500).compareTo(resultedClientEntityList.get(0).getTradeAmount()) == 0);
	}

}
