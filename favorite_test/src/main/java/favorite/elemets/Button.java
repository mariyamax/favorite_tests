package favorite.elemets;

public class Button extends BaseElement{

    public Button(String locator) {
        super(locator);
    }

    public Button(String locator,BaseElement element) {
        super(element,locator);
    }

}
