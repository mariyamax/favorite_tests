package favorite.driver;

import org.openqa.selenium.WebDriver;

/**
 * Основной класс драйвера в виде singleton
 */
public class Driver {

    private static WebDriver driver;

    private Driver() {
        driver = BrowserFactory.createDriver();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new Driver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}

