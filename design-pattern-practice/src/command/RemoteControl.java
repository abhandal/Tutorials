package command;

//Invoker
public class RemoteControl {
    // Reference to Command
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
