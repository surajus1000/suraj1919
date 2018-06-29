package readFile;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import org.testng.annotations.BeforeSuite;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;


public class ReadXMLFile {
	static Element eElement;
	static Document doc;

	@BeforeSuite(alwaysRun=true)
   public static void readXMLFile() {
	   
       try {
        File fXmlFile = new File("Books.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(fXmlFile); 

        doc.getDocumentElement().normalize(); 
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("book");
        System.out.println("----------------------------");

        for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        eElement = (Element) nNode; 
     
        System.out.println(eElement.getAttribute("id")+" was written by "+eElement.getElementsByTagName("author").item(0).getTextContent());

        }
            }
       }
       catch (Exception e) {
             e.printStackTrace();
            }
         }
     }

