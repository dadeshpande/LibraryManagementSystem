package com.library.LMS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LibraryLogger {
    private static final Logger logger = LoggerFactory.getLogger(LibraryLogger.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }
}