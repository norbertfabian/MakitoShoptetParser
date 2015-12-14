package cz.nfabian.makitoShoptetParser.entity;

import cz.nfabian.makitoShoptetParser.entity.paramters.Categories;
import cz.nfabian.makitoShoptetParser.entity.paramters.Flag;
import cz.nfabian.makitoShoptetParser.entity.paramters.Property;

import java.util.ArrayList;

/**
 * Created by nfabian on 8.12.15.
 */
public class ItemBasic {

    private String name;
    private String shortDescription;
    private String description;
    private String manufacturer;
    private String warranty;
    private String itemType;
    private String defaultUnit;
    private Categories categories;
    private ArrayList<String> images;
    private ArrayList<Property> properties;
    private ArrayList<Property> information;
    private ArrayList<String> relatedProducts;
    private ArrayList<String> alternativeProducts;
    private Boolean defaultFreeShipping;
    private Boolean defaultFreeBilling;
    private Flag flag;

    public ItemBasic() {
    }

    private ItemBasic(Builder builder) {
        name = builder.name;
        shortDescription = builder.shortDescription;
        description = builder.description;
        manufacturer = builder.manufacturer;
        warranty = builder.warranty;
        itemType = builder.itemType;
        defaultUnit = builder.defaultUnit;
        categories = builder.categories;
        images = builder.images;
        properties = builder.properties;
        information = builder.information;
        relatedProducts = builder.relatedProducts;
        alternativeProducts = builder.alternativeProducts;
        defaultFreeShipping = builder.defaultFreeShipping;
        defaultFreeBilling = builder.defaultFreeBilling;
        flag = builder.flag;
    }

    public static class Builder {

        private String name;
        private String shortDescription;
        private String description;
        private String manufacturer;
        private String warranty;
        private String itemType;
        private String defaultUnit;
        private Categories categories;
        private ArrayList<String> images;
        private ArrayList<Property> properties;
        private ArrayList<Property> information;
        private ArrayList<String> relatedProducts;
        private ArrayList<String> alternativeProducts;
        private Boolean defaultFreeShipping;
        private Boolean defaultFreeBilling;
        private Flag flag;

        public Builder() {

        };

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder shortDescription(String val) {
            shortDescription = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder manufacturer(String val) {
            manufacturer = val;
            return this;
        }

        public Builder warranty(String val) {
            warranty = val;
            return this;
        }

        public Builder itemType(String val) {
            itemType = val;
            return this;
        }

        public Builder unit(String val) {
            defaultUnit = val;
            return this;
        }

        public Builder categories(Categories val) {
            categories = val;
            return this;
        }

        public Builder images(ArrayList<String> val) {
            images = val;
            return this;
        }

        public Builder properties(ArrayList<Property> val) {
            properties = val;
            return this;
        }

        public Builder information(ArrayList<Property> val) {
            information = val;
            return this;
        }

        public Builder relatedProducts(ArrayList<String> val) {
            relatedProducts = val;
            return this;
        }

        public Builder alternativeProducts(ArrayList<String> val) {
            alternativeProducts = val;
            return this;
        }

        public Builder defaultFreeShipping(Boolean val) {
            defaultFreeShipping = val;
            return this;
        }

        public Builder defaultFreeBilling(Boolean val) {
            defaultFreeBilling = val;
            return this;
        }

        public Builder flag(Flag val) {
            flag = val;
            return this;
        }

        public ItemBasic build() {
            return new ItemBasic(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDefaultUnit() {
        return defaultUnit;
    }

    public void setDefaultUnit(String defaultUnit) {
        this.defaultUnit = defaultUnit;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> images) {
        this.images = images;
    }

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public ArrayList<Property> getInformation() {
        return information;
    }

    public void setInformation(ArrayList<Property> information) {
        this.information = information;
    }

    public ArrayList<String> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(ArrayList<String> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }

    public ArrayList<String> getAlternativeProducts() {
        return alternativeProducts;
    }

    public void setAlternativeProducts(ArrayList<String> alternativeProducts) {
        this.alternativeProducts = alternativeProducts;
    }

    public Boolean getDefaultFreeShipping() {
        return defaultFreeShipping;
    }

    public void setDefaultFreeShipping(Boolean defaultFreeShipping) {
        this.defaultFreeShipping = defaultFreeShipping;
    }

    public Boolean getDefaultFreeBilling() {
        return defaultFreeBilling;
    }

    public void setDefaultFreeBilling(Boolean defaultFreeBilling) {
        this.defaultFreeBilling = defaultFreeBilling;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
}
