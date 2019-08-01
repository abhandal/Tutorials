package singleton;

/*
Purpose:
When you need to ensure there's one instance of an object, available to a number of other classes,
you may want to use the Singleton pattern. Singletons are used a lot where you need to provide a registry,
or something like a thread pool. Logging is also another popular use of Singletons, providing one single access
point to an applications log file.
 */

public class Client {
    public static void run() {
        System.out.println("\n---------------------");
        System.out.println("Singleton pattern\n---------------------");
        SingletonClient();
    }

    private static void SingletonClient() {
        Singleton.getInstance().message();
    }
}
