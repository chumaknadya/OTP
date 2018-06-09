package pack1;

import java.util.ArrayList;
import java.util.List;

public class Composite extends ResidentalComponent
{
    private List <ResidentalComponent> _children = new ArrayList<ResidentalComponent>();

    // Constructor
    public Composite(String name) {
        super(name);
        this.peopleNumber = 0;
    }

    @Override
    public  void Add(ResidentalComponent component)
    {
        _children.add(component);
    }
    @Override
    public void Remove(ResidentalComponent component) {
        _children.remove(component);
    }

    @Override
    public void Display(int depth) {
        for(int i = 0;i < depth; i++) {
            System.out.printf("-",i+1);
        }
        System.out.printf( name + ": "+ GetPopulationInfo()+"\n");
        for (ResidentalComponent component : _children)
            component.Display(depth + 2);
    }

    @Override
    public int GetPopulationInfo() {
        this.peopleNumber = 0;
        for (ResidentalComponent component : _children) {
            this.peopleNumber += component.GetPopulationInfo();
        }
        return this.peopleNumber;
    }
}
