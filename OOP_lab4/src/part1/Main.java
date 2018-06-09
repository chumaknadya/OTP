package part1;

public class Main {
    public static void main(String[] args) {
        Treatment tr = new Treatment();
        FolkMedicine medicine = new FolkMedicine();
        tr.SetTreatment(medicine);
        tr.Cure("headache");
    }
}
