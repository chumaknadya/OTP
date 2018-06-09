package pack2;

public abstract class AbstractUser {
    IUser user;
    public AbstractUser(IUser u)
    {
        this.user = u;
    }
    public abstract void show();
}
