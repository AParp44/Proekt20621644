package Commands;

import CFG.Grammars;
import commandLine.Command;

public class Helper implements Command {

    @Override
    public void execute(String[] args) {
    	if(!(Grammars.getGrammarInstance() == null)) {
        if(args.length==0){
            printAll();
        } else{
            printCommandHelp((String)args[0]);
        }
    	}
    	else {
    		System.out.println("Open file first!");
    	}
    }

    private void printAll(){
    	String blank = "             ";
    	System.out.println("The following commands are supported:");
    	System.out.println("open <file> opens <file>");
    	System.out.println("close" + blank + "closes currently opened file");
    	System.out.println("save" + blank + " saves the currently open file");
    	blank = "     ";
    	System.out.println("saveas <file>" + blank + "saves the currently open file in <file>");
    	blank = "             ";
    	System.out.println("help" + blank + " prints this information ");
    	System.out.println("exit" + blank + " exits the program ");
    }

    private void printCommandHelp(String commandName){
    	System.out.println("The command is "+commandName);
    }
    
}
