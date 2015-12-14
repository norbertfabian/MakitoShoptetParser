package cz.nfabian.makitoShoptetParser.parser;

import cz.nfabian.makitoShoptetParser.entity.Item;
import cz.nfabian.makitoShoptetParser.entity.ItemBasic;
import cz.nfabian.makitoShoptetParser.entity.ItemDetailElementGroup;
import cz.nfabian.makitoShoptetParser.entity.paramters.Categories;
import cz.nfabian.makitoShoptetParser.entity.paramters.Category;
import cz.nfabian.makitoShoptetParser.entity.paramters.Property;
import cz.nfabian.makitoShoptetParser.enumeration.Element;
import org.xml.sax.Attributes;

import java.util.ArrayList;

/**
 * Created by nfabian on 13.12.15.
 */
public class MakitaParser extends ParserTemplate {

    private String propertyName;

    @Override
    public void startElement (String uri, String localName, String qName, Attributes attributes) {
        if (qName.equals(Element.ITEM)) {
            itemBasic = new ItemBasic();
            itemDetailElementGroup = new ItemDetailElementGroup();
        } else if (qName.equals(Element.ITEM_ID) || qName.equals(Element.EAN) || qName.equals(Element.PRODUCT)
                || qName.equals(Element.CATEGORYTEXT) || qName.equals(Element.URL) || qName.equals(Element.IMGURL)
                || qName.equals(Element.IMGURL_ALTERNATIVE) || qName.equals(Element.RECOMMENDED_PRICE_VAT)
                || qName.equals(Element.VAT) || qName.equals(Element.ONSTOCK) || qName.equals(Element.UNITS)
                || qName.equals(Element.DESCRIPTION) || qName.equals(Element.PARAM_NAME)
                || qName.equals(Element.ACCESSORY)) {
            value.setLength(0);
            inElement = true;
        }
    };

    @Override
    public void endElement (String uri, String localName, String qName) {

        if (qName.equals(Element.ITEM)) {
            items.add(new Item(itemBasic, itemDetailElementGroup));
        } else if (qName.equals(Element.ITEM_ID)) {
            itemDetailElementGroup.setCode(value.toString());
            inElement = false;
        } else if (qName.equals(Element.EAN)) {
            itemDetailElementGroup.setEan(value.toString());
            inElement = false;
        } else if (qName.equals(Element.PRODUCT)) {
            itemBasic.setName(value.toString());
            inElement = false;
        } else if (qName.equals(Element.CATEGORYTEXT)) {
            if (itemBasic.getCategories() == null) {
                itemBasic.setCategories(new Categories(new ArrayList<>(), new ArrayList<>()));
            }
            itemBasic.getCategories().getCategory().add(new Category(value.toString().replace('|', '>')));
        } else if (qName.equals(Element.IMGURL)) {
            if (itemBasic.getImages() == null) {
                itemBasic.setImages(new ArrayList<>());
            }
            itemBasic.getImages().add(value.toString());
        } else if (qName.equals(Element.IMGURL_ALTERNATIVE)) {
            itemBasic.getImages().add(value.toString());
        } else if (qName.equals(Element.RECOMMENDED_PRICE_VAT)) {
            itemDetailElementGroup.setPriceVat(value.toString());
        } else if (qName.equals(Element.VAT)) {
            itemDetailElementGroup.setVat(value.toString());
        } else if (qName.equals(Element.ONSTOCK)) {
            itemDetailElementGroup.setAvailability(value.toString());
        } else if (qName.equals(Element.UNITS)) {
            itemBasic.setDefaultUnit(value.toString());
        } else if (qName.equals(Element.DESCRIPTION)) {
            itemBasic.setDescription(value.toString());
        } else if (qName.equals(Element.PARAM_NAME)) {
            if (itemBasic.getProperties() == null) {
                itemBasic.setProperties(new ArrayList<>());
            }
            propertyName = value.toString();
        } else if (qName.equals(Element.VAL)) {
            itemBasic.getProperties().add(new Property(propertyName, value.toString()));
        } else if (qName.equals(Element.ACCESSORY)) {
            if (itemBasic.getAlternativeProducts() == null) {
                itemBasic.setAlternativeProducts(new ArrayList<>());
            }
            itemBasic.getAlternativeProducts().add(value.toString());
        }
    };

    @Override
    public void characters (char ch[], int start, int length) {
        if (inElement) {
            value.append(ch, start, length);
        }
    };
}
