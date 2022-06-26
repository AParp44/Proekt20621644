package Commands;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import CFG.CFGHelper;
import CFG.Grammars;
import commandLine.Command;
import io.IOHelper;

public class SaveAs implements Command {
	@Override
	public void execute(String[] args) throws IOException, ParserConfigurationException, SAXException {
		if(!(Grammars.getGrammarInstance() == null)){
			 if (args.length == 1){
			 IOHelper.saveas(Grammars.getInstance().getList(), args);
			}
		}
		else {
			System.out.println("Open file first!");
			}
		}
}
