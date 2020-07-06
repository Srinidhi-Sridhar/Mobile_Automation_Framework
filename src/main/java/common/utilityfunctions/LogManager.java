package common.utilityfunctions;

import org.apache.log4j.Logger;

public class LogManager {

    private static final Logger LOGGER = Logger.getLogger(LogManager.class.getName());

    //We can use it when starting tests
    public static void startLog (String testClassName){
        LOGGER.info("Test is Starting...");
    }

    //We can use it when ending tests
    public static void endLog (String testClassName){
        LOGGER.info("Test is Ending...");
    }

    //Info Level Logs
    public static void info (String message) {
        LOGGER.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        LOGGER.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        LOGGER.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        LOGGER.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        LOGGER.debug(message);
    }
}

