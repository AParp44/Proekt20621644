package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import CFG.CFG;
import Menus.MainMenu;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException  {
		MainMenu menu = new MainMenu();
		menu.menu();
//		ArrayList<CFG> list = new ArrayList<CFG>();
//		list.add(new CFG("S=> aA", 0));
//		list.add(new CFG("S=> bB", 1));
//Scanner input = new Scanner(System.in);
//String bb = input.nextLine();
//String arr[]=bb.split("[ ]");
//
////list.add(new CFG(arr[1],0));
////list.indexOf(arr[0]);
//
//for(CFG cfg : list) {
//	int selectedId = Integer.parseInt(arr[0]);
//	if(cfg.getId() == selectedId) {
//		int index = list.indexOf(cfg);
//		String oldValue = cfg.getGrammar();
//		list.set(index, new CFG(oldValue.concat(arr[1]),selectedId));
//		System.out.println(list);
//	}
//}


//for(int i =0;i<list.size();i++) {
//System.out.println(list.get(i));
//}









//CFG cfg = new CFG("S=> aA ");
//CFG cfg2 = new CFG("S=> bB ");
//CFG cfg3 = new CFG("S=> cC ");
//System.out.println(cfg.toString());
//System.out.println(cfg2.toString());
//System.out.println(cfg3.toString());

		
	}

}
