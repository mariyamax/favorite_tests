package favorite.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Класс для работы с конфигами
 */
public class ConfigProperties {

    private static final String PATH_TO_PROP = "src/main/resources/config.properties";
    private static final String MAIN_URL = "MainURL";
    private static final String TIMEOUT = "Timeout";
    private static final String FAVORITE_PAGE_URL = "FavoritePageURL";
    private static final String CHROME_DRIVER_PATH = "ChromeDriverPath";
    private static final String CHROME_DRIVER_CONFIG = "ChromeDriverConfig";
    private static final String CHROME_SINGLE_OPTION = "ChromeOption";

    private static Properties PROPERTIES;

    static {
        try (FileInputStream testDataInputStream = new FileInputStream(PATH_TO_PROP)) {
            PROPERTIES = new Properties();
            PROPERTIES.load(testDataInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось найти src/main/resources/config.properties");
        }
    }

    public static String getMainUrl() {
        return PROPERTIES.getProperty(MAIN_URL);
    }

    public static String getFavoritePageURL() {
        return PROPERTIES.getProperty(FAVORITE_PAGE_URL);
    }

    public static Duration getTimeout() {
        return Duration.ofMillis(Long.parseLong(PROPERTIES.getProperty(TIMEOUT)));
    }

    public static String getChromeDriverPath() {
        return PROPERTIES.getProperty(CHROME_DRIVER_PATH);
    }

    public static String getChromeDriverConfig() {
        return PROPERTIES.getProperty(CHROME_DRIVER_CONFIG);
    }

    public static String getChromeOption() {
        return PROPERTIES.getProperty(CHROME_SINGLE_OPTION);
    }
}
