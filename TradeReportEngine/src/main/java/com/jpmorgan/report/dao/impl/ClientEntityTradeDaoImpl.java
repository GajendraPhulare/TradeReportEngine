package com.jpmorgan.report.dao.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.jpmorgan.report.dao.ClientEntityTradeDao;
import com.jpmorgan.report.dto.ClientEntity;
import com.jpmorgan.report.enums.CurrencyType;
import com.jpmorgan.report.enums.TradeType;

public class ClientEntityTradeDaoImpl implements ClientEntityTradeDao<ClientEntity> {

	private final List<ClientEntity> clientEntityList;

	public ClientEntityTradeDaoImpl() {
	}

	{
		clientEntityList = new ArrayList<ClientEntity>();

		clientEntityList.add(new ClientEntity("Richar P", 1001, TradeType.BUY, BigDecimal.valueOf(0.50),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(200), BigDecimal.valueOf(100.25)));
		clientEntityList.add(new ClientEntity("Ricardo ", 1002, TradeType.SELL, BigDecimal.valueOf(0.55),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(230), BigDecimal.valueOf(100.55)));

		clientEntityList.add(new ClientEntity("Dan Brown", 1003, TradeType.BUY, BigDecimal.valueOf(0.40),
				CurrencyType.SAR, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(200), BigDecimal.valueOf(100.25)));

		clientEntityList.add(new ClientEntity("Jack D   ", 1004, TradeType.SELL, BigDecimal.valueOf(0.60),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(400), BigDecimal.valueOf(10.25)));

		clientEntityList.add(new ClientEntity("Raman J  ", 1005, TradeType.BUY, BigDecimal.valueOf(0.40),
				CurrencyType.AED, LocalDate.of(2018, 10, 11), BigDecimal.valueOf(200), BigDecimal.valueOf(140.25)));

		clientEntityList.add(new ClientEntity("Ricky    ", 1006, TradeType.SELL, BigDecimal.valueOf(0.30),
				CurrencyType.AED, LocalDate.of(2018, 10, 12), BigDecimal.valueOf(300), BigDecimal.valueOf(150.25)));

		clientEntityList.add(new ClientEntity("Sammy P   ", 1007, TradeType.SELL, BigDecimal.valueOf(0.50),
				CurrencyType.SAR, LocalDate.of(2018, 10, 12), BigDecimal.valueOf(200), BigDecimal.valueOf(120.25)));

		clientEntityList.add(new ClientEntity("Alan Donal", 1008, TradeType.BUY, BigDecimal.valueOf(0.20),
				CurrencyType.AED, LocalDate.of(2018, 10, 12), BigDecimal.valueOf(280), BigDecimal.valueOf(600.25)));

		clientEntityList.add(new ClientEntity("Alex F    ", 1009, TradeType.SELL, BigDecimal.valueOf(0.50),
				CurrencyType.GBP, LocalDate.of(2018, 10, 12), BigDecimal.valueOf(60), BigDecimal.valueOf(100.25)));

		clientEntityList.add(new ClientEntity("James Bond", 1010, TradeType.BUY, BigDecimal.valueOf(0.60),
				CurrencyType.AED, LocalDate.of(2018, 10, 12), BigDecimal.valueOf(700), BigDecimal.valueOf(40.25)));

		clientEntityList.add(new ClientEntity("Rohan K  ", 1011, TradeType.SELL, BigDecimal.valueOf(0.23),
				CurrencyType.AED, LocalDate.of(2018, 10, 12), BigDecimal.valueOf(440), BigDecimal.valueOf(150.25)));

		clientEntityList.add(new ClientEntity("Amar Sen  ", 1012, TradeType.SELL, BigDecimal.valueOf(0.30),
				CurrencyType.GBP, LocalDate.of(2018, 10, 13), BigDecimal.valueOf(200), BigDecimal.valueOf(200.25)));

		clientEntityList.add(new ClientEntity("Sachin P  ", 1013, TradeType.BUY, BigDecimal.valueOf(0.34),
				CurrencyType.AED, LocalDate.of(2018, 10, 13), BigDecimal.valueOf(200), BigDecimal.valueOf(500.25)));

		clientEntityList.add(new ClientEntity("Merry Wood ", 1014, TradeType.SELL, BigDecimal.valueOf(0.40),
				CurrencyType.GBP, LocalDate.of(2018, 10, 13), BigDecimal.valueOf(200), BigDecimal.valueOf(440.25)));

		clientEntityList.add(new ClientEntity("Barak O   ", 1015, TradeType.BUY, BigDecimal.valueOf(0.35),
				CurrencyType.AED, LocalDate.of(2018, 10, 13), BigDecimal.valueOf(500), BigDecimal.valueOf(330.25)));

		clientEntityList.add(new ClientEntity("Donald T  ", 1016, TradeType.SELL, BigDecimal.valueOf(0.50),
				CurrencyType.AED, LocalDate.of(2018, 10, 14), BigDecimal.valueOf(500), BigDecimal.valueOf(400.25)));

		clientEntityList.add(new ClientEntity("Sommer Sen ", 1017, TradeType.SELL, BigDecimal.valueOf(0.30),
				CurrencyType.GBP, LocalDate.of(2018, 10, 14), BigDecimal.valueOf(200), BigDecimal.valueOf(200.25)));

		clientEntityList.add(new ClientEntity("Kitty P    ", 1018, TradeType.BUY, BigDecimal.valueOf(0.34),
				CurrencyType.SAR, LocalDate.of(2018, 10, 14), BigDecimal.valueOf(200), BigDecimal.valueOf(500.25)));

		clientEntityList.add(new ClientEntity("Jolly Wood ", 1019, TradeType.SELL, BigDecimal.valueOf(0.40),
				CurrencyType.GBP, LocalDate.of(2018, 10, 14), BigDecimal.valueOf(200), BigDecimal.valueOf(440.25)));

		clientEntityList.add(new ClientEntity("Karen Ottom ", 1020, TradeType.BUY, BigDecimal.valueOf(0.35),
				CurrencyType.AED, LocalDate.of(2018, 10, 14), BigDecimal.valueOf(500), BigDecimal.valueOf(330.25)));

	}

	@Override
	public Optional<ClientEntity> get(long id) {

		return this.clientEntityList.stream().filter(e -> e.getId() == id).findFirst();
	}

	@Override
	public List<ClientEntity> getAll() {

		return clientEntityList;
	}

	@Override
	public void save(ClientEntity clientEntity) {

		if (clientEntity != null) {
			this.clientEntityList.add(clientEntity);
		}

	}

	@Override
	public void update(ClientEntity clientEntity) {
		if (clientEntity != null) {
			this.clientEntityList.add(clientEntity);
		}
	}

	@Override
	public void delete(long id) {

		final Optional<ClientEntity> objectToBeDeleted = this.clientEntityList.stream().filter(e -> e.getId() == id)
				.findFirst();
		if (objectToBeDeleted.isPresent()) {
			this.clientEntityList.remove(objectToBeDeleted.get());
		}
	}

}
