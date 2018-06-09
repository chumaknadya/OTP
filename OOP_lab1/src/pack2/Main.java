package pack2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbstractUser us1 = new User("Katya","Romanenko",27,new OrdinaryUser());
        AbstractUser us2 = new User("Kolya","Hlopyachuy",20,new SystemAdministrator());
        AbstractUser us3 = new User("Mitya","Yurchenko",45,new VipUser());
        us1.show();
        us2.show();
        us3.show();
    }
}
