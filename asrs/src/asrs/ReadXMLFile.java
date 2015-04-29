/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asrs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.xml.sax.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class ReadXMLFile
{

    private int orderNummer;
    private String voornaam, achternaam, adres, postcode, plaats, datum;
    private ArrayList<String> artikelen = new ArrayList<String>();
    private Document xmlDoc;

    public ReadXMLFile(String docString)
    {
        xmlDoc = getDocument(docString);
        orderNummer = Integer.parseInt(getTextValue(xmlDoc.getElementsByTagName("ordernummer").item(0)));
        voornaam = getTextValue(xmlDoc.getElementsByTagName("voornaam").item(0));
        achternaam = getTextValue(xmlDoc.getElementsByTagName("achternaam").item(0));
        adres = getTextValue(xmlDoc.getElementsByTagName("adres").item(0));
        postcode = getTextValue(xmlDoc.getElementsByTagName("postcode").item(0));
        plaats = getTextValue(xmlDoc.getElementsByTagName("plaats").item(0));
        datum = getTextValue(xmlDoc.getElementsByTagName("datum").item(0));
        NodeList artikelnrs = xmlDoc.getElementsByTagName("artikelnr");
        System.out.println(achternaam);
        for (int i = 0; i < artikelnrs.getLength(); i++)
        {
            artikelen.add(getTextValue(artikelnrs.item(i)));
        }
    }

    public String getValue(String tag)
    {
        return getTextValue(xmlDoc.getElementsByTagName(tag).item(0));
    }

    private static Document getDocument(String docString)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);
//            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(new InputSource(docString));
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static String getTextValue(Node node)
    {
        StringBuffer textValue = new StringBuffer();
        int length = node.getChildNodes().getLength();
        for (int i = 0; i < length; i++)
        {
            Node c = node.getChildNodes().item(i);
            if (c.getNodeType() == Node.TEXT_NODE)
            {
                textValue.append(c.getNodeValue());
            }
        }
        return textValue.toString().trim();
    }

    public int getOrderNummer()
    {
        return orderNummer;
    }

    public String getVoornaam()
    {
        return voornaam;
    }

    public String getAchternaam()
    {
        return achternaam;
    }

    public String getAdres()
    {
        return adres;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public String getPlaats()
    {
        return plaats;
    }

    public String getDatum()
    {
        return datum;
    }

    public ArrayList<String> getArtikelen()
    {
        return artikelen;
    }
}
