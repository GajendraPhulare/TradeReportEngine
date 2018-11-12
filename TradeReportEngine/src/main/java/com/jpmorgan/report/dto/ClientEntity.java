package com.jpmorgan.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.jpmorgan.report.enums.CurrencyType;
import com.jpmorgan.report.enums.TradeType;

public class ClientEntity {

	private String name;
	private long id;
	private TradeType tradetype;
	private BigDecimal agreedFx;
	private CurrencyType currencyType;
	private LocalDate instructiondate;
	private LocalDate settlementDate;
	private BigDecimal units;
	private BigDecimal pricePerUnit;
	private BigDecimal tradeAmount;

	public ClientEntity(String name, long id, TradeType tradetype, BigDecimal agreedFx, CurrencyType currencyType,
			LocalDate instructiondate, BigDecimal units, BigDecimal pricePerUnit) {
		this.name = name;
		this.id = id;
		this.tradetype = tradetype;
		this.agreedFx = agreedFx;
		this.currencyType = currencyType;
		this.instructiondate = instructiondate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TradeType getTradetype() {
		return tradetype;
	}

	public void setTradetype(TradeType tradetype) {
		this.tradetype = tradetype;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public CurrencyType getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(CurrencyType currencyType) {
		this.currencyType = currencyType;
	}

	public LocalDate getInstructiondate() {
		return instructiondate;
	}

	public void setInstructiondate(LocalDate instructiondate) {
		this.instructiondate = instructiondate;
	}

	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}

	public BigDecimal getUnits() {
		return units;
	}

	public void setUnits(BigDecimal units) {
		this.units = units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getTradeAmount() {
		return tradeAmount;
	}

	public void setTradeAmount(BigDecimal tradeAmount) {
		this.tradeAmount = tradeAmount;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.agreedFx).append(this.currencyType).append(this.instructiondate)
				.append(this.name).append(this.pricePerUnit).append(this.tradetype).append(this.units).toHashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ClientEntity other = (ClientEntity) obj;
		return new EqualsBuilder().append(this.name, other.name).append(this.agreedFx, other.agreedFx)
				.append(this.currencyType, other.currencyType).append(this.instructiondate, other.instructiondate)
				.append(this.pricePerUnit, other.pricePerUnit).append(this.tradetype, other.tradetype)
				.append(this.units, other.units).isEquals();
	}

	@Override
	public String toString() {
		return "ClientEntity [name=" + name + ", id=" + id + ", tradetype=" + tradetype + ", agreedFx=" + agreedFx
				+ ", currencyType=" + currencyType + ", instructiondate=" + instructiondate + ", settlementDate="
				+ settlementDate + ", units=" + units + ", pricePerUnit=" + pricePerUnit + ", tradeAmount="
				+ tradeAmount + "]";
	}

}
