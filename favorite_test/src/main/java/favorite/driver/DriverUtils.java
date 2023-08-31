package favorite.driver;

import favorite.utils.ConfigProperties;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс для вызова методов драйвера
 */
public class DriverUtils {

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ConfigProperties.getTimeout());

    public static WebDriverWait getWait(){
        return wait;
    }

    public static void setMaxWindowSize(){
        Driver.getDriver().manage().window().maximize();
    }

    public static String getCurrentUrl() {
        return Driver.getDriver().getCurrentUrl();
    }

}
