package Commands;

import java.util.ArrayList;

import commandLine.Command;
import CFG.*;

public class Chomsky implements Command {
	

	@Override
	public void execute(String[] args) {
	if(!(Grammars.getGrammarInstance() == null))	{
	    CFGHelper.chomsky(Grammars.getInstance().getList(), args);
	}
	else {
		System.out.println("Open file first!");
		}
	}
}
