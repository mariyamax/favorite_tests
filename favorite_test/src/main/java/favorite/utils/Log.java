package favorite.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger log;

    public static void info(String info) {
        if (log == null){
            log = LogManager.getLogger();
        }
        log.info(info);
    }

    public static void error(String error) {
        if (log == null){
            log = LogManager.getLogger();
        }
        log.error(error);
    }

}
