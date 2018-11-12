package com.jpmorgan.report.design.abstractfactory.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.jpmorgan.report.design.abstractfactory.ReportAbstractFactory;
import com.jpmorgan.report.design.reportmodel.Report;
import com.jpmorgan.report.design.reportmodel.impl.PlainTextTradeReport;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.dto.ReportDto;
import com.jpmorgan.report.enums.TradeType;

public class PlainTextTradeReportFactory implements ReportAbstractFactory {

	private List<ClientEntity> clientEntityList = new ArrayList();

	public PlainTextTradeReportFactory(List<ClientEntity> clientEntityList) {

		this.clientEntityList = clientEntityList;

	}

	public List<ClientEntity> getClientEntityList() {
		return clientEntityList;
	}

	public void setClientEntityList(List<ClientEntity> clientEntityList) {
		this.clientEntityList = clientEntityList;
	}

	@Override
	public Report createReport() {
		PlainTextTradeReport report = null;
		final Map<LocalDate, ReportDto> dailyReportDto = new HashMap();
		if (this.clientEntityList != null && !this.clientEntityList.isEmpty()) {

			final Map<LocalDate, List<ClientEntity>> clientListGroupedByDate = groupClientListByDate(clientEntityList);
			if (clientListGroupedByDate != null && !clientListGroupedByDate.isEmpty()) {
				for (final LocalDate instructionDate : clientListGroupedByDate.keySet()) {
					final ReportDto reportDto = createReportDto(instructionDate,
							clientListGroupedByDate.get(instructionDate));
					dailyReportDto.put(instructionDate, reportDto);
				}
				report = new PlainTextTradeReport("Daily Trade Report", LocalDate.now(), dailyReportDto);
			}

		}
		return report;
	}

	private Map<LocalDate, List<ClientEntity>> groupClientListByDate(List<ClientEntity> clientEntityList) {
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			return clientEntityList.stream().collect(Collectors.groupingBy(ClientEntity::getInstructiondate));

		}
		return null;
	}

	private BigDecimal calculateTotalIncomingAmount(List<ClientEntity> clientEntityList) {
		BigDecimal totalIncomingAmount = null;
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			totalIncomingAmount = clientEntityList.stream().filter(e -> e.getTradetype().equals(TradeType.SELL))
					.map(e -> e.getTradeAmount()).reduce(BigDecimal.valueOf(0), BigDecimal::add);

		}
		return totalIncomingAmount;

	}

	private BigDecimal calculateTotalOutgoingAmount(List<ClientEntity> clientEntityList) {
		BigDecimal totalOutgoingAmount = null;
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			totalOutgoingAmount = clientEntityList.stream().filter(e -> e.getTradetype().equals(TradeType.BUY))
					.map(e -> e.getTradeAmount()).reduce(BigDecimal.valueOf(0), BigDecimal::add);

		}
		return totalOutgoingAmount;

	}

	private List<ClientEntity> sortByIncomingAmount(List<ClientEntity> clientEntityList) {
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			clientEntityList = clientEntityList.stream().filter(e -> e.getTradetype() == TradeType.SELL)
					.sorted(Comparator.comparing(ClientEntity::getTradeAmount).reversed()).collect(Collectors.toList());

		}
		return clientEntityList;
	}

	private List<ClientEntity> sortByOutgoingAmount(List<ClientEntity> clientEntityList) {
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			clientEntityList = clientEntityList.stream().filter(e -> e.getTradetype() == TradeType.BUY)
					.sorted(Comparator.comparing(ClientEntity::getTradeAmount).reversed()).collect(Collectors.toList());

		}
		return clientEntityList;
	}

	private ReportDto createReportDto(LocalDate instructionDate, List<ClientEntity> clientEntityList) {
		ReportDto reportDto = null;
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			final LocalDate tempInstructionDate = instructionDate;
			final BigDecimal totalIncomingAmount = calculateTotalIncomingAmount(clientEntityList);
			final BigDecimal totalOutgoingAmount = calculateTotalOutgoingAmount(clientEntityList);
			final List<ClientEntity> clientEntityListSortedByIncomingAmount = sortByIncomingAmount(clientEntityList);
			final List<ClientEntity> clientEntityListSortedByOutgoingAmount = sortByOutgoingAmount(clientEntityList);
			reportDto = new ReportDto(tempInstructionDate, totalIncomingAmount, totalOutgoingAmount,
					clientEntityListSortedByIncomingAmount, clientEntityListSortedByOutgoingAmount);

		}

		return reportDto;

	}

}
