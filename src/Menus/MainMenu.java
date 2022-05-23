package Menus;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainMenu {
	
public void menu() throws InterruptedException, IOException {
	//System.out.println("Input help down below for instructions!");
	
	System.out.print("Welcome ");
	System.out.println( System.getProperty("user.name") );
	System.out.println("Input open <fileName> down below!");
	Scanner input  = new Scanner(System.in);
	System.out.print("> ");
	String s = input.nextLine();
	String arr[]=s.split("[ ]");
	
	System.out.println("dd");
	String fn = arr[1];
	
	
	
	File mn = new File(fn);
	mn.createNewFile();
	try(FileReader fileReader = new FileReader(fn)) {
	    int ch = fileReader.read();
	    
	        
	        fileReader.close();
	    
	} catch (FileNotFoundException e) {
	    // Exception handling
	} catch (IOException e) {
	    // Exception handling
	}
	boolean ff = true;
	while(ff) {
	System.out.print("> ");
	String ss  = input.nextLine();
	String arr1[]=ss.split("[ ]");	
	switch(arr1[0]) {
	case "help":{
		printMenu();
		break;
	}
		
	
		
		
	case "close" :
		  //fileReader.close();
		break;
	case "exit":
		System.out.println("Exiting the program...");
		ff = false;
		break;
	}
	
	}
	
	
	
	

	

	
	
}
public void printMenu() throws InterruptedException  {
	String blank ="             ";
//	System.out.print("Welcome ");
//	System.out.println( System.getProperty("user.name") );
//	TimeUnit.SECONDS.sleep(3);
	System.out.println("The following commands are supported:");
	System.out.println("open <file> opens <file>");
	System.out.println("close" +blank +"closes currently opened file");
	System.out.println("save"+blank+" saves the currently open file");
	blank ="     ";
    System.out.println("saveas <file>"+blank+"saves the currently open file in <file>");
    blank ="             ";
    System.out.println("help"+blank+" prints this information ");
    System.out.println("exit"+blank+" exists the program ");

}
}
