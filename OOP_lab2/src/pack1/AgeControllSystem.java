package pack1;

import java.util.Scanner;

public class AgeControllSystem extends Abst_System {
    User_System system = new User_System();
    @Override
    public void AddToSystem(User u) {
        if (u.getAge() == 0) {
            String answer = askQuestionAboutAge();
            checkConditionIfAgeWasPassed(u,answer);
        } else
              checkConditionIfAgeExist(u);

    }
    private String askQuestionAboutAge() {
        System.out.println("Have you been 18 years old?");
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();
        return  answer;
    }
    private void checkConditionIfAgeExist(User u) {
        if (u.getAge() >= 18)
            system.AddToSystem(u);
        else
            System.out.println("Oh,you are so young for this system");
    }
    private void checkConditionIfAgeWasPassed(User u,String answer) {
        if (answer == "Yes" || answer == "yes")
            system.AddToSystem(u);
        else
            System.out.println("Oh,you are so young for this system");
    }
}
