package observer;

// Think of the subject like a newspaper publisher and the observers like subscribers
// In this example the observers are interested in receiving a weather update
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
