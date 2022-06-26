package Commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.*;
import commandLine.Command;

public class Union implements Command {

	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		if(!(Grammars.getGrammarInstance() == null)) {
			CFGHelper.union(Grammars.getInstance().getList(), args);
			}
			else {
				System.out.println("Open file first!");
				}
	}
	
}
