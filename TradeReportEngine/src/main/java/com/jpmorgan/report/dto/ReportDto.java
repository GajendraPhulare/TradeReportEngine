package com.jpmorgan.report.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ReportDto {
	private LocalDate instructionDate;
	private BigDecimal totalIncomingAmount;
	private BigDecimal totalOutGoingAmount;
	private List<ClientEntity> incomingClientList;
	private List<ClientEntity> outgoingClientList;

	public ReportDto(LocalDate instructionDate, BigDecimal totalIncomingAmount, BigDecimal totalOutGoingAmount,
			List<ClientEntity> incomingClientList, List<ClientEntity> outgoinggClientList) {
		super();
		this.instructionDate = instructionDate;
		this.totalIncomingAmount = totalIncomingAmount;
		this.totalOutGoingAmount = totalOutGoingAmount;
		this.incomingClientList = incomingClientList;
		this.outgoingClientList = outgoinggClientList;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public BigDecimal getTotalIncomingAmount() {
		return totalIncomingAmount;
	}

	public void setTotalIncomingAmount(BigDecimal totalIncomingAmount) {
		this.totalIncomingAmount = totalIncomingAmount;
	}

	public BigDecimal getTotalOutGoingAmount() {
		return totalOutGoingAmount;
	}

	public void setTotalOutGoingAmount(BigDecimal totalOutGoingAmount) {
		this.totalOutGoingAmount = totalOutGoingAmount;
	}

	public List<ClientEntity> getIncomingClientList() {
		return incomingClientList;
	}

	public void setIncomingClientList(List<ClientEntity> incomingClientList) {
		this.incomingClientList = incomingClientList;
	}

	public List<ClientEntity> getOutgoinggClientList() {
		return outgoingClientList;
	}

	public void setOutgoingClientList(List<ClientEntity> outgoinggClientList) {
		this.outgoingClientList = outgoinggClientList;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.instructionDate).append(this.totalIncomingAmount)
				.append(this.totalOutGoingAmount).append(this.incomingClientList).append(this.outgoingClientList)
				.toHashCode();

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ReportDto other = (ReportDto) obj;
		return new EqualsBuilder().append(this.instructionDate, other.instructionDate)
				.append(this.totalIncomingAmount, other.totalIncomingAmount)
				.append(this.totalOutGoingAmount, other.totalOutGoingAmount)
				.append(this.incomingClientList, other.incomingClientList)
				.append(this.outgoingClientList, other.outgoingClientList).isEquals();
	}

	@Override
	public String toString() {
		return "ReportItem [instructionDate=" + instructionDate + ", totalIncomingAmount=" + totalIncomingAmount
				+ ", totalOutGoingAmount=" + totalOutGoingAmount + ", incomingClientList=" + incomingClientList
				+ ", outgoingClientList=" + outgoingClientList + "]";
	}
}
