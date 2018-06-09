package part1;
//Invoker
class Dean{
    Command command;
    public void SetExam(Command c)
    {
        command = c;
    }
    public void AppointExam()
    {
        command.Execute();
    }
    public void CancelExam()
    {
        command.Undo();
    }
}
//Command
abstract class Command
{
    public abstract int Execute();
    public abstract void Undo();
}
//Concrete Command
class  Exam  extends  Command{
    Committee commision;
    public  Exam(Committee comm) {
        commision = comm;
    }
    @Override
    public int Execute() {
        if(commision != null){
            return commision.takeExam();
        }
        return 2;
    }

    @Override
    public void Undo() {
        System.out.println("Cancellation of commission");
    }
}
//Receiver
abstract  class Committee{
    public  abstract int takeExam();
}
class FirstCommission extends  Committee{

    @Override
    public int takeExam() {
        System.out.println("Put 5 to student");
        return 5;
    }
}
class SecondCommission extends  Committee{

    @Override
    public int takeExam() {
        System.out.println("Put 4 to student");
        return 4;
    }
}
class ThirdCommission extends Committee {

    @Override
    public int takeExam() {
        System.out.println("Put 3 to student");
        return 3;
    }
}