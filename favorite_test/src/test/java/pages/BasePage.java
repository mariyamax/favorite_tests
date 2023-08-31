package pages;

import favorite.driver.Driver;
import org.openqa.selenium.By;

/**
 * Базовый класс для всех страниц и форм
 */
public abstract class BasePage {

    //Уникальный элемент, присутствует только на этой странице
    //По нему идет определение, что нужная страница открыта
    private String uniqueElement;

    public String getUniqueElement() {
        return uniqueElement;
    }

    public BasePage(String uniqueLocator) {
        uniqueElement = uniqueLocator;
    }

    public boolean isOpen() {
        return Driver.getDriver().findElement(By.xpath(uniqueElement)).isDisplayed();
    }

    public void reload() {
        Driver.getDriver().navigate().refresh();
    }

}
