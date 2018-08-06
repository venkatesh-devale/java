public class RemoteController {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteController() {
        onCommands = new Command[2];
        offCommands = new Command[2];

        Command noCommand = new NoCommand();
        for(int i=0; i < onCommands.length; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        undoCommand = onCommands[slot];
        onCommands[slot].execute();
    }

    public void offButtonPressed(int slot) {
        undoCommand = offCommands[slot];
        offCommands[slot].execute();
    }

    public void undo() {
        undoCommand.undo();
    }

}
