package Files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import CFG.CFG;  
public class XmlReads {
	public static CFG readGrammar(File mn,int idSel,ArrayList<CFG>grammar,CFG p) throws XMLStreamException, FileNotFoundException{
		 
	   
	    XMLInputFactory inputFactory = XMLInputFactory.newFactory();
	    
	    
	        //create a stream reader object
	        FileReader fileReader = new FileReader(mn);
	        XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
	        //read XML file
	        while (reader.hasNext())
	        {
	          int eventType = reader.getEventType();
	          switch (eventType)
	          {
	               case  XMLStreamConstants.START_ELEMENT :
	                  String elementName = reader.getLocalName();
	                  //get the product and its code
	                  if (elementName.equals("Grammars"))
	                  {
	                   
	                    
	                     p = new CFG();
	                  }   
	                  // get the product description
	                  
	                  if (elementName.equals("ID"))
	                  {
	                	 
	                     String id = reader.getElementText();
	                     int ids = Integer.parseInt(id);
	                     p.setId(ids);
	                     
	                  }   
	                  if (elementName.equals("Grammar"))
	                  {
	                	
	                     String grammars = reader.getElementText();
	                     p.setGrammar(grammars);
	                    
	                  }    
	                  // get the product price
	                  
	                  break;
	               case XMLStreamConstants.END_ELEMENT :
	                  elementName = reader.getLocalName();
	                  if(elementName.equals("Grammars"))
	                  {
	                    grammar.add(p);  
	                  }    
	                  break; 
	              }
	         reader.next();
	        }    
	    
	   
	    
	      
	     
	     return p;
	
		
	}
}
