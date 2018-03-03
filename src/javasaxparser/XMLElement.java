/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasaxparser;

import java.util.ArrayList;

/**
 *
 * @author taylor
 */
public class XMLElement {
    
    private ArrayList<String> attributes;
    private String qName;
    
    public XMLElement() {
        attributes = new ArrayList<>();
    }
    
    public void setQName(String qName) {
        this.qName = qName;
    }
    
    public String getQName() {
        return qName;
    }
    
    public ArrayList<String> getAttributes() {
        return attributes;
    }
    
    public void addAttribute(String attribute) {
        attributes.add(attribute);
    }
    
}
