package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import CFG.CFG;
import Files.XmlRead;
import Menus.MainMenu;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException, ParserConfigurationException, SAXException, XMLStreamException  {
		MainMenu menu = new MainMenu();
		menu.menu();
	
		

		
	}

}