package cz.nfabian.makitoShoptetParser.parser;

import cz.nfabian.makitoShoptetParser.entity.Item;
import cz.nfabian.makitoShoptetParser.entity.ItemBasic;
import cz.nfabian.makitoShoptetParser.entity.ItemDetailElementGroup;
import cz.nfabian.makitoShoptetParser.entity.Variant;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nfabian on 12.12.15.
 */
public abstract class ParserTemplate extends DefaultHandler {

    protected StringBuffer value = new StringBuffer();
    protected boolean inElement;

    protected Item item;
    protected List<Item> items = new ArrayList<>();
    protected ItemBasic itemBasic;
    protected ArrayList<Variant> variants;
    protected ItemDetailElementGroup itemDetailElementGroup;

    @Override
    public void startDocument() {
        items.clear();
    };

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) {

    };

    @Override
    public void endElement (String uri, String localName, String qName) {

    };

    @Override
    public void characters (char ch[], int start, int length) {

    };

    public List<Item> getItems() {
        return items;
    }
}
