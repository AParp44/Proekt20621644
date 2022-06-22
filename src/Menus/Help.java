package Menus;

public class Help {
public static void print(){
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
}
