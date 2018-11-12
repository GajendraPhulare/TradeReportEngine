package com.jpmorgan.report.design.abstractfactory.impl;

import com.jpmorgan.report.design.abstractfactory.ReportAbstractFactory;
import com.jpmorgan.report.design.reportmodel.Report;

public final class ReportFactory {

	public final static Report getReport(ReportAbstractFactory factory) {
		return factory.createReport();
	}

}
