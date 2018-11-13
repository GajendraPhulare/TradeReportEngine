package com.jpmorgan.report.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.jpmorgan.report.enums.CurrencyType;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CurrencyConversionService.class)
public class CurrencyExchangeServiceTest {

	@Test
	public void testGetCurrencyExchangeRateToUSDMethod() {
		PowerMockito.mockStatic(CurrencyConversionService.class);
		when(CurrencyConversionService.getCurrencyExchangeRateToUSD(CurrencyType.AED))
				.thenReturn(BigDecimal.valueOf(60));
		when(CurrencyConversionService.getCurrencyExchangeRateToUSD(CurrencyType.GBP))
				.thenReturn(BigDecimal.valueOf(30));
		when(CurrencyConversionService.getCurrencyExchangeRateToUSD(CurrencyType.SAR))
				.thenReturn(BigDecimal.valueOf(10));

		assertEquals(CurrencyConversionService.getCurrencyExchangeRateToUSD(CurrencyType.AED), BigDecimal.valueOf(60));

	}

}
