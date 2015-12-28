package com.dream.java.pattern.dp06_command.undo;

public interface Command {
	public void execute();
	public void undo();
}
