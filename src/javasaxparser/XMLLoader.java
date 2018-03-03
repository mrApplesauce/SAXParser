/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparser;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author taylor
 */
public class XMLLoader {
    
    public static ArrayList<XMLElement> load(File xmlFile) throws Exception {
        ArrayList<XMLElement> dom = new ArrayList<XMLElement>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                
                XMLElement element = null;
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {    
                    int len = attributes.getLength();
                    if (len != 0) {
                        element = new XMLElement();
                        element.setQName(qName);
                    }
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (element.getQName().equalsIgnoreCase(qName)) {
                        dom.add(element);
                    }
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (element != null) {
                        String str = new String(ch, start, length);
                        if (str != null && !str.isEmpty())
                            element.addAttribute(str.trim());
                    }
                }
                
            };
            
            saxParser.parse(xmlFile.getAbsoluteFile(), handler);
                    
        } catch (Exception ex) {
            throw ex;
        }
        
        return dom;
    }
    
}
