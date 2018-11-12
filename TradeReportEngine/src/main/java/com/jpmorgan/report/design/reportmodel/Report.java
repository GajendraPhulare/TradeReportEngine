package com.jpmorgan.report.design.reportmodel;

import java.time.LocalDate;

public abstract class Report {

	private String reportTitle;
	private LocalDate reportGenerationDate;

	public Report(String reportTitle, LocalDate reportGenerationDate) {

		this.reportTitle = reportTitle;
		this.reportGenerationDate = reportGenerationDate;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public LocalDate getReportGenerationDate() {
		return reportGenerationDate;
	}

	public void setReportGenerationDate(LocalDate reportGenerationDate) {
		this.reportGenerationDate = reportGenerationDate;
	}

}
