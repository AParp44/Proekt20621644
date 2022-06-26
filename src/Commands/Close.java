package Commands;

import CFG.Grammars;
import commandLine.Command;

public class Close implements Command{

	@Override
	public void execute(String[] args) {
		  Grammars.getInstance().close();
	      System.out.println("Input open <file> below");
		
	}

}
