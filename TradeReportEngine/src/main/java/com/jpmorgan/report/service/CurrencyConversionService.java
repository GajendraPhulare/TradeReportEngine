package com.jpmorgan.report.service;

import java.math.BigDecimal;

import com.jpmorgan.report.enums.CurrencyType;

public final class CurrencyConversionService {

	public static final BigDecimal getCurrencyExchangeRateToUSD(CurrencyType from) {
		if (from != null) {
			switch (from) {
			case AED:
				return BigDecimal.valueOf(60);
			case GBP:
				return BigDecimal.valueOf(30);
			case USD:
				return BigDecimal.valueOf(20);
			default:
				return BigDecimal.valueOf(10);
			}
		}
		return null;
	}

}
