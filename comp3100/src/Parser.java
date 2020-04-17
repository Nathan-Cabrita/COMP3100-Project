import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Config.*;

public class Parser {

    Document document;
    ArrayList<Server> servers;

    public Parser(String path){
        //Constructs document
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            FileInputStream fis = new FileInputStream(path);
            InputSource is = new InputSource(fis);
            this.document = builder.parse(is);
        } catch (ParserConfigurationException e) {
            System.out.println(e);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (SAXException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        this.servers = new ArrayList<Server>();
        NodeList nodeList = document.getElementsByTagName("server");
        //Loop through nodelist and add server object to server list
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element)node;
                servers.add(new Server(element.getAttribute("type"), element.getAttribute("limit"), element.getAttribute("bootupTime"), element.getAttribute("hourlyRate"), element.getAttribute("coreCount"), element.getAttribute("memory"), element.getAttribute("disk")));
            }
        }
    }
}
