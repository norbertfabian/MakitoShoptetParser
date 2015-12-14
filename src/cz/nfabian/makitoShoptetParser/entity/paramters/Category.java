package cz.nfabian.makitoShoptetParser.entity.paramters;

/**
 * Created by nfabian on 9.12.15.
 */
public class Category {

    private Integer id;
    private String value;

    public Category(int id, String value) {
        this(value);
        this.id = id;
    }

    public Category(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
