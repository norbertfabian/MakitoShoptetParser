package cz.nfabian.makitoShoptetParser.entity.paramters;

/**
 * Created by nfabian on 9.12.15.
 */
public class Flag {

    private Boolean newItem;
    private Boolean tip;
    private Boolean action;

    public static class Builder {

        private Boolean newItem;
        private Boolean tip;
        private Boolean action;

        public Builder() {
        }

        public Builder newItem(Boolean val) {
            newItem = val;
            return this;
        }

        public Builder tip(Boolean val) {
            tip = val;
            return this;
        }

        public Builder action(Boolean val) {
            action = val;
            return this;
        }

        public Flag build() {
            return new Flag(this);
        }
    }

    private Flag(Builder builder) {
        newItem = builder.newItem;
        tip = builder.tip;
        action = builder.action;
    }

    public Boolean getNewItem() {
        return newItem;
    }

    public Boolean getTip() {
        return tip;
    }

    public Boolean getAction() {
        return action;
    }
}
