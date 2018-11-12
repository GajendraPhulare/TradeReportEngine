package com.jpmorgan.report.design.command.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import com.jpmorgan.report.design.command.Command;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.enums.CurrencyType;

public class SettlementDateCommand implements Command<ClientEntity> {

	public SettlementDateCommand() {

	}

	@Override
	public List<ClientEntity> execute(List<ClientEntity> clientEntityList) {
		if (clientEntityList != null && !clientEntityList.isEmpty()) {
			for (final ClientEntity clientEntity : clientEntityList) {
				clientEntity.setSettlementDate(this.settlementDate(clientEntity));
			}
		}
		return clientEntityList;
	}

	private LocalDate settlementDate(ClientEntity clientEntity) {
		if (clientEntity != null) {
			final DayOfWeek day = clientEntity.getInstructiondate().getDayOfWeek();
			final CurrencyType currency = clientEntity.getCurrencyType();
			if (currency == CurrencyType.AED || currency == CurrencyType.SAR) {
				switch (day) {
				case FRIDAY:
					return clientEntity.getInstructiondate().plusDays(2);
				case SATURDAY:
					return clientEntity.getInstructiondate().plusDays(1);
				default:
					return clientEntity.getInstructiondate();
				}
			} else {
				switch (day) {
				case SATURDAY:
					return clientEntity.getInstructiondate().plusDays(2);
				case SUNDAY:
					return clientEntity.getInstructiondate().plusDays(1);
				default:
					return clientEntity.getInstructiondate();
				}
			}

		}
		return clientEntity.getInstructiondate();
	};

}
