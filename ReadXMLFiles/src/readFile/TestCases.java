package readFile;



import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestCases {
	static Document doc;
	File fXmlFile = new File("Books.xml");
     
@BeforeTest
public void initialize() throws SAXException, IOException, ParserConfigurationException{
	 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	     doc = dBuilder.parse(fXmlFile); 
	     doc.getDocumentElement().normalize(); 
}
	
@Test
public void testCaseToValidateNodeName() {

	 assertEquals("catalog", doc.getDocumentElement().getNodeName());
}

@Test
public void testCaseToValidationAuthorName() {
 
     NodeList nList = doc.getElementsByTagName("book");
     String name ="Gambardella, Matthew";
   assertEquals(name, ((Element) nList.item(0)).getElementsByTagName("author").item(0).getTextContent());  ;
     
}

@Test
public void testCaseToValidatePrice() {
	
     NodeList nList = doc.getElementsByTagName("book");
     
   assertEquals(44, ((Element) nList.item(0)).getElementsByTagName("price").item(0).getTextContent());  ;
     
}

}
