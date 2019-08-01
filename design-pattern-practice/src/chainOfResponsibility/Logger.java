package chainOfResponsibility;

public abstract class Logger {
    private LogLevel mask;
    private Logger next;
    public Logger(LogLevel mask) {
        this.mask = mask;
    }

    public Logger setNext(Logger logger) {
        this.next = logger;
        return next;
    }

    public void message(String msg, LogLevel priority) {
        if (priority.compareTo(mask) <= 0) {
            writeMessage(msg);
        }
        if (next != null) {
            next.message(msg, priority);
        }
    }

    protected abstract void writeMessage(String message);

    public enum LogLevel {
        ERR, NOTICE, DEBUG
    }
}
