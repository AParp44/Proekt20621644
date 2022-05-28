package Menus;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import CFG.CFG;

public class MainMenu {
	
public void menu() throws InterruptedException, IOException {
	
	ArrayList<CFG> list = new ArrayList<CFG>();
	list.add(new CFG("S=> aA ", 0));
	list.add(new CFG("S=> bB ", 1));
	System.out.print("Welcome ");
	System.out.println( System.getProperty("user.name") );
	
	
	
	boolean ff = true;
	boolean gg = true;
	boolean zz=  true;
	while(ff) {
	while(gg) {
		System.out.println("Input open <fileName> down below!");
		Scanner input  = new Scanner(System.in);
		String s;
		
		System.out.print("> ");
		
		 s = input.nextLine();
		
		String arr[]=s.split("[ ]");
		if(!arr[1].isEmpty()) {
			
		String fn = arr[1];
		
		
		
		File mn = new File(fn);
		System.out.println("Successfully opened " + mn.getPath());
		System.out.println("You can now use other commands! If you want to check them out input help below!");

		mn.createNewFile();
		try(FileReader fileReader = new FileReader(fn)) {
		    int ch = fileReader.read();
		    
		        
		        fileReader.close();
		    
		} catch (FileNotFoundException e) {
			
			
		} catch (IOException e) {
			
		}
		gg = false;
	}
		while(zz) {
	System.out.print("> ");
	String ss  = input.nextLine();
	String arr1[]=ss.split("[ ]");	
	zz= false;
	switch(arr1[0]) {
	case "help":{
		printMenu();
		zz= true;
		break;
	}
	case "list" :{
		for(int i =0;i<list.size();i++) {
			System.out.println(list.get(i));
			
			}
        zz = true;
		break;
	}
	case "addRule" :{
		for(CFG cfg : list) {
			int selectedId = Integer.parseInt(arr1[1]);
			if(cfg.getId() == selectedId) {
				int index = list.indexOf(cfg);
				String oldValue = cfg.getGrammar();
				list.set(index, new CFG(oldValue.concat(arr1[2]),selectedId));
				System.out.println(list);
			}
		}
		zz= true;
		break;
	}
		
	
		
		
	case "close" :
		gg = true;
		break;
//		break;
		//todo
	case "save":
		//todo
		break;
	case "saveas":
		//todo
		break;
	case "exit":
		System.out.println("Exiting the program...");
		ff = false;
		break;
	default:
		System.out.println("Please input file name");
	}
		}
	}
	
	}
	
	
	
	
	
	

	

	
	
}
public void printMenu() throws InterruptedException  {
	String blank ="             ";
	System.out.println("The following commands are supported:");
	System.out.println("open <file> opens <file>");
	System.out.println("close" +blank +"closes currently opened file");
	System.out.println("save"+blank+" saves the currently open file");
	blank ="     ";
    System.out.println("saveas <file>"+blank+"saves the currently open file in <file>");
    blank ="             ";
    System.out.println("help"+blank+" prints this information ");
    System.out.println("exit"+blank+" exits the program ");

}

}
