package favorite.elemets;


public class Field extends BaseElement {

    private static final String VALUE_ATTRIBUTE = "value";

    public Field(String locator) {
        super(locator);
    }

    public String getValue() {
        return find().getAttribute(VALUE_ATTRIBUTE);
    }

}
