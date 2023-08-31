package favorite.elemets;

import org.openqa.selenium.By;

/**
 * Футер, представлен как синглтон, тк общий для всех
 * В теории можно искать по специальному тегу
 */
public class Footer extends BaseElement {

    private static Footer footer;
    private Footer() {
        super("//*[contains(@class,'index-info')]");
    }

    public static Footer getFooter() {
        By.
        if (footer == null) {
         footer = new Footer();
        }
        return footer;
    }

}
