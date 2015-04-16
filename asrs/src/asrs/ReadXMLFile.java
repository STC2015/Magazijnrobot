/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXMLFile {
 
  public static void main(String argv[]) {
 
    try {
 
	File fXmlFile = new File("C:\\Users\\jorian\\Documents\\GitHub\\Magazijnrobot\\asrs\\order.xml");
        // Let hier even op dat je je eigen map hier neer zet
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("klant");
         String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	System.out.println("####################### ");
        System.out.println("PAKLIJST 1/2");
        System.out.println(" #######################");
        System.out.println(newLine);
        System.out.println("Aan: ");
 
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
                        System.out.println("Voornaam: " + eElement.getAttribute("ordernummer"));
			System.out.println("Voornaam: " + eElement.getElementsByTagName("voornaam").item(0).getTextContent());
			System.out.println("Achternaam : " + eElement.getElementsByTagName("achternaam").item(0).getTextContent());
			System.out.println("Adres : " + eElement.getElementsByTagName("adres").item(0).getTextContent());
			System.out.println("Postcode : " + eElement.getElementsByTagName("postcode").item(0).getTextContent());
			System.out.println("Plaats: " + eElement.getElementsByTagName("plaats").item(0).getTextContent());
 
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 
}