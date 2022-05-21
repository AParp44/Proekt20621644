package Menus;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainMenu {
	private final String FN = "BRATISLAVA";
public void menu() throws InterruptedException {
	System.out.println("Input help down below for instructions!");
	String fn = "neshto";
	
	Scanner input  = new Scanner(System.in);
	
	while(true) {
		System.out.print("> ");
		String s = input.nextLine();
		
	switch(s) {
	case "help":{
		printMenu();
		break;
	}
		
	case "open " +FN :
		System.out.println("dd");
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
