package Menus;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import CFG.CFG;

public class MainMenu {
	
public void menu() throws InterruptedException, IOException {
	
	ArrayList<CFG> list = new ArrayList<CFG>();
	list.add(new CFG("S=>aA", 0));
	list.add(new CFG("S=>dD", 1));
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
					
				list.set(index, new CFG(oldValue + "," + arr1[2] , selectedId));
				System.out.println(list);
			}
		}
		zz= true;
		break;
	}
		
	
		
	case "removeRule":{
	//String	strArray = .split(" ");  
		for(CFG cfg : list) {
			int selectedId = Integer.parseInt(arr1[1]);
		
			if(cfg.getId() == selectedId) {
				int index = list.indexOf(cfg);
				String[] azz = cfg.getGrammar().split(",");
				List<String> listAzz = new ArrayList<String>(Arrays.asList(azz));
				listAzz.remove(azz[Integer.parseInt(arr1[2])]);
				
				azz = listAzz.toArray(new String[listAzz.size()]);
				//System.out.println(azz);
				String newGrammar = Arrays.toString(azz)
					    .replace("[", "")
					    .replace("]", "")
					    .trim();
				list.set(index, new CFG(newGrammar, selectedId));
				//System.out.println(newGrammar);
				//System.out.print(list);
			}
		}
		zz = true;
		break;
	}
	case "print":{
		for(CFG cfg : list) {
			int selectedId = Integer.parseInt(arr1[1]);
			if(cfg.getId() == selectedId) {
				String[] azz = cfg.getGrammar().split(",");
				for(int i=0;i<azz.length;i++) {
				System.out.println(i+1 +"." + azz[i]);
				}
			}
		}
		zz= true;
		break;
	}
	case "empty":
		for(CFG cfg : list) {
			int selectedId = Integer.parseInt(arr1[1]);
			if(cfg.getId() == selectedId) {
				if(cfg.getGrammar().isEmpty()) {
					System.out.println("Grammar is empty!");
				}
				else {
					System.out.println("Grammar has rules");
				}
			}
		}
		zz= true;
		break;
	case "chomsky":
		for(CFG cfg : list) {
			int selectedId = Integer.parseInt(arr1[1]);
			if(cfg.getId() == selectedId) {
				if(cfg.getGrammar().contains("R")) {
				System.out.println("Grammar is in CNF");
			}
			else {
				System.out.println("Grammar is not in CNF");
			}
		}
		}
		zz=true;
		break;
	case "union":
			if(arr1.length == 3) {
			int selectedId = Integer.parseInt(arr1[1]);
			int selectedId2 = Integer.parseInt(arr1[2]);
//			list.get(selectedId);
//			list.get(selectedId2);
			String azz = list.get(selectedId).toString() +list.get(selectedId2).toString(); 
			int i;
			for( i =0;i<list.size();i++) {}												
			 list.add(new CFG(azz.replaceAll("CFG", "").replaceAll("id=","").replaceAll("[0-9]", "").replaceAll("0", "").replaceAll("2", "").replaceAll("3", "").replaceAll("4", "").trim().replaceFirst(" ",",").replace(" ", "").trim(),i));
			
		
		}
		zz = true;
		break;
	case "concat":
		if(arr1.length == 3) {
			int selectedId = Integer.parseInt(arr1[1]);
			int selectedId2 = Integer.parseInt(arr1[2]);
			String azz = list.get(selectedId).toString().replaceAll("CFG", "") +list.get(selectedId2).toString().replaceAll("CFG", ""); 
			int i;
			for( i =0;i<list.size();i++) {}												
			 list.add(new CFG(azz.replaceAll("CFG", "").replaceAll("id=","").replaceAll("[0-9]", "").replaceAll("0", "").replaceAll("2", "").replaceAll("3", "").replaceAll("4", "").trim().replaceFirst(" ",",").replace(" ", "").trim(),i));
		}
		zz=true;
		break;
	case "chomskify":{
		if(arr1.length == 2) {
		int selectedId = Integer.parseInt(arr1[1]);
		int i;
//		String oldValue ;
//		String mf = list.get(selectedId).getGrammar();
//		for(CFG cfg : list) {
//			if(cfg.getId() == selectedId) {
		String azz = list.get(selectedId).toString().replaceAll("id=", "").replaceAll("[0-9]", "").replaceAll(" ", "");
		
				if(azz.contains("R")) {
					System.out.println("Grammar is already in CNF");
					
				}
				else {
				
//				char[] ch = cfg.getGrammar().toCharArray();
//				
					for( i=0;i<list.size();i++) {}
//						
//					
//					if(Character.isLowerCase(ch[i]) && ch[i]!='=') {
//						oldValue = cfg.getGrammar().replace(ch[i], 'R');
//						list.set(index, new CFG(oldValue.toString(),selectedId));
//						System.out.println("dd");
//					}
//					else {
//						System.out.println("not lower");
//					}
//						//String mf = list.get(selectedId).getGrammar();
//					}	
				list.add(new CFG(azz.replaceAll("[a-z]", "R").replaceAll("CFG", ""),i));
				}
					
						
					
				
					
				
					
				}
			
		
		
		}
		
		zz=true;
		break;
	case "close" :
		gg = true;
		break;
	case "save":
		if(arr1.length == 3) {
			for(CFG cfg : list) {
				int selectedId = Integer.parseInt(arr1[1]);
				if(cfg.getId() == selectedId) {
				String	fn = arr1[2];
					FileWriter fw=  new FileWriter(fn);
					fw.write(cfg.getGrammar());
					fw.close();
					System.out.println("Grammar successfuly saved in"+ fn);
				}
			}
		}
		if(arr1.length == 1) {
		
		}
		zz=true;
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
