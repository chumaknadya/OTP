package pack2;

public class NewVersionsGame   {
    private String nameOfGame;
    private boolean start = false;
    private int x_keyboard_coordinate;
    private int y__keyboard_coordinate;
    private int right_mouse_click;
    public NewVersionsGame(String name) {
        nameOfGame = name;
    }
    public void Mouse_MoveUp() {
        y__keyboard_coordinate++;
        System.out.println("Move up.Your coordinate: ("+ x_keyboard_coordinate+","+y__keyboard_coordinate+")");
    }


    public void Mouse_MoveDown() {
        y__keyboard_coordinate--;
        System.out.println("Move down.Your coordinate: ("+ x_keyboard_coordinate+","+y__keyboard_coordinate+")");
    }


    public void Mouse_MoveRight() {
        x_keyboard_coordinate++;
        System.out.println("Move right.Your coordinate: ("+ x_keyboard_coordinate+","+y__keyboard_coordinate+")");
    }


    public void Mouse_MoveLeft() {
        x_keyboard_coordinate++;
        System.out.println("Move left.Your coordinate: ("+ x_keyboard_coordinate+","+y__keyboard_coordinate+")");
    }


    public void Mouse_Start() {
        start = true;
        System.out.println("Game is starting with mouse. Please,connect mouse to your computer");
    }


    public void Mouse_Attack() {
        right_mouse_click++;
        System.out.println("Attackiiiiinggg .Piy Piy");
    }
}
