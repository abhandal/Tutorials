package chainOfResponsibility;

public class StdOutLogger extends Logger {
    public StdOutLogger(LogLevel mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("Writing to stdout: " + msg);
    }
}
