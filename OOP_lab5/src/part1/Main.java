package part1;

public class Main {
    public static void main(String[] args) {
        Dean Duchka = new Dean();
        FirstCommission com1 = new FirstCommission();
        SecondCommission com2 = new SecondCommission();
        ThirdCommission com3 = new ThirdCommission();
        Exam exam1 = new Exam(com1);
        Exam exam2 = new Exam(com2);
        Exam exam3 = new Exam(com3);
        Duchka.SetExam(exam2);
        Duchka.AppointExam();
    }
}
