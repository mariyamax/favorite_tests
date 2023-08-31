package tests;

import favorite.driver.Driver;
import favorite.driver.DriverUtils;
import favorite.utils.Log;
import favorite.utils.ConfigProperties;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.FavoritePage;
import pages.NavBarForm;
import pages.ProductPage;

/**
 * Базовый тест, в котором прописаны основные методы до и после тестов, тест на авторизацию
 */
public abstract class BaseTest {

    protected NavBarForm navBarForm;
    protected FavoritePage favoritePage;
    protected ProductPage productPage;

    protected SoftAssert softAssert;

    @BeforeTest
    public void beforeTest() {
        Log.info("Открытие браузера");
        Driver.getDriver().get(ConfigProperties.getMainUrl());
        DriverUtils.setMaxWindowSize();
        Log.info("Инициализация страниц");
        navBarForm = new NavBarForm();
        favoritePage = new FavoritePage();
        productPage = new ProductPage();
        softAssert = new SoftAssert();
    }

    @Test(priority = -1)
    public void unauthorizedTest() {
        softAssert.assertTrue(navBarForm.isUnauthorized());
    }

    @AfterTest
    public void afterTest() {
        Log.info("Закрытие браузера");
        Driver.closeDriver();
    }
}
