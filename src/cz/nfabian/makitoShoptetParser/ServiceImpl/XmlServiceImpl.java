package cz.nfabian.makitoShoptetParser.ServiceImpl;

import cz.nfabian.makitoShoptetParser.Service.XmlService;
import cz.nfabian.makitoShoptetParser.entity.Item;
import cz.nfabian.makitoShoptetParser.entity.ItemBasic;
import cz.nfabian.makitoShoptetParser.entity.ItemDetailElementGroup;
import cz.nfabian.makitoShoptetParser.entity.Variant;
import cz.nfabian.makitoShoptetParser.entity.paramters.Category;
import cz.nfabian.makitoShoptetParser.entity.paramters.Property;
import cz.nfabian.makitoShoptetParser.enumeration.Element;
import cz.nfabian.makitoShoptetParser.parser.ParserErrorHandler;
import cz.nfabian.makitoShoptetParser.parser.ParserTemplate;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by nfabian on 9.12.15.
 */
public class XmlServiceImpl implements XmlService {

    @Override
    public List<Item> readItemsFromXml(String file, ParserTemplate parser)
            throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setValidating(false);
        SAXParser saxLaval1 = spf.newSAXParser();
        XMLReader reader = saxLaval1.getXMLReader();
        reader.setErrorHandler(new ParserErrorHandler());
        reader.setContentHandler(parser);
        reader.parse(file);
        return parser.getItems();
    }

    @Override
    public void writeItemsToXml(List<Item> items, String file) throws XMLStreamException, IOException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        FileWriter xmlFileWriter = new FileWriter(new File(file));
        XMLStreamWriter writer = factory.createXMLStreamWriter(xmlFileWriter);

        writer.writeStartDocument("1.0");
        writer.writeStartElement(Element.SHOP);

        for (Item item : items) {
            writer.writeStartElement(Element.SHOPITEM);
            if (item.getItemBasic() != null) {
                writeItemBasic(writer, item.getItemBasic());
            }
            if (item.getVariants() != null && !item.getVariants().isEmpty()) {
                writeVariants(writer, item.getVariants());
            } else {
                writeItemDetailElementGroup(writer, item.getItemDetailElementGroup());
            }
            writer.writeEndElement();
        }
        writer.writeEndDocument();

        writer.flush();
        writer.close();
        xmlFileWriter.close();
    }

    private void writeItemBasic(XMLStreamWriter writer, ItemBasic itemBasic) throws XMLStreamException {
        if (itemBasic.getName() != null) {
            writeElement(writer, Element.NAME, itemBasic.getName());
        }
        if (itemBasic.getShortDescription() != null) {
            writeElement(writer, Element.SHORT_DESCRIPTION, itemBasic.getShortDescription());
        }
        if (itemBasic.getShortDescription() != null) {
            writeElement(writer, Element.DESCRIPTION, itemBasic.getDescription());
        }
        if (itemBasic.getManufacturer() != null) {
            writeElement(writer, Element.MANUFACTURER, itemBasic.getManufacturer());
        }
        if (itemBasic.getWarranty() != null) {
            writeElement(writer, Element.WARRANTY, itemBasic.getWarranty());
        }
        if (itemBasic.getItemType() != null) {
            writeElement(writer, Element.ITEM_TYPE, itemBasic.getItemType());
        }
        if (itemBasic.getDefaultUnit() != null) {
            writeElement(writer, Element.UNIT, itemBasic.getDefaultUnit());
        }
        if (itemBasic.getCategories() != null) {
            writer.writeStartElement(Element.CATEGORIES);
            if (itemBasic.getCategories().getCategory() != null) {
                for (Category category : itemBasic.getCategories().getCategory()) {
                    if (category.getId() != null) {
                        writeElement(writer, Element.CATEGORY, "id",
                                String.valueOf(category.getId()), category.getValue());
                    } else {
                        writeElement(writer, Element.CATEGORY, category.getValue());
                    }
                }
            }
            if (itemBasic.getCategories().getDefaultCategory() != null) {
                for (Category category : itemBasic.getCategories().getDefaultCategory()) {
                    if (category.getId() != null) {
                        writeElement(writer, Element.DEFAULT_CATEGORY, "id",
                                String.valueOf(category.getId()), category.getValue());
                    } else {
                        writeElement(writer, Element.DEFAULT_CATEGORY, category.getValue());
                    }
                }
            }
            writer.writeEndElement();
        }
        if (itemBasic.getImages() != null) {
            writer.writeStartElement(Element.IMAGES);
            for (String image : itemBasic.getImages()) {
                writeElement(writer, Element.IMAGE, image);
            }
            writer.writeEndElement();
        }
        if (itemBasic.getProperties() != null && !itemBasic.getProperties().isEmpty()) {
            writer.writeStartElement(Element.TEXT_PROPERTIES);
            for (Property property : itemBasic.getProperties()) {
                writer.writeStartElement(Element.TEXT_PROPERTY);
                writeElement(writer, Element.NAME, property.getName());
                writeElement(writer, Element.VALUE, property.getValue());
                if (property.getDescription() != null) {
                    writeElement(writer, Element.DESCRIPTION, property.getDescription());
                }
                writer.writeEndElement();
            }
            writer.writeEndElement();
        }
        if (itemBasic.getInformation() != null && !itemBasic.getInformation().isEmpty()) {
            writer.writeStartElement(Element.INFORMATION_PARAMETERS);
            for (Property information : itemBasic.getInformation()) {
                writer.writeStartElement(Element.INFORMATION_PARAMETER);
                writeElement(writer, Element.NAME, information.getName());
                writeElement(writer, Element.VALUE, information.getValue());
                writer.writeEndElement();
            }
            writer.writeEndElement();
        }
        if (itemBasic.getRelatedProducts() != null
                && !itemBasic.getRelatedProducts().isEmpty()) {
            writer.writeStartElement(Element.RELATED_PRODUCTS);
            for (String relatedProduct : itemBasic.getRelatedProducts()) {
                writeElement(writer, Element.CODE, relatedProduct);
            }
            writer.writeEndElement();
        }
        if (itemBasic.getAlternativeProducts() != null
                && !itemBasic.getAlternativeProducts().isEmpty()) {
            writer.writeStartElement(Element.ALTERNATIVE_PRODUCTS);
            for (String alternativeProduct : itemBasic.getAlternativeProducts()) {
                writeElement(writer, Element.CODE, alternativeProduct);
            }
            writer.writeEndElement();
        }
        if (itemBasic.getDefaultFreeShipping() != null) {
            writeElement(writer, Element.FREE_SHIPPING,
                    String.valueOf(itemBasic.getDefaultFreeShipping() ? 1 : 0));
        }
        if (itemBasic.getDefaultFreeBilling() != null) {
            writeElement(writer, Element.FREE_BILLING,
                    String.valueOf(itemBasic.getDefaultFreeBilling() ? 1 : 0));
        }
        if (itemBasic.getFlag() != null) {
            writer.writeStartElement(Element.FLAGS);
            if (itemBasic.getFlag().getNewItem() != null) {
                writeElement(writer, Element.NEW,
                        String.valueOf(itemBasic.getFlag().getNewItem() ? 1 : 0));
            }
            if (itemBasic.getFlag().getTip() != null) {
                writeElement(writer, Element.TIP,
                        String.valueOf(itemBasic.getFlag().getTip() ? 1 : 0));
            }
            if (itemBasic.getFlag().getTip() != null) {
                writeElement(writer, Element.ACTION,
                        String.valueOf(itemBasic.getFlag().getAction() ? 1 : 0));
            }
            writer.writeEndElement();
        }
    }

    private void writeVariants(XMLStreamWriter writer, List<Variant> variants) throws XMLStreamException {
        writer.writeStartElement(Element.VARIANTS);
        for (Variant variant : variants) {
            writer.writeStartElement(Element.VARIANT);
            writeVariant(writer, variant);
            writer.writeEndElement();
        }
        writer.writeEndElement();
    }

    private void writeVariant(XMLStreamWriter writer, Variant variant) throws XMLStreamException {
        if (variant.getParameters() != null && !variant.getParameters().isEmpty()) {
            writeItemDetailElementGroup(writer, variant.getItemDetailElementGroup());
            writer.writeStartElement(Element.PARAMETERS);
            for (Property parameter : variant.getParameters()) {
                writer.writeStartElement(Element.PARAMETER);
                writeElement(writer, Element.NAME, parameter.getName());
                writeElement(writer, Element.VALUE, parameter.getValue());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            if (variant.getFreeShipping() != null) {
                writeElement(writer, Element.FREE_SHIPPING,
                        String.valueOf(variant.getFreeShipping() ? 1 : 0));
            }
            if (variant.getFreeBilling() != null) {
                writeElement(writer, Element.FREE_BILLING,
                        String.valueOf(variant.getFreeBilling() ? 1 : 0));
            }
            if (variant.getUnit() != null) {
                writeElement(writer, Element.UNIT, variant.getUnit());
            }
        }
    }

    private void writeItemDetailElementGroup(
            XMLStreamWriter writer, ItemDetailElementGroup itemDetailElementGroup) throws XMLStreamException {
        if (itemDetailElementGroup.getCode() != null) {
            writeElement(writer, Element.CODE, itemDetailElementGroup.getCode());
        }
        if (itemDetailElementGroup.getEan() != null) {
            writeElement(writer, Element.EAN, itemDetailElementGroup.getEan());
        }
        if (itemDetailElementGroup.getWeight() != null) {
            writeElement(writer, Element.WEIGHT, itemDetailElementGroup.getWeight());
        }
        if (itemDetailElementGroup.getVat() != null) {
            writeElement(writer, Element.VAT, itemDetailElementGroup.getVat());
        }
        if (itemDetailElementGroup.getPrice() != null) {
            writeElement(writer, Element.PRICE, itemDetailElementGroup.getPrice());
        }
        if (itemDetailElementGroup.getPurchasePrice() != null) {
            writeElement(writer, Element.PURCHASE_PRICE, itemDetailElementGroup.getPurchasePrice());
        }
        if (itemDetailElementGroup.getStandardPrice() != null) {
            writeElement(writer, Element.STANDARD_PRICE, itemDetailElementGroup.getStandardPrice());
        }
        if (itemDetailElementGroup.getPriceVat() != null) {
            writeElement(writer, Element.PRICE_VAT, itemDetailElementGroup.getPriceVat());
        }
        if (itemDetailElementGroup.getStock() != null) {
            writer.writeStartElement(Element.STOCK);
            if (itemDetailElementGroup.getStock().getAmount() != null) {
                writeElement(writer, Element.AMOUNT, itemDetailElementGroup.getStock().getAmount());
            }
            if (itemDetailElementGroup.getStock().getMinAmount() != null) {
                writeElement(writer, Element.MINIMAL_AMOUNT, itemDetailElementGroup.getStock().getMinAmount());
            }
            if (itemDetailElementGroup.getStock().getMaxAmount() != null) {
                writeElement(writer, Element.MAXIMAL_AMOUNT, itemDetailElementGroup.getStock().getMaxAmount());
            }
            writer.writeEndElement();
        }
        if (itemDetailElementGroup.getCurrency() != null) {
            writeElement(writer, Element.CURRENCY, itemDetailElementGroup.getCurrency());
        }
        if (itemDetailElementGroup.getAvailability() != null) {
            writeElement(writer, Element.AVAILABILITY, itemDetailElementGroup.getAvailability());
        }
        if (itemDetailElementGroup.getAvailabilityOutOfStock() != null) {
            writeElement(writer, Element.AVAILABILITY_OUT_OF_STOCK, itemDetailElementGroup.getAvailabilityOutOfStock());
        }
        if (itemDetailElementGroup.getAvailabilityInStock() != null) {
            writeElement(writer, Element.AVAILABILITY_IN_STOCK, itemDetailElementGroup.getAvailabilityInStock());
        }
    }

    private void writeElement(XMLStreamWriter writer, String element, String characters) throws XMLStreamException {
        writeElement(writer, element, null, null, characters);
    }

    private void writeElement(XMLStreamWriter writer, String element, String attributeName,
                              String attributeValue, String characters) throws XMLStreamException {
        writer.writeStartElement(element);
        if (attributeName != null && attributeValue != null) {
            writer.writeAttribute(attributeName, attributeValue);
        }
        writer.writeCharacters(characters);
        writer.writeEndElement();
    }
}
