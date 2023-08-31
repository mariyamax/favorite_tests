package pages;

import favorite.elemets.Button;
import favorite.elemets.Link;

public class NavBarForm {

    private Button favoriteButton = new Button("//*[@data-marker='header/favorites']");

    private Link registrationLink = new Link("//*[@data-marker='header/login-button']");

    public boolean isUnauthorized() {
        return registrationLink.isPresent();
    }

    public void clickFavoriteButton() {
        favoriteButton.click();
    }
}
