package favorite.driver;

import favorite.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Фабрика для драйверов
 * Есть возможность дополнить другими браузерами
 * Учитывает установленный драйвер на пк, если в конфигах прописан путь
 */
public class BrowserFactory {

    public static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        ConfigProperties.getChromeOption();
        options.addArguments(ConfigProperties.getChromeOption());
        if (Files.exists(Paths.get(ConfigProperties.getChromeDriverPath()))) {
            System.setProperty(ConfigProperties.getChromeDriverConfig(), ConfigProperties.getChromeDriverPath());
        }
        return new ChromeDriver(options);
    }

}


