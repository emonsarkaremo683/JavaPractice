package domproject;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMProject {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse("student.xml");

        Element element = document.getDocumentElement();
        System.out.println(element);

        NodeList nodeList = document.getElementsByTagName("student");

        System.out.println(nodeList);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                String id = e.getElementsByTagName("id").item(0).getTextContent();
                String name = e.getElementsByTagName("name").item(0).getTextContent();
                String age = e.getElementsByTagName("age").item(0).getTextContent();
                System.out.println("ID: "+ id + ", Name:" + name + ", Age: " + age);
            }

        }

    }

}
