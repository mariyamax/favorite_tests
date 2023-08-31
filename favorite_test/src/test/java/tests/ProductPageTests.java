package tests;

import favorite.driver.Driver;
import favorite.driver.DriverUtils;
import favorite.utils.Log;
import favorite.utils.ConfigProperties;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Тест функциональности выбора товара как избранного
 */
public class ProductPageTests extends BaseTest {

    @BeforeMethod
    public void beforeTest() {
        super.beforeTest();
    }

    @Parameters({"favoriteProductsAmount","selectedProductId","dimension"})
    @Test(priority = 1,groups = {"productPageTests"})
    public void productHiddenMenuTest(int favoriteProductsAmount,Long selectedProductId,int dimension) {

        Dimension d = new Dimension(dimension,dimension);
        Driver.getDriver().manage().window().setSize(d);

        Log.info("Тест на избранное через всплывающее меню");
        productPage.clickHiddenMenuButton();
        Log.info("Переход на страницу \"Избранное\" через меню");
        navBarForm.clickFavoriteButton();

        Assert.assertTrue(favoritePage.isOpen());
        Log.info("Проверка URL страницы \"Избранное\"");
        Assert.assertEquals(DriverUtils.getCurrentUrl(), ConfigProperties.getFavoritePageURL());
        Log.info("Проверка количества избранных товаров");
        Assert.assertEquals(favoritePage.getProductAmount(), favoriteProductsAmount);
        Log.info("Проверка наличия нужного товара в избранном");
        Assert.assertTrue(favoritePage.isProductFavorite(selectedProductId));

        Log.info("Оставляем товар");
    }

    @Parameters({"favoriteProductsAmount","selectedProductId","favoriteButtonTitle"})
    @Test(priority = 0)
    public void productFavoriteButtonTest(int favoriteProductsAmount,Long selectedProductId,String favoriteButtonTitle) {
        Log.info("Тест на избранное через кнопку в карточке товара");
        productPage.clickSimpleFavoriteButton();

        Log.info("Проверка изменения атрибута data-is-favorite");
        softAssert.assertTrue(productPage.isDataInFavorite());
        Log.info("Проверка изменения текста на кнопке");
        softAssert.assertEquals(productPage.getSimpleButtonText(), favoriteButtonTitle);

        Log.info("Проверка появления подсказки с ссылкой");
        Assert.assertTrue(productPage.isDropdownAppear());
        Log.info("Переход на страницу \"Избранное\" через ссылку");
        productPage.clickDropdownLink();

        Assert.assertTrue(favoritePage.isOpen());
        Log.info("Проверка URL страницы \"Избранное\"");
        Assert.assertEquals(DriverUtils.getCurrentUrl(), ConfigProperties.getFavoritePageURL());
        Log.info("Проверка количества избранных товаров");
        Assert.assertEquals(favoritePage.getProductAmount(),favoriteProductsAmount);
        Log.info("Проверка наличия нужного товара в избранном");
        Assert.assertTrue(favoritePage.isProductFavorite(selectedProductId));

        Log.info("Убираем товар из избранного");
        favoritePage.clickActiveFavoriteButton();
    }


    @AfterTest
    public void afterTest() {
        super.afterTest();
    }
}
