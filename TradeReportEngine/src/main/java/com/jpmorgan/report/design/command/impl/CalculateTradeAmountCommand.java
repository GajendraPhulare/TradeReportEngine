package com.jpmorgan.report.design.command.impl;

import java.util.List;

import com.jpmorgan.report.design.command.Command;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.service.CurrencyConversionService;

public class CalculateTradeAmountCommand implements Command<ClientEntity> {

	public CalculateTradeAmountCommand() {

	}

	@Override
	public List<ClientEntity> execute(List<ClientEntity> clientEntityList) {
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			for (final ClientEntity clientEntity : clientEntityList) {
				clientEntity.setTradeAmount(clientEntity.getAgreedFx()
						.multiply(clientEntity.getPricePerUnit()
								.multiply(clientEntity.getUnits().multiply(CurrencyConversionService
										.getCurrencyExchangeRateToUSD(clientEntity.getCurrencyType())))));
			}
		}
		return clientEntityList;
	}

}
