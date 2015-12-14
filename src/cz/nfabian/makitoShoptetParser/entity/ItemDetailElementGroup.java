package cz.nfabian.makitoShoptetParser.entity;

import cz.nfabian.makitoShoptetParser.entity.paramters.Stock;

/**
 * Created by nfabian on 9.12.15.
 */
public class ItemDetailElementGroup {

    private String code;
    private String ean;
    private String weight;
    private String vat;
    private String price;
    private String purchasePrice;
    private String standardPrice;
    private String priceVat;
    private Stock stock;
    private String currency;
    private String availability;
    private String availabilityOutOfStock;
    private String availabilityInStock;

    public ItemDetailElementGroup() {
    }

    private ItemDetailElementGroup(Builder builder) {
        code = builder.code;
        ean = builder.ean;
        weight = builder.weight;
        vat = builder.vat;
        price = builder.price;
        purchasePrice = builder.purchasePrice;
        standardPrice = builder.standardPrice;
        priceVat = builder.priceVat;
        stock = builder.stock;
        currency = builder.currency;
        availability = builder.availability;
        availabilityOutOfStock = builder.availabilityOutOfStock;
        availabilityInStock = builder.availabilityInStock;
    }

    public static class Builder {

        private String code;
        private String ean;
        private String weight;
        private String vat;
        private String price;
        private String purchasePrice;
        private String standardPrice;
        private String priceVat;
        private Stock stock;
        private String currency;
        private String availability;
        private String availabilityOutOfStock;
        private String availabilityInStock;

        public Builder() {

        }

        public Builder code(String val) {
            code = val;
            return this;
        }

        public Builder ean(String val) {
            ean = val;
            return this;
        }

        public Builder weight(String val) {
            weight = val;
            return this;
        }

        public Builder vat(String val) {
            vat = val;
            return this;
        }

        public Builder price(String val) {
            price = val;
            return this;
        }

        public Builder purchasePrice(String val) {
            purchasePrice = val;
            return this;
        }

        public Builder standardPrice(String val) {
            standardPrice = val;
            return this;
        }

        public Builder priceVat(String val) {
            priceVat = val;
            return this;
        }

        public Builder stock(Stock val) {
            stock = val;
            return this;
        }

        public Builder currency(String val) {
            currency = val;
            return this;
        }

        public Builder availability(String val) {
            availability = val;
            return this;
        }

        public Builder availabilityOutOfStock(String val) {
            availabilityOutOfStock = val;
            return this;
        }

        public Builder availabilityInStock(String val) {
            availabilityInStock = val;
            return this;
        }

        public ItemDetailElementGroup build() {
            return new ItemDetailElementGroup(this);
        }

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice;
    }

    public String getPriceVat() {
        return priceVat;
    }

    public void setPriceVat(String priceVat) {
        this.priceVat = priceVat;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getAvailabilityOutOfStock() {
        return availabilityOutOfStock;
    }

    public void setAvailabilityOutOfStock(String availabilityOutOfStock) {
        this.availabilityOutOfStock = availabilityOutOfStock;
    }

    public String getAvailabilityInStock() {
        return availabilityInStock;
    }

    public void setAvailabilityInStock(String availabilityInStock) {
        this.availabilityInStock = availabilityInStock;
    }
}
