package XMLProcess;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;  
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;  
import org.w3c.dom.Element;  



public class ProcesareDisciplina {

    private static final String FILENAME = "D:\\JAVA\\Evidenta Studenti\\Evidenta_Studenti\\src\\XMLProcess\\student.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
    	
    	File inputFile = new File(FILENAME); // input file  
 
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
        DocumentBuilder db = dbf.newDocumentBuilder();  
        Document d = db.parse(inputFile);  
        d.getDocumentElement().normalize();  
        
        System.out.println("Root element :" + d.getDocumentElement().getNodeName());  
        NodeList nl = d.getElementsByTagName("student");  
        System.out.println("----------------------------");  
        // printing the components of the file  
        for (int i = 0; i<nl.getLength(); i++) {  
                    Node n = nl.item(i);  
                    System.out.println("\nCurrent Element :" + n.getNodeName());  
                    if (n.getNodeType() == Node.ELEMENT_NODE) {  
                        // Extracting the root elements  
                                   Element e = (Element) n;  
                        // Analysing the attributes  
                                   System.out.println("Student roll no : "  + e.getAttribute("rollno"));  
                                   System.out.println("First Name : " + e.getElementsByTagName("firstname").item(0) .getTextContent());  
                                   System.out.println("Last Name : " + e.getElementsByTagName("lastname") .item(0) .getTextContent());  
                                   System.out.println("Nick Name : "  + e  
                                      .getElementsByTagName("nickname")  
                                      .item(0)  
                                      .getTextContent());  
                                   System.out.println("Marks : "  + e  
                                      .getElementsByTagName("marks")  
                                      .item(0)  
                                      .getTextContent()); 
                    
                    
                   }//end if 

         }//end for
    
      }//end main
    
}