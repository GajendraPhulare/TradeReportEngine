package com.jpmorgan.report.design.reportmodel.impl;

import java.time.LocalDate;
import java.util.Map;

import com.jpmorgan.report.design.reportmodel.Report;
import com.jpmorgan.report.dto.ReportDto;

public class PlainTextTradeReport extends Report {

	private Map<LocalDate, ReportDto> reportItemList;

	public PlainTextTradeReport(String reportTitle, LocalDate reportGenerationDate,
			Map<LocalDate, ReportDto> reportItemList) {
		super(reportTitle, reportGenerationDate);
		this.reportItemList = reportItemList;
	}

	public Map<LocalDate, ReportDto> getReportItemList() {
		return reportItemList;
	}

	public void setReportItemList(Map<LocalDate, ReportDto> reportItemList) {
		this.reportItemList = reportItemList;
	}

}
