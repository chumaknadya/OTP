package pack1;

import java.util.Random;

public class Flat extends ResidentalComponent {

    public Flat(String name) {
        super(name);
        Random rnd = new Random();
        this.peopleNumber = rnd.nextInt(10);
    }

    @Override
    public void Add(ResidentalComponent c) {
        System.out.println("Impossible operation");
    }

    @Override
    public void Remove(ResidentalComponent c) {
        System.out.println("Impossible operation");
    }

    @Override
    public void Display(int depth) {
        for(int i = 0;i < depth; i++) {
            System.out.printf("-",i+1);
        }
        System.out.printf( name + " " +this.peopleNumber+"\n");
    }

    @Override
    public int GetPopulationInfo() {
        return this.peopleNumber;
    }
}
