package pack1;

public abstract class ResidentalComponent {
    protected String name;
    protected int peopleNumber;
    // Constructor
    public ResidentalComponent(String name)
    {
        this.name = name;
    }
    public abstract void Add(ResidentalComponent c);
    public abstract void Remove(ResidentalComponent c);
    public abstract void Display(int depth);
    public abstract int GetPopulationInfo();
}
