public class Client {
    public static void main(String[] args) {

        //setting light
        Light kitchenLight = new Light("Kitchen");
        Light livingRoomLight = new Light("Living Room");

        Command kitchenLightOnCommand = new LightOnCommand(kitchenLight);
        Command kitchenLightOffCommand = new LightOffCommand(kitchenLight);

        Command livingRoomLightOnCommand = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOffCommand = new LightOffCommand(livingRoomLight);

        RemoteController remoteController = new RemoteController();

        remoteController.setCommand(0, kitchenLightOnCommand, kitchenLightOffCommand);
        remoteController.setCommand(1, livingRoomLightOnCommand, livingRoomLightOffCommand);


        remoteController.onButtonPressed(0);
        remoteController.undo();
        remoteController.offButtonPressed(0);

        remoteController.onButtonPressed(1);
        remoteController.offButtonPressed(1);


    }
}
