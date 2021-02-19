package com.letskodeit.teachable.ch23.log4j2.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFile {

    private static final Logger log = LogManager.getLogger(LoggingFile.class.getName());

    public static void main(String[] args) {

        log.trace("Tim's Trace messaged logged.");
        log.debug("Tim's Debug messaged logged.");
        log.info("Tim's Info messaged logged.");
        log.error("Tim's Error messaged logged.");
        log.fatal("Tim's Fatal messaged logged.");

    }

}
