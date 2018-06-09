package pack2;

public class User extends AbstractUser {
    private String _name;
    private String _surname;
    private  int _age;
    public User(String name,String surname,int age,IUser user) {
        super(user);
        _name = name;
        _surname = surname;
        _age = age;

    }

    @Override
    public void show() {
        user.showInfo(_name,_surname,_age);
    }
}
