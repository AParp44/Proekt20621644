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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import CFG.CFG;
import Files.XmlRead;
import Files.XmlWrite;

public class MainMenu {
	public void menu()	throws InterruptedException, IOException, XMLStreamException, ParserConfigurationException, SAXException {
		ArrayList<CFG> list = new ArrayList<CFG>();
//	list.add(new CFG("S=>aA", list.size())); // za proverka
//	list.add(new CFG("S=>dD", list.size()));
//	list.add(new CFG("S=>fF,S=>mM,S=>zZ", list.size()));
//	list.add(new CFG("S=>mM", list.size()));
		System.out.print("Welcome ");
		System.out.println(System.getProperty("user.name"));
		Scanner input = new Scanner(System.in);
		boolean ff = true;
		boolean gg = true;
		boolean zz = true;
		boolean kk = false;
		while (ff) {
			while (gg) {
				System.out.println("Input open <fileName> down below!");
				String s;
				System.out.print("> ");
				s = input.nextLine();
				String arr[] = s.split("[ ]");
				if (!arr[1].isEmpty()) {
					String fn = arr[1];
					File mn = new File(fn);
					mn.createNewFile();
					if (mn.length() != 0) {
						XmlRead xmlR = new XmlRead();
						list = xmlR.getGrammar(mn);
					}
					System.out.println("Successfully opened " + mn.getPath());
					System.out
							.println("You can now use other commands! If you want to check them out input help below!");
					gg = false;
				}
				while (zz) {
					while (kk) {
						if (!arr[1].isEmpty()) {
							System.out.println("Input open <fileName> down below!");
							System.out.print("> ");
							s = input.nextLine();
							arr = s.split("[ ]");

							String fn = arr[1];
							File mn = new File(fn);
							mn.createNewFile();
							if (mn.length() != 0) {
								XmlRead xmlR = new XmlRead();
								list = xmlR.getGrammar(mn);
							} else {
								list = null;
							}
							System.out.println("Successfully opened " + mn.getPath());
							System.out.println(
									"You can now use other commands! If you want to check them out input help below!");
						}
						kk = false;
						zz = true;
					}
					System.out.print("> ");
					String ss = input.nextLine();
					String arr1[] = ss.split("[ ]");
					zz = false;
					switch (arr1[0]) {
					case "help": {
						if(arr1.length==1) {
						Help.print();
						}
						else {
							System.out.println("The command is help");
						}
						zz = true;
						break;
					}
					case "list": 
						
						if (list == null) {
							System.out.println("file is empty");
						} 
						else {
							for (int i = 0; i < list.size(); i++) {
								System.out.println(list.get(i));

							}
						}
						
	
						zz = true;
						break;
					
					case "addRule": {
						if(arr1.length == 3) {
						for (CFG cfg : list) {
							int selectedId = Integer.parseInt(arr1[1]);
							if (cfg.getId() == selectedId) {
								int index = list.indexOf(cfg);
								cfg.addRule(cfg, arr1, selectedId, index, list);
								System.out.println("Successfully added new rule!");
							}

						}
						}
						else {
							System.out.println("The command is addRule <id> <rule>");
						}
						zz = true;
						break;
					}
					case "removeRule": {
						if(arr1.length == 3) {
						int parsing = Integer.parseInt(arr1[2]);
						for (CFG cfg : list) {
							int selectedId = Integer.parseInt(arr1[1]);
							if (cfg.getId() == selectedId) {
								int index = list.indexOf(cfg);
								cfg.removeRule(index, list, cfg, parsing, selectedId);
								System.out.println("Successfully removed rule!");
							}
						}
						}
						else {
							System.out.println("The command is removeRule <id> <index>");
						}
						zz = true;
						break;
					}
					case "print": {
						if(arr1.length == 2)
						for (CFG cfg : list) {
							int selectedId = Integer.parseInt(arr1[1]);
							cfg.print(selectedId, cfg);
						}
						else {
							System.out.println("The command is print <id>");
						}
						zz = true;
						break;
					}
					case "empty": {
						if(arr1.length == 2) {
						for (CFG cfg : list) {
							int selectedId = Integer.parseInt(arr1[1]);
							cfg.empty(selectedId, cfg);
						}
						}
						else {
							System.out.println("The command is empty <id>");
						}
					}
						zz = true;
						break;
					case "chomsky":
						if(arr1.length==2) {
						for (CFG cfg : list) {
							int selectedId = Integer.parseInt(arr1[1]);
							cfg.chomsky(selectedId, cfg);
						}
						}
						else {
							System.out.println("The command is chomsky <id>");
						}
						zz = true;
						break;
					case "union": {
						if (arr1.length == 3) {
							int selectedId = Integer.parseInt(arr1[1]);
							int selectedId2 = Integer.parseInt(arr1[2]);
							CFG gr1 = null;
							CFG gr2 = null;
							for (CFG cfg : list) {
								if (cfg.getId() == selectedId) {
									gr1 = cfg;
								}
								if (cfg.getId() == selectedId2) {
									gr2 = cfg;
								}
							}
							if (gr1 != null) {
								if (gr1.getGrammar().contains(gr2.getGrammar())) {
									System.out.println("Cannot have duplicate rules!");
									zz = true;
								}else if(gr2.getGrammar().contains(gr1.getGrammar())) {
									System.out.println("Cannot have duplicate rules!");
								}
								else {
									list.add(gr1.union(selectedId, selectedId2, gr2, list.size(), list));
									System.out.println("Successfully united grammars "+selectedId+" and "+selectedId2+",new grammar ID:"+(list.size()-1));
								}

							} else {
								System.out.println("Grammar is not initialized");
							}
						}else {
							System.out.println("The command is union <id1> <id2>");
							zz = true;
						}
					}
						zz = true;
						break;
					case "concat": {
						if (arr1.length == 3) {
							int id1 = Integer.parseInt(arr1[1]);
							int id2 = Integer.parseInt(arr1[2]);
							CFG gr1 = null;
							CFG gr2 = null;
							for (CFG cfg : list) {
								if (cfg.getId() == id1) {
									gr1 = cfg;
								}
								if (cfg.getId() == id2) {
									gr2 = cfg;
								}
							}
							if (gr1 != null) {
								list.add(gr1.concat(gr2, list.size()));
								System.out.println("Successfully concatenated grammars "+id1+" and "+id2+",new grammar ID:"+(list.size()-1));

							} else {
								System.out.println("Grammar is not initialized");
							}
						}
						else {
							System.out.println("The command is concat <id1> <id2>");
							zz = true;
						}
					}
						zz = true;
						break;
					case "chomskify": {
						
						
						if (arr1.length == 2) {
							int selectedId = Integer.parseInt(arr1[1]);
							CFG gr1 = null;
							for (CFG cfg : list) {
								if (cfg.getId() == selectedId) {
									gr1 = cfg;
								}
							}
							if (gr1 != null) {
								gr1.chomskify(list, selectedId, zz);
								if(!gr1.getGrammar().contains("R")) {
								System.out.println("Successfully chomskified grammar "+selectedId+",new grammar ID:"+(list.size()-1));
								}

							} else {
								System.out.println("Grammar is not initialized");
							}
						}
						if(arr1.length !=2) {
							System.out.println("The command is chomskify <id>");
							
						}
					}

						zz = true;
						break;
					case "cyk": {
						if (arr1.length == 3) {
							CFG gr1 = null;
							String word = arr1[2];
							int selectedId = Integer.parseInt(arr1[1]);
							for (CFG cfg : list) {
								if (cfg.getId() == selectedId) {
									gr1 = cfg;
								}
							}
							if (gr1 != null) {
								gr1.cyk(word, list, selectedId);
								

							} else {
								System.out.println("Grammar is not initialized");
							}
						}
						else {
							System.out.println("The command is cyk <id>");
						}

					}
						zz = true;
						break;
					case "iter": {
						if (arr1.length == 2) {
							CFG gr1 = null;
							int number = 3;
							int selectedId = Integer.parseInt(arr1[1]);
							for (CFG cfg : list) {
								if (cfg.getId() == selectedId) {
									gr1 = cfg;

								}
							}
							if (gr1 != null) {
								gr1.iter(number, list);
								System.out.println("Successfully iterated!");

							} else {
								System.out.println("Grammar is not initialized");
							}
						}
						else {
							System.out.println("The command is iter <id>");
							zz = true;
						}
					}
						zz = true;
						break;

					case "close":
						if (arr1.length == 1) {
							String fn = arr[1];
							System.out.println("Successfully closed " + fn);
							zz = true;
							kk = true;
						}
						else {
							System.out.println("The command is close");
							zz = true;
						}

						

						break;
					case "save":
						if (arr1.length == 3) {
							for (CFG cfg : list) {
								int selectedId = Integer.parseInt(arr1[1]);
								if (cfg.getId() == selectedId) {
									String fn = arr1[2];
									XmlWrite xwrite = new XmlWrite();
									xwrite.writeXmlFile2(cfg, fn, list);
									System.out.println("Grammar successfuly saved in " + fn);
								}
							}

						}
						if (arr1.length == 1) {
							String fn = arr[1];
							XmlWrite xwrite = new XmlWrite();
							xwrite.writeXmlFile(list, fn);
							System.out.println("Successfully saved " + fn);
						}
						if(arr1.length!=1 && arr1.length!=3) {
							System.out.println("save or save <id> <file>");
						}
						zz = true;
						break;
					case "saveas":
						if (arr1.length == 2) {
							String fn = arr1[1];
							XmlWrite xwrite = new XmlWrite();
							xwrite.writeXmlFile(list, fn);
							System.out.println("Successfuly saved another " + fn);
						}
						else {
							System.out.println("saveas <file>");
							zz = true;
						}
						zz = true;
						break;
					case "exit":
						if(arr1.length== 1) {
						System.out.println("Exiting the program...");
						ff = false;
						}
						else {
							System.out.println("The command is exit");
							zz=true;
						}
						break;
					default:
						System.out.println("Please check your input!");
						zz = true;
					}
				}
			}
		}
	}
}