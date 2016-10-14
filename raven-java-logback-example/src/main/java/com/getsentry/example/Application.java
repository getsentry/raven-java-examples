package com.getsentry.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application
{
    private static final Logger ravenLogger = LoggerFactory.getLogger("com.getsentry.raven.RavenLogger");

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args)
    {
        ravenLogger.error("This should not be sent to Sentry, because it originates inside of Raven itself.");
        
        try {
            int example = 1 / 0;
        } catch (Exception e) {
            logger.error("Caught exception!", e);
        }
    }
}
