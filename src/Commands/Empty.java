package Commands;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.*;
import commandLine.Command;

public class Empty implements Command{

	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		if(!(Grammars.getGrammarInstance() == null))	{
		    CFGHelper.empty(Grammars.getInstance().getList(), args);
		}
		else {
			System.out.println("Open file first!");
			}
		}
		
	}


