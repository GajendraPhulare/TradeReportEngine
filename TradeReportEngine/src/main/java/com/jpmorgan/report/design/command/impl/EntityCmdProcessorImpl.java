package com.jpmorgan.report.design.command.impl;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.report.design.command.Command;
import com.jpmorgan.report.design.command.EntityCmdProcessor;
import com.jpmorgan.report.dto.ClientEntity;

public class EntityCmdProcessorImpl implements EntityCmdProcessor<ClientEntity> {

	List<ClientEntity> clientEntityList;
	List<Command<ClientEntity>> commandList = new ArrayList();

	public EntityCmdProcessorImpl(List<ClientEntity> clientEntityList) {

		this.clientEntityList = clientEntityList;
	}

	public List<ClientEntity> getClientEntityList() {
		return clientEntityList;
	}

	public void setClientEntityList(List<ClientEntity> clientEntityList) {
		this.clientEntityList = clientEntityList;
	}

	public List<Command<ClientEntity>> getCommandList() {
		return commandList;
	}

	public void setCommandList(List<Command<ClientEntity>> commandList) {
		this.commandList = commandList;
	}

	@Override
	public List<ClientEntity> process() {

		if (commandList != null && !commandList.isEmpty()) {
			for (final Command<ClientEntity> cmd : commandList) {
				this.clientEntityList = cmd.execute(this.clientEntityList);
			}
		}
		return this.clientEntityList;
	}

	@Override
	public void addCommand(Command command) {
		this.commandList.add(command);
	}

}
