package Commands;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.CFGHelper;
import CFG.Grammars;
import commandLine.Command;
import io.IOHelper;

public class Save implements Command {
	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		if(!(Grammars.getGrammarInstance() == null)){
			if(args.length == 2 ) {
		    CFGHelper.save(Grammars.getInstance().getList(), args);
			}
			else if (args.length == 0){
			 IOHelper.save(Grammars.getInstance().getList(), args);
			}
			else {
				System.out.println("w");
			}
		}
		else {
			System.out.println("Open file first!");
			}
		}
}
