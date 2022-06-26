package Commands;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.Grammars;
import commandLine.Command;

public class Open implements Command{

	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		if(Grammars.getGrammarInstance() == null) {
		 Grammars.getInstance().open(args);
		}
		else {
			System.out.println("already opened");
		}
	    }
	}


