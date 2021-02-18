package com.letskodeit.teachable.ch23.subclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DifferentLevelLoggingFile {

    private static final Logger log = LogManager.getLogger(DifferentLevelLoggingFile.class.getName());

    public static void main(String[] args) {

        log.trace("Tim's Trace messaged logged.");
        log.debug("Tim's Debug messaged logged.");
        log.info("Tim's Info messaged logged.");
        log.error("Tim's Error messaged logged.");
        log.fatal("Tim's Fatal messaged logged.");

    }

}
