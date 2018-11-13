package com.jpmorgan.report.factory;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jpmorgan.report.design.abstractfactory.impl.PlainTextTradeReportFactory;
import com.jpmorgan.report.design.command.impl.CalculateTradeAmountCommand;
import com.jpmorgan.report.design.command.impl.EntityCmdProcessorImpl;
import com.jpmorgan.report.design.command.impl.SettlementDateCommand;
import com.jpmorgan.report.design.reportmodel.impl.PlainTextTradeReport;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.dto.ReportDto;
import com.jpmorgan.report.enums.CurrencyType;
import com.jpmorgan.report.enums.TradeType;

public class PlainTextTradeReportfactoryTest {

	@Test
	public void testProcessMethod() {

		final List<ClientEntity> clientEntityList = new ArrayList();
		final List<ClientEntity> clientEntityListIncoming = new ArrayList();
		final List<ClientEntity> clientEntityListOutgoing = new ArrayList();

		final ClientEntity clientEntity_1 = new ClientEntity("Richar P", 1001, TradeType.BUY, BigDecimal.valueOf(0.50),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(200), BigDecimal.valueOf(100.25));
		final ClientEntity clientEntity_2 = new ClientEntity("Ricardo ", 1002, TradeType.SELL, BigDecimal.valueOf(0.55),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(230), BigDecimal.valueOf(100.55));

		clientEntityList.add(clientEntity_1);
		clientEntityList.add(clientEntity_2);
		final EntityCmdProcessorImpl entityCmdProcessorImpl = new EntityCmdProcessorImpl(clientEntityList);
		entityCmdProcessorImpl.addCommand(new SettlementDateCommand());
		entityCmdProcessorImpl.addCommand(new CalculateTradeAmountCommand());

		final List<ClientEntity> resultedClientEntityList = entityCmdProcessorImpl.process();
		final PlainTextTradeReport report = (PlainTextTradeReport) new PlainTextTradeReportFactory(
				resultedClientEntityList).createReport();
		clientEntityListIncoming.add(clientEntity_2);
		clientEntityListOutgoing.add(clientEntity_1);
		new ReportDto(LocalDate.of(2018, 10, 11), BigDecimal.valueOf(763174.5000), BigDecimal.valueOf(601500.000),
				clientEntityListIncoming, clientEntityListOutgoing);

		assertTrue(report.getReportItemList().get(LocalDate.of(2018, 10, 11)).getIncomingClientList().get(0)
				.equals(clientEntity_2));
		assertTrue(report.getReportItemList().get(LocalDate.of(2018, 10, 11)).getOutgoinggClientList().get(0)
				.equals(clientEntity_1));

	}

}
