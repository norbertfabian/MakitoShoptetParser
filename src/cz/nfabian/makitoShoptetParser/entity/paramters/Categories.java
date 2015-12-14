package cz.nfabian.makitoShoptetParser.entity.paramters;

import java.util.ArrayList;

/**
 * Created by nfabian on 9.12.15.
 */
public class Categories {

    private ArrayList<Category> category;
    private ArrayList<Category> defaultCategory;

    public Categories(ArrayList<Category> category, ArrayList<Category> defaultCategory) {
        this.category = category;
        this.defaultCategory = defaultCategory;
    }

    public ArrayList<Category> getCategory() {
        return category;
    }

    public ArrayList<Category> getDefaultCategory() {
        return defaultCategory;
    }
}
