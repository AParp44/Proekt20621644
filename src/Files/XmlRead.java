package Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import CFG.CFG;

public class XmlRead {
	public XmlRead() {
		
	}
public ArrayList<CFG> getGrammar(File f) throws ParserConfigurationException, SAXException, IOException {
	ArrayList<CFG> list = new ArrayList<CFG>();
	File xml= f;
    if(xml.canExecute()) {
    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
    DocumentBuilder db=dbf.newDocumentBuilder();
    Document d=db.parse(xml);
    NodeList nList=d.getElementsByTagName("Grammar");
for(int i=0;i<nList.getLength();i++)
{
        Node nNode=nList.item(i);
        if(nNode.getNodeType()==Node.ELEMENT_NODE)
        {
        	
            Element e=(Element)nNode;
            
            int id = Integer.parseInt( e.getElementsByTagName("ID").item(0).getTextContent());
            CFG c = new CFG(e.getElementsByTagName("Rules").item(0).getTextContent(),id);
            list.add(c);
            
            }
        
}
}
	return list;
}
}
