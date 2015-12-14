package cz.nfabian.makitoShoptetParser.entity.paramters;

/**
 * Created by nfabian on 9.12.15.
 */
public class Property {

    private String name;
    private String value;
    private String description;

    public Property(String name, String value, String description) {
        this(name, value);
        this.description = description;
    }

    public Property(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
