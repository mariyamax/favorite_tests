package pages;

import favorite.driver.Driver;
import favorite.driver.DriverUtils;
import favorite.elemets.*;
import org.apache.commons.lang3.BitField;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    private static final String UNIQUE_LOCATOR = "";

    private static Button favoriteButton = new Button("//*[contains(@class,'style-header-add-favorite')]/button");
    private static Link favoritePageLink = new Link("//*[contains(@data-popper-placement,'bottom')]//a");
    private static Button hiddenMenuFavoriteButton = new Button("//*[contains(@class,'style-sticky-header-action')]//*[@data-marker='item-view/favorite-button']");

    private static Field avitoLabel = new Field("//*[@data-marker='header-navigation']");

    public ProductPage() {
        super(UNIQUE_LOCATOR);
    }

    public void clickSimpleFavoriteButton() {
        favoriteButton.click();
    }

    public String getSimpleButtonText() {
        Field span = new Field("//*[contains(@class,'style-header-add-favorite')]//span");
        return span.getText();
    }

    public Boolean isDataInFavorite() {
        return Boolean.parseBoolean(favoriteButton.getParam("data-is-favorite"));
    }
    public void clickDropdownLink() {
        avitoLabel.scrollToElement();
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(favoritePageLink.getLocator())).click();
    }

    public void clickHiddenMenuButton() {
        Footer.getFooter().scrollToElement();
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(hiddenMenuFavoriteButton.getLocator()));
        hiddenMenuFavoriteButton.click();
    }

    public boolean isDropdownAppear() {
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(favoritePageLink.getLocator()));
        return favoritePageLink.isPresent();
    }
}
