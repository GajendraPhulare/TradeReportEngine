package com.jpmorgan.report.design.command;

import java.util.List;

public interface Command<T> {

	List<T> execute(List<T> list);
}
