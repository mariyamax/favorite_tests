package tests;

import favorite.utils.Log;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Тест функциональности страницы избранное
 */
public class FavoritePageTests extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();
    }

    @Parameters({"favoriteProductsAmount"})
    @Test(dependsOnGroups = {"productPageTests"})
    public void favoritePageTest(int favoriteProductsAmount) {
        Log.info("Переходим на страницу \"Избранное\" через верхнее меню");
        navBarForm.clickFavoriteButton();
        favoritePage.isOpen();
        Log.info("Проверяем, что товар в избранном");
        Assert.assertEquals(favoritePage.getProductAmount(),favoriteProductsAmount);
        favoritePage.reload();
        Log.info("Проверяем, что товар в избранном после перезагрузки");
        Assert.assertEquals(favoritePage.getProductAmount(),favoriteProductsAmount);

        Log.info("Нажимаем на подсвечивующуюся кнопку избранное");
        favoritePage.clickActiveFavoriteButton();
        Log.info("Проверяем, что количество продуктов уменьшилось");
        Assert.assertEquals(favoritePage.getProductAmount(),favoriteProductsAmount-1);
        Log.info("Проверяем, что кнопка не подсвечивается");
        softAssert.assertFalse(favoritePage.isActiveButtonPresent());

        Log.info("Проверяем, что после перезагрузки вкладка очистилась");
        favoritePage.reload();
        Assert.assertTrue(favoritePage.isEmptyDataFieldAppear());
    }

    @AfterTest
    public void afterTest() {
        super.afterTest();
    }
}
