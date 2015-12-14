package cz.nfabian.makitoShoptetParser.parser;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 * Created by nfabian on 14.12.15.
 */
public class ParserErrorHandler implements ErrorHandler{

    private String errorMessage(SAXParseException ex) {
        return ex.getSystemId() + "\n"
                + "row: " + ex.getLineNumber()
                + " column: " + ex.getColumnNumber()
                + "\n" + ex.getMessage();
    }

    @Override
    public void warning(SAXParseException ex) throws SAXException {
        System.out.println("Warning: " + errorMessage(ex));
    }

    @Override
    public void error(SAXParseException ex) throws SAXException {
        throw new SAXException("Error: " + errorMessage(ex));

    }

    @Override
    public void fatalError(SAXParseException ex) throws SAXException {
        throw new SAXException("Fatal error: " + errorMessage(ex));
    }
}
