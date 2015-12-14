package cz.nfabian.makitoShoptetParser.entity;

import java.util.ArrayList;

/**
 * Created by nfabian on 9.12.15.
 */
public class Item {

    private ItemBasic itemBasic;
    private ArrayList<Variant> variants;
    private ItemDetailElementGroup itemDetailElementGroup;

    public Item(ItemBasic itemBasic, ArrayList<Variant> variants) {
        this(itemBasic, variants, null);
    }

    public Item(ItemBasic itemBasic, ItemDetailElementGroup itemDetailElementGroup) {
        this(itemBasic, null, itemDetailElementGroup);
    }

    private Item(ItemBasic itemBasic, ArrayList<Variant> variants, ItemDetailElementGroup itemDetailElementGroup) {
        this.itemBasic = itemBasic;
        this.variants = variants;
        this.itemDetailElementGroup = itemDetailElementGroup;
    }

    public ItemBasic getItemBasic() {
        return itemBasic;
    }

    public ArrayList<Variant> getVariants() {
        return variants;
    }

    public ItemDetailElementGroup getItemDetailElementGroup() {
        return itemDetailElementGroup;
    }
}
