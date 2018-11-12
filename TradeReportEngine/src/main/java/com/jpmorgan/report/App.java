package com.jpmorgan.report;

import java.time.LocalDate;
import java.util.List;

import com.jpmorgan.report.dao.impl.ClientEntityTradeDaoImpl;
import com.jpmorgan.report.design.abstractfactory.impl.PlainTextTradeReportFactory;
import com.jpmorgan.report.design.abstractfactory.impl.ReportFactory;
import com.jpmorgan.report.design.command.impl.CalculateTradeAmountCommand;
import com.jpmorgan.report.design.command.impl.EntityCmdProcessorImpl;
import com.jpmorgan.report.design.command.impl.SettlementDateCommand;
import com.jpmorgan.report.design.reportmodel.Report;
import com.jpmorgan.report.design.reportmodel.impl.PlainTextTradeReport;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.dto.ReportDto;

public class App {
	public static void main(String[] args) {
		final PlainTextTradeReport report = (PlainTextTradeReport) initReport();
		printReportDetails(report);
	}

	private static void printReportDetails(PlainTextTradeReport report) {
		System.out.println("Report Title: " + report.getReportTitle());
		System.out.println("**************************************************************************************");
		for (final LocalDate instructionDate : report.getReportItemList().keySet()) {
			final ReportDto reportDto = report.getReportItemList().get(instructionDate);
			System.out.println("+Instruction Date: " + instructionDate.toString());
			System.out.println("+Incoming Amount Settled(USD): " + reportDto.getTotalIncomingAmount());
			System.out.println("+Outgoing Amount Settled(USD): " + reportDto.getTotalOutGoingAmount());
			System.out.println("+Incoming Ranking");
			printRow(reportDto.getIncomingClientList());
			System.out.println("+Outgoing Ranking");
			printRow(reportDto.getOutgoinggClientList());
			System.out.println("*********************************************************************************");
		}

	}

	private static Report initReport() {
		final ClientEntityTradeDaoImpl clientEntityTradeDaoImpl = new ClientEntityTradeDaoImpl();
		final List<ClientEntity> ce = clientEntityTradeDaoImpl.getAll();
		final EntityCmdProcessorImpl entityCmdProcessorImpl = new EntityCmdProcessorImpl(ce);
		entityCmdProcessorImpl.addCommand(new CalculateTradeAmountCommand());
		entityCmdProcessorImpl.addCommand(new SettlementDateCommand());
		final PlainTextTradeReport report = (PlainTextTradeReport) ReportFactory
				.getReport(new PlainTextTradeReportFactory(entityCmdProcessorImpl.process()));
		return report;
	}

	private static void printRow(List<ClientEntity> clientEntityList) {
		printColumnTitle();
		int rank = 0;
		for (final ClientEntity clientEntity : clientEntityList) {
			rank++;
			System.out.println(rank + "         " + clientEntity.getName() + "         "
					+ clientEntity.getSettlementDate() + "         " + clientEntity.getCurrencyType() + "          "
					+ clientEntity.getTradeAmount());
		}
	}

	private static void printColumnTitle() {
		System.out.println("Rank No.   Client Name   Settlement Date   Currency Type    Amount(USD)");
	}
}
