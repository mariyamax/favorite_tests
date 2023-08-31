package favorite.elemets;

public class Input extends BaseElement{
    public Input(String locator) {
        super(locator);
    }

    public Input(String locator,BaseElement element) {
        super(element,locator);
    }

    public void setText(String text) {
        find().sendKeys(text);
    }
}
