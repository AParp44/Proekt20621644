package Commands;

import java.util.ArrayList;

import CFG.CFG;
import CFG.Grammars;
import CFG.CFGHelper;

import commandLine.Command;

public class AddRule implements Command {

	@Override
	public void execute(String[] args) {
		if(!(Grammars.getGrammarInstance() == null)) {
		if(args.length == 2) {
		CFGHelper.addRule(Grammars.getInstance().getList(), args);
		}
		}
		else {
			System.out.println("Open file first!");
		}
		
	}
	public void validate(String[] args) {
		if(args.length==0){
            System.out.println("[EMPTY]");
        }else
            for(int i=0; i<args.length;i++){
                System.out.format("[%d]\t"+args[i]+"\n",i);
            }
	}
}
