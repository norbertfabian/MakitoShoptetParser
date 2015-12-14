package cz.nfabian.makitoShoptetParser.entity;

import cz.nfabian.makitoShoptetParser.entity.paramters.Property;

import java.util.ArrayList;

/**
 * Created by nfabian on 8.12.15.
 */
public class Variant {

    private ArrayList<Property> parameters;
    private Boolean freeShipping;
    private Boolean freeBilling;
    private String unit;
    private ItemDetailElementGroup itemDetailElementGroup;

    public Variant() {
    }

    private Variant(Builder builder) {
        parameters = builder.parameters;
        freeShipping = builder.freeShipping;
        freeBilling = builder.freeBilling;
        unit = builder.unit;
        itemDetailElementGroup = builder.itemDetailElementGroup;
    }

    public static class Builder {

        private ArrayList<Property> parameters;
        private Boolean freeShipping;
        private Boolean freeBilling;
        private String unit;
        private ItemDetailElementGroup itemDetailElementGroup;

        public Builder(){

        };

        public Builder parameters(ArrayList<Property> val) {
            parameters = val;
            return this;
        }

        public Builder freeShipping(Boolean val) {
            freeShipping = val;
            return this;
        }

        public Builder freeBilling(Boolean val) {
            freeBilling = val;
            return this;
        }

        public Builder unit(String val) {
            unit = val;
            return this;
        }

        public Builder itemDetailElementGroup(ItemDetailElementGroup val) {
            itemDetailElementGroup = val;
            return this;
        }

        public Variant build(){
            return new Variant(this);
        }
    }

    public ArrayList<Property> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Property> parameters) {
        this.parameters = parameters;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Boolean getFreeBilling() {
        return freeBilling;
    }

    public void setFreeBilling(Boolean freeBilling) {
        this.freeBilling = freeBilling;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ItemDetailElementGroup getItemDetailElementGroup() {
        return itemDetailElementGroup;
    }

    public void setItemDetailElementGroup(ItemDetailElementGroup itemDetailElementGroup) {
        this.itemDetailElementGroup = itemDetailElementGroup;
    }
}
