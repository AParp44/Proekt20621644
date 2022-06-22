package CFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CFG {
	static int idCount = 1;
private int id = idCount;
private String grammar;
	

	public CFG(String string,int id) {
		idCount++;
		this.id = id;
		this.grammar = string;
   
	}
	public CFG() {
		
   
	}
	

	public void setId(int id) {
		this.id = id;
	}


	public void setGrammar(String grammar) {
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

	
	 public CFG concat(CFG gr,int id)
	    {
	        String[] arr=this.grammar.split("[,]");
	        String[] arr1=gr.getGrammar().split("[,]");
	        if(arr.length>=arr1.length)
	        {
	            String Gram="";
	            int i=0;
	            int j=0;
	            while(i<arr.length)
	            {
	            String[] arr3=arr[i].split("[=]");    
	            Gram+=arr3[0]+"=>";
	            String[] arr4=arr[i].split("[>]");
	            Gram+=arr4[1];
	                
	                
	                if(j<arr1.length)
	                {
	                    String[] arr5=arr1[j].split("[>]");
	                    Gram+=arr5[1];
	                    j++;
	                }
	                if(i!=arr.length-1)
	                {
	                Gram+=",";
	                }
	                i++;
	            }
	            
	            CFG r=new CFG(Gram, id);
//	            System.out.println(r.toString());
	            return r;
	            
	        }
	        else
	        {
	            StringBuilder sb=new StringBuilder("");
	            int i=0;
	            while(i<arr1.length)
	            {if(arr.length-1>=i)
	            {
	                String[] arr3=arr[i].split("[=]");
	                sb.append(arr3[0]+"=>");
	                arr3=arr[i].split("[>]");
	                sb.append(arr3[1]);
	            }
	            else
	            {
	                String[] arr3=arr1[i].split("[=]");
	                sb.append(arr3[0]+"=>");
	            }
	            String[] arr4=arr1[i].split("[>]");
	            sb.append(arr4[1]+",");
	            
	                i++;
	                }
	            CFG r=new CFG(sb.toString(), id);
	           // System.out.println(r.toString());
	            return r;
	            }
	    }
	 public void addRule(CFG cfg, String[] arr1,int selectedId,int index,ArrayList<CFG>dd ) {
		
				
				String oldValue = cfg.getGrammar();
				if(oldValue.contains("S=>")) {
				dd.set(index, new CFG(oldValue + "," + arr1[2] , selectedId));
				}
				else {
					dd.set(index, new CFG(oldValue + arr1[2] , selectedId));
				}
				//System.out.println(list);
			
	 }
	 public CFG union(int selectedId,int selectedId2,CFG r,int id,ArrayList<CFG>list) {
		 				
		
//				String result="";
//				
//				 String[] azz = list.get(selectedId).toString().concat(list.get(selectedId2).toString()).split(",");
//				 for(int i=0; i<azz.length; i++) {
//						for(int j=i+1; j<azz.length; j++) {
//							if(azz[i].equals(azz[j])) {
//								azz[j] = "remove";
//							}
//						}
//					}
		 		
				String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
				String azz1 = null ;
				Pattern pattern = Pattern.compile(regex);
				if(list.get(selectedId).toString().contains(list.get(selectedId2).toString())) {
					System.out.println("duplicate");
				}
				else {
				 azz1 = list.get(selectedId).toString() +list.get(selectedId2).toString(); 
				}
					
				 r = new CFG(azz1.replaceAll("CFG", "").replaceAll("id=","").replaceAll("[0-9]", "").replaceAll("0", "").replaceAll("2", "").replaceAll("3", "").replaceAll("4", "").trim().replaceFirst(" ",",").replace(" ", "").trim(),list.size());
				return r;
			
		
	 }
	 public void iter(int index,ArrayList<CFG>cfg) {
		 String grammars= this.getGrammar();
		 String newGrammars = grammars.replaceAll("S=>", "");
		 String[] arr = newGrammars.split(",");
		 for(int i=0; i<arr.length; i++) {
			 String a = arr[i];
			 arr[i] ="S=>" + arr[i];
			  for(int j=2; j<=index;j++) {
				 String b = a.repeat(j);
				 arr[i] = arr[i] + ",S=>" + b;
				  
			  }
			  
			 // System.out.print(arr[i]+"\n");
		 }
		 for(int p =0;p<arr.length;p++) {
			 System.out.println(arr[p]);
		 }
		 
		 String newGrammar = Arrays.toString(arr)
				    .replace("[", "")
				    .replace("]", "")
				    .trim();
		 cfg.add(new CFG(newGrammar,cfg.size()));
		 
		 
		
		 
	 }
	 public  void cyk( String s,ArrayList<CFG>list,int selectedId) {
		 
		 String grammars = this.getGrammar();
		 String newGrammars = grammars.replaceAll("S=>|,", "");
		 String[] ff = s.split("");
		 boolean isPresent= true;
		 
		 for(int i=0;i<ff.length;i++) {
			 if(!newGrammars.contains(ff[i])) {
				 isPresent=false;
			 } 
		 }
		 if(isPresent) {
			 System.out.println("word applies to the grammar");
		 }
		 else {
			 System.out.println("word does not apply to the grammar");
		 
		 }
		 
		 }
	 public void empty(int selectedId,CFG cfg) {
		 if(cfg.getId() == selectedId) {
				if(cfg.getGrammar().isEmpty()) {
					System.out.println("Grammar is empty!");
				}
				else {
					System.out.println("Grammar has rules");
				}
	 }
	 }
	 public  void chomskify(ArrayList<CFG>list,int selectedId,boolean zz) {
			String azz = list.get(selectedId).toString().replaceAll("id=", "").replaceAll("[0-9]", "").replaceAll(" ", "");
			boolean prob = true;
			if(azz.contains("R")) {
				System.out.println("Grammar is already in CNF");
				zz=true;
			}
			else {	
				
			list.add(new CFG(azz.replaceAll("[a-z]", "R").replaceAll("CFG", ""),list.size()));
			}
			
	 }
	 public void chomsky(int selectedId,CFG cfg) {
		 if(cfg.getId() == selectedId) {
				if(cfg.getGrammar().contains("R")) {
				System.out.println("Grammar is in CNF");
			}
			else {
				System.out.println("Grammar is not in CNF");
			}
	 }
	 }
	 public void print(int selectedId,CFG cfg) {
		 if(cfg.getId() == selectedId) {
				String[] azz = cfg.getGrammar().split(",");
				for(int i=0;i<azz.length;i++) {
				System.out.println(i+1 +"." + azz[i]);
				}
			}
	 }
	 public void removeRule(int index,ArrayList<CFG>list,CFG cfg,int parsing,int selectedId) {
		 String[] azz = cfg.getGrammar().split(",");
			List<String> listAzz = new ArrayList<String>(Arrays.asList(azz));
			listAzz.remove(azz[parsing]);
			
			azz = listAzz.toArray(new String[listAzz.size()]);
			//System.out.println(azz);
			String newGrammar = Arrays.toString(azz)
				    .replace("[", "")
				    .replace("]", "")
				    .trim();
			list.set(index, new CFG(newGrammar, selectedId));
	 }
	
}
	 
