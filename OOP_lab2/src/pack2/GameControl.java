package pack2;

public class GameControl  extends  NewVersionsGame {
    private OldVersionsGame game = new OldVersionsGame();

    public GameControl(String name) {
        super(name);
    }
    @Override
    public void Mouse_MoveUp(){
        game.Joystick_MoveUp();
    }
    @Override
    public void Mouse_MoveDown(){
        game.Joystick_MoveDown();
    }
    @Override
    public void Mouse_MoveLeft(){
        game.Joystick_MoveLeft();
    }
    @Override
    public void Mouse_MoveRight(){
        game.Joystick_MoveRight();
    }
    @Override
    public void Mouse_Attack(){
        game.Joystick_Attack();
    }
    @Override
    public  void Mouse_Start(){
        game.Joystick_Start();
    }

}
