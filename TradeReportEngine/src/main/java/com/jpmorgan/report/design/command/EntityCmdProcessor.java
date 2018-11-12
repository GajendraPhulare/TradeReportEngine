package com.jpmorgan.report.design.command;

import java.util.List;

public interface EntityCmdProcessor<T> {

	public List<T> process();

	public void addCommand(Command<T> command);
}
