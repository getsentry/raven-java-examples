package com.getsentry.example;

import org.apache.log4j.Logger;

public class Application
{
    private static final Logger ravenLogger = Logger.getLogger("com.getsentry.raven.RavenLogger");
    
    private static final Logger logger = Logger.getLogger(Application.class);

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
