package pack1;


public  class Main {
    public static void main(String[] args) {
        AgeControllSystem controllSystem = new AgeControllSystem();
        User us1 = new User("Katya","Rostova");
        controllSystem.AddToSystem(us1);
        User us2 = new User("Roma","Ogorodnic",23);
        controllSystem.AddToSystem(us2);


    }
}
