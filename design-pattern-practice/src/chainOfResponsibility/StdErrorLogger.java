package chainOfResponsibility;

public class StdErrorLogger extends Logger {


    public StdErrorLogger(LogLevel mask) {
        super(mask);
    }

    @Override
    protected void writeMessage(String msg) {
        System.out.println("Sending to stderr: " + msg);
    }
}
