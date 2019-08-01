package singleton;

// One class that returns a single instance of the object, constructor must be set to private
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void message() {
        System.out.println("I am your one and only instance");
    }
}
