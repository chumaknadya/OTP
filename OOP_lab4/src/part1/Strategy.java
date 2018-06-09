package part1;


interface ITherapeuticStrategy {
    public void treatmentOfPatients(String symptoms);
}
class TraditionalMedicine implements ITherapeuticStrategy{
    public TraditionalMedicine(){

    }
    @Override
    public void treatmentOfPatients(String symptoms) {
        if (symptoms == "toothache")
            System.out.println("Traditional treatment: ibuklin");
        else if (symptoms == "headache")
            System.out.println("Traditional treatment: aspirin");
    }
}
class FolkMedicine implements  ITherapeuticStrategy{
    public FolkMedicine(){

    }
    @Override
    public void treatmentOfPatients(String symptoms) {
        if (symptoms == "toothache")
            System.out.println("Folk treatment: agave leaf");
        else if (symptoms == "headache")
            System.out.println("Folk treatment: Mint");
    }
}
class  ExtrasensoryMedicine implements ITherapeuticStrategy{
    public ExtrasensoryMedicine(){

    }
    @Override
    public void treatmentOfPatients(String symptoms) {
        if (symptoms == "toothache")
            System.out.println("Form the image of the body in the field of your mental vision. Thoroughly examine it. Inspect");
        else if (symptoms == "headache")
            System.out.println("Thoroughly examine head");
    }
}
 class Treatment{
    private ITherapeuticStrategy treatmentStrategy;
    public Treatment(){

    }
    public void SetTreatment(ITherapeuticStrategy strategy){
        treatmentStrategy = strategy;
    }
    public void Cure(String symptoms){
        treatmentStrategy.treatmentOfPatients(symptoms);
    }
}
