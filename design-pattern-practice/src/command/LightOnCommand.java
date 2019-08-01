package command;

// Concrete Command
public class LightOnCommand implements Command{
    //Reference to Light
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOn();
    }
}
