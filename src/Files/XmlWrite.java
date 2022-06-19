package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import CFG.CFG;

public class XmlWrite {
	public void writeXmlFile(ArrayList<CFG> list,String fn) {

	    try {

	        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build = dFact.newDocumentBuilder();
	        Document doc = build.newDocument();
	        
	        Element root = doc.createElement("Grammars");
	        doc.appendChild(root);
//
	      


	        for (CFG dtl : list) {
	        	  Element cfg = doc.createElement("Grammar");
	  	        root.appendChild(cfg);
	        	 Element id = doc.createElement("ID");
		            id.appendChild(doc.createTextNode(String.valueOf(dtl.getId())));
		            cfg.appendChild(id);
		            
	            Element grammar = doc.createElement("Rules");
	            grammar.appendChild(doc.createTextNode(String.valueOf(dtl
	                    .getGrammar())));
	            cfg.appendChild(grammar);
	            
	          

	           

	        }

	        // Save the document to the disk file
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();

	        // format the XML nicely
	        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

	        aTransformer.setOutputProperty(
	                "{http://xml.apache.org/xslt}indent-amount", "4");
	        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        DOMSource source = new DOMSource(doc);
	        try {
	            // location and name of XML file you can change as per need
	            FileWriter fos = new FileWriter(fn);
	            StreamResult result = new StreamResult(fos);
	            aTransformer.transform(source, result);

	        } catch (IOException e) {

	            e.printStackTrace();
	        }

	    } catch (TransformerException ex) {
	        System.out.println("Error outputting document");

	    } catch (ParserConfigurationException ex) {
	        System.out.println("Error building document");
	    }
	}

	public void writeXmlFile2(CFG grammar, String fn,ArrayList<CFG> list) {
		// TODO Auto-generated method stub
		
		 try {

		        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
		        DocumentBuilder build = dFact.newDocumentBuilder();
		        Document doc = build.newDocument();
		        
		        Element root = doc.createElement("Grammars");
		        doc.appendChild(root);
	//
		      


		       
		        	  Element cfg = doc.createElement("Grammar");
		  	        root.appendChild(cfg);
		        	 Element id = doc.createElement("ID");
			            id.appendChild(doc.createTextNode(String.valueOf(grammar.getId())));
			            cfg.appendChild(id);
			            
		            Element grammars = doc.createElement("Rules");
		            grammars.appendChild(doc.createTextNode(String.valueOf(grammar
		                    .getGrammar())));
		            cfg.appendChild(grammars);
		            
		          

		           

		        

		        // Save the document to the disk file
		        TransformerFactory tranFactory = TransformerFactory.newInstance();
		        Transformer aTransformer = tranFactory.newTransformer();

		        // format the XML nicely
		        aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

		        aTransformer.setOutputProperty(
		                "{http://xml.apache.org/xslt}indent-amount", "4");
		        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

		        DOMSource source = new DOMSource(doc);
		        try {
		            // location and name of XML file you can change as per need
		            FileWriter fos = new FileWriter(fn);
		            StreamResult result = new StreamResult(fos);
		            aTransformer.transform(source, result);

		        } catch (IOException e) {

		            e.printStackTrace();
		        }

		    } catch (TransformerException ex) {
		        System.out.println("Error outputting document");

		    } catch (ParserConfigurationException ex) {
		        System.out.println("Error building document");
		    }
		}
}
