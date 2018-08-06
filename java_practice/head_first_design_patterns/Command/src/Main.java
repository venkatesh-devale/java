public class Main {

    public static void main(String[] args) {


        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);



        lightOnCommand.execute();
        lightOffCommand.execute();


    }
}
