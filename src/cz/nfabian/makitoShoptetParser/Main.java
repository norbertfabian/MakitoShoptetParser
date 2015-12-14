package cz.nfabian.makitoShoptetParser;

import cz.nfabian.makitoShoptetParser.Service.XmlService;
import cz.nfabian.makitoShoptetParser.ServiceImpl.XmlServiceImpl;
import cz.nfabian.makitoShoptetParser.parser.MakitaParser;
import cz.nfabian.makitoShoptetParser.parser.ParserTemplate;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        XmlService xmlService = new XmlServiceImpl();
        ParserTemplate parser = new MakitaParser();

        try {
            xmlService.readItemsFromXml(args[0], parser);
            xmlService.writeItemsToXml(parser.getItems(), args[1]);
        } catch (IOException ex) {
            System.out.println("IOException: " + ex);
        } catch (SAXException ex) {
            System.out.println("SAXException: " + ex);
        } catch (XMLStreamException ex) {
            System.out.println("XMLStreamException: " + ex);
        } catch (ParserConfigurationException ex) {
            System.out.println("ParserConfigurationException: " + ex);
        }
    }

}
