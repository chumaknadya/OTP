package pack1;

import java.util.ArrayList;
import java.util.List;

public class User_System extends  Abst_System {
    List <User> users = new ArrayList<User>();
    @Override
    public void AddToSystem(User u) {
        System.out.println("You have successfully registered, "+ u.getName());
        users.add(u);
    }
    public void showUsers(){
        for(User u : users)
            System.out.println(u.getName()+" "+u.getAge());
    }
}
