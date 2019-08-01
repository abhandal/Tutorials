package command;

public class Client {
    public static void run() {
        System.out.println("\n------------------------------------------");
        System.out.println("Command pattern\n------------------------------------------");
        CommandClient();
    }

    private static void CommandClient() {
        // Create Invoker
        RemoteControl control = new RemoteControl();

        // Create Receiver
        Light light = new Light();

        // Create commands
        Command lightsOn = new LightOnCommand(light);
        Command lightsOff = new LightOffCommand(light);

        // switch on light
        control.setCommand(lightsOn);
        control.pressButton();

        // switch off light
        control.setCommand(lightsOff);
        control.pressButton();
    }

}
