package pack2;

public class SystemAdministrator implements IUser {

    @Override
    public void showInfo(String name,String surname,int age) {
        System.out.println("Name: "+ name+" "+ "Surname: "+ surname);
    }
}
