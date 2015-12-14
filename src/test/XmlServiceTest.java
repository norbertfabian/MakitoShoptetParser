package test;

import com.thaiopensource.relaxng.jaxp.XMLSyntaxSchemaFactory;
import cz.nfabian.makitoShoptetParser.Service.XmlService;
import cz.nfabian.makitoShoptetParser.ServiceImpl.XmlServiceImpl;
import cz.nfabian.makitoShoptetParser.entity.Item;
import cz.nfabian.makitoShoptetParser.entity.ItemBasic;
import cz.nfabian.makitoShoptetParser.entity.ItemDetailElementGroup;
import cz.nfabian.makitoShoptetParser.entity.Variant;
import cz.nfabian.makitoShoptetParser.entity.paramters.*;
import cz.nfabian.makitoShoptetParser.parser.MakitaParser;
import cz.nfabian.makitoShoptetParser.parser.ParserTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Created by nfabian on 11.12.15.
 */
public class XmlServiceTest {

    private XmlService xmlService = new XmlServiceImpl();

    @Test
    public void testReadItemsFromXml() throws IOException, SAXException, ParserConfigurationException {
        String fileName = "makita.xml";
        ParserTemplate parser = new MakitaParser();

        xmlService.readItemsFromXml(fileName, parser);

        Assert.assertEquals("Wrong amount of items!", 21733, parser.getItems().size());
    }

    @Test
    public void testWriteItemsToXml() throws SAXException, IOException, URISyntaxException, XMLStreamException {
        String fileName = "testXml.xml";
        File file = new File(fileName);

        xmlService.writeItemsToXml(createItems(), fileName);

        SchemaFactory factory = new XMLSyntaxSchemaFactory();
        Schema schema = factory.newSchema(new File("products-supplier-v10.rng"));
        Validator validator = schema.newValidator();

        validator.validate(new StreamSource(file));

        file.delete();
    }

    @Test
    public void testReadAndWriteXml()
            throws IOException, SAXException, ParserConfigurationException, XMLStreamException {

        String sourceFile = "makita.xml";
        String destinationFile = "testXml.xml";
        ParserTemplate parser = new MakitaParser();

        xmlService.readItemsFromXml(sourceFile, parser);
        xmlService.writeItemsToXml(parser.getItems(), destinationFile);
    }

    private static ArrayList<Item> createItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(createItemBasicWithoutVariants(), createItemDetailElementGroupWithoutVariants()));

        ArrayList<Variant> variants = new ArrayList<>();
        variants.add(createVariant1());
        variants.add(createVariant2());
        items.add(new Item(createItemBasicWithVariants(), variants));
        return items;
    }

    private static ItemBasic createItemBasicWithoutVariants() {
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Boty > Nike"));
        categoryList.add(new Category("Boty > Airmax"));
        Categories categories = new Categories(categoryList, null);

        ArrayList<String> images = new ArrayList<>();
        images.add("http://www.test.com/obrazky/nike1.jpg");
        images.add("http://www.test.com/obrazky/nike2.jpg");
        images.add("http://www.test.com/obrazky/nike3.jpg");

        ArrayList<Property> properties = new ArrayList<>();
        properties.add(new Property("Šití", "ruční"));
        properties.add(new Property("Podrážka", "gumová"));
        properties.add(new Property("Tkaničky", "kulaté"));

        ArrayList<String> relatedProducts = new ArrayList<>();
        relatedProducts.add("NA-23");
        relatedProducts.add("NA-29");
        relatedProducts.add("NA-32");



        return new ItemBasic.Builder().name("Nike AirMax").shortDescription("Stylové boty").description("Stylové boty")
                .manufacturer("Nike").warranty("24").itemType("product").unit("ks").categories(categories)
                .images(images).properties(properties).relatedProducts(relatedProducts)
                .alternativeProducts(relatedProducts).flag(new Flag.Builder().action(Boolean.TRUE)
                        .newItem(Boolean.TRUE).tip(Boolean.FALSE).build()).build();
    }

    private static ItemBasic createItemBasicWithVariants() {
        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Trička > Pánské"));
        Categories categories = new Categories(categoryList, null);

        ArrayList<String> images = new ArrayList<>();
        images.add("http://www.test.com/pictures/56464654.gif");

        ArrayList<Property> properties = new ArrayList<>();
        properties.add(new Property("Šití", "ruční"));
        properties.add(new Property("Podrážka", "gumová"));
        properties.add(new Property("Tkaničky", "kulaté"));

        ArrayList<String> relatedProducts = new ArrayList<>();
        relatedProducts.add("NA-23");
        relatedProducts.add("NA-29");
        relatedProducts.add("NA-32");



        return new ItemBasic.Builder().name("Tričko adidas").shortDescription("Tričko pěkné")
                .description("Triško šité z kvalitních materiálů").manufacturer("Adidas").warranty("24")
                .itemType("product").unit("ks").categories(categories)
                .images(images).properties(properties).relatedProducts(relatedProducts)
                .alternativeProducts(relatedProducts).flag(new Flag.Builder().action(Boolean.FALSE)
                        .newItem(Boolean.TRUE).tip(Boolean.TRUE).build()).build();
    }

    private static Variant createVariant1() {
        ArrayList<Property> parameters = new ArrayList<>();
        parameters.add(new Property("Barva", "Zelená"));
        parameters.add(new Property("Velikost", "36"));

        return new Variant.Builder().parameters(parameters)
                .itemDetailElementGroup(createItemDetailElementGroupVariants1()).build();

    }

    private static Variant createVariant2() {
        ArrayList<Property> parameters = new ArrayList<>();
        parameters.add(new Property("Barva", "Modrá"));
        parameters.add(new Property("Velikost", "36"));

        return new Variant.Builder().parameters(parameters)
                .itemDetailElementGroup(createItemDetailElementGroupVariants1()).build();
    }

    private static ItemDetailElementGroup createItemDetailElementGroupWithoutVariants() {
        return new ItemDetailElementGroup.Builder().code("NA-25").price("2320.00").standardPrice("2500.00")
                .purchasePrice("1980.00").priceVat("2480.00").weight("0,32").vat("21").ean("5051571703857")
                .currency("CZK").stock(new Stock.Builder().amount("25").minAmount("1").build()).availability("Skladem")
                .build();
    }

    private static ItemDetailElementGroup createItemDetailElementGroupVariants1() {
        return new ItemDetailElementGroup.Builder().code("AD-35").price("200.00").standardPrice("250.00")
                .purchasePrice("100.00").priceVat("220").vat("21").currency("CZK").availability("Skladem za 14 dní")
                .build();
    }

    private static ItemDetailElementGroup createItemDetailElementGroupVariants2() {
        return new ItemDetailElementGroup.Builder().code("AD-28").ean("012234566789").price("200.00")
                .standardPrice("250.00").purchasePrice("100.00").priceVat("220").vat("21").currency("CZK")
                .availability("Skladem za 14 dní").build();
    }
}
