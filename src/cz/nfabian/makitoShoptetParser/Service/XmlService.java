package cz.nfabian.makitoShoptetParser.Service;

import cz.nfabian.makitoShoptetParser.entity.Item;
import cz.nfabian.makitoShoptetParser.parser.ParserTemplate;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.List;

/**
 * Created by nfabian on 9.12.15.
 */
public interface XmlService {

    /**
     * Reads from the given xml file using the given parser
     *
     * @param file
     * @param parser
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     */
    List<Item> readItemsFromXml(String file, ParserTemplate parser)
            throws ParserConfigurationException, SAXException, IOException;

    /**
     * Writes Items to XML file
     *
     * @param items List of items to be written
     * @param file Output file
     * @throws XMLStreamException
     * @throws IOException
     */
    public void writeItemsToXml(List<Item> items, String file) throws XMLStreamException, IOException;
}
