package chainOfResponsibility;

public class Client {
    public static void run() {
        System.out.println("\n------------------------------------------");
        System.out.println("Chain Of ResponsibilityClient pattern\n------------------------------------------");
        ChainOfResponsibilityClient();
    }

    private static void ChainOfResponsibilityClient() {
        // Build the CoR
        Logger logger = new StdOutLogger(Logger.LogLevel.DEBUG);
        logger.setNext(new EmailLogger(Logger.LogLevel.NOTICE));
        logger.setNext(new StdErrorLogger(Logger.LogLevel.ERR));

        // Handled by StdoutLogger
       logger.message("Entering function y.", Logger.LogLevel.DEBUG);

        // Handled by StdoutLogger and EmailLogger
        logger.message("Step1 completed.", Logger.LogLevel.NOTICE);

        // Handled by all three loggers
         logger.message("An error has occurred.", Logger.LogLevel.ERR);
    }
}
