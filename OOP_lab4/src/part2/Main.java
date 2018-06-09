package part2;

public class Main {
    public static void main(String[] args) {
        //first example
        double cost =  45.0;
        Repair remont;
        if (cost < 45) {
            remont = new CheapRepair();
            remont.makeRepairs();
        } else if(cost == 45) {
            remont = new MiddleRepair();
            remont.makeRepairs();
        } else {
            remont = new ExpensiveRepair();
            remont.makeRepairs();
        }

    }
}
