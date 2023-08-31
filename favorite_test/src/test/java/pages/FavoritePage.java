package pages;

import favorite.elemets.Button;
import favorite.elemets.Field;

public class FavoritePage extends BasePage {

    private static final String UNIQUE_LOCATOR = "//favorite-items-list";

    private static Field emptyItemsField = new Field("//*[@data-marker = 'favorites-empty']");
    private static Field productCount = new Field("//*[contains(@class,'category-content-count')]");
    private static Button activeFavoriteButton = new Button("//*[contains(@class,'withFavorites-heart_fill')]");
    private static Field favoriteProduct;
    public boolean isActiveButtonPresent() {
        return activeFavoriteButton.isPresent();
    }

    public FavoritePage() {
        super(UNIQUE_LOCATOR);
    }

    public int getProductAmount() {
        return Integer.parseInt(productCount.getText());
    }

    public void clickActiveFavoriteButton() {
        activeFavoriteButton.click();
    }

    public boolean isProductFavorite(Long selectedProductId) {
        favoriteProduct = new Field(String.format("//*[@data-marker='item-%d']",selectedProductId));
        return favoriteProduct.isPresent();
    }

    public boolean isEmptyDataFieldAppear() {
        return emptyItemsField.isPresent();
    }
}
