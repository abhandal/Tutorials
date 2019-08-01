package command;

// Receiver
public class Light {
    private boolean on;

    public void switchOn() {
        on = true;
        System.out.println("Lights on");
    }

    public void switchOff() {
        on = false;
        System.out.println("Lights off");

    }
}
