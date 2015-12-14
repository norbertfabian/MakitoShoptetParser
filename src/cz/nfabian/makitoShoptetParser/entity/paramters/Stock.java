package cz.nfabian.makitoShoptetParser.entity.paramters;

/**
 * Created by nfabian on 9.12.15.
 */
public class Stock {

    private String amount;
    private String minAmount;
    private String maxAmount;

    public static class Builder {

        private String amount;
        private String minAmount;
        private String maxAmount;

        public Builder() {
        }

        public Builder amount(String val) {
            amount = val;
            return this;
        }

        public Builder minAmount(String val) {
            minAmount = val;
            return this;
        }

        public Builder maxAmount(String val) {
            maxAmount = val;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }
    }

    private Stock(Builder builder) {
        amount = builder.amount;
        minAmount = builder.minAmount;
        maxAmount = builder.maxAmount;
    }

    public String getAmount() {
        return amount;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public String getMaxAmount() {
        return maxAmount;
    }
}
