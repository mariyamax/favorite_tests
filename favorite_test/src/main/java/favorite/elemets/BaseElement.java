package favorite.elemets;

import favorite.driver.Driver;
import favorite.driver.DriverUtils;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Основной класс для всех элементов
 */
@Data
public abstract class BaseElement {

    private By locator;

    public BaseElement(String locator) {
        this.locator = By.xpath(locator);
    }

    protected WebElement find() {
        DriverUtils.getWait().until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(locator)));
        return Driver.getDriver().findElement(locator);
    }

    public String getText() {
        return find().getText();
    }

    public String getParam(String param) {
        return find().getAttribute(param);
    }

    public void click() {
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(locator));
        scrollToElement();
        find().click();
    }

    public void scrollToElement() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView()",
                Driver.getDriver().findElement(locator));
    }

    public boolean isPresent() {
        try {
            DriverUtils.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return Driver.getDriver().findElement(locator) != null;
    }

    protected BaseElement(BaseElement element, String locator) {
        String fullLocator = element.locator.toString().concat(locator);
        this.locator = By.xpath(fullLocator);
    }

    public By getLocator() {
        return locator;
    }
}
