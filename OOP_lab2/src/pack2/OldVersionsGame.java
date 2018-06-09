package pack2;

public class OldVersionsGame  {
    private   boolean start_button = false;
    private int x_coordinate;
    private int y_coordinate;
    private   int attack_button;

    public void Joystick_MoveUp() {
        y_coordinate++;
        System.out.println("Move up.Your coordinate: ("+ x_coordinate+","+y_coordinate+")");
    }


    public void Joystick_MoveDown() {
        y_coordinate--;
        System.out.println("Move down.Your coordinate: ("+ x_coordinate+","+y_coordinate+")");
    }


    public void Joystick_MoveRight() {
        x_coordinate++;
        System.out.println("Move right.Your coordinate: ("+ x_coordinate+","+y_coordinate+")");
    }


    public void Joystick_MoveLeft() {
        x_coordinate--;
        System.out.println("Move left.Your coordinate: ("+ x_coordinate+","+y_coordinate+")");
    }

    public void Joystick_Start() {
        start_button = true;
        System.out.println("Game is starting with joystick.Please connect joystick to your computer");
    }


    public void Joystick_Attack() {
        attack_button++;
        System.out.println("Attackiiiiinggg .Piy Piy");
    }

}
