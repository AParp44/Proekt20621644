package CFG;

import java.util.ArrayList;

public class CFG {
	static int idCount = 1;
private int id = idCount;
private String grammar;
	

	public CFG(String grammar,int id) {
		idCount++;
		this.id = id;
		this.grammar = grammar;
   
	}


	public int getId() {
		return id;
	}


	public String getGrammar() {
		return grammar;
	}


	@Override
	public String toString() {
		return "CFG id=" + id + " " + grammar;
	}

	
	
}
