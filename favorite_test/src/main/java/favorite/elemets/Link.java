package favorite.elemets;

public class Link extends BaseElement{

    public Link(String locator) {
        super(locator);
    }

    public Link(String locator,BaseElement element) {
        super(element,locator);
    }
}
