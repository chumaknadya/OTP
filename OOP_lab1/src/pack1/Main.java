package pack1;

import pack1.Composite;
import pack1.Flat;

public class Main {

    public static void main(String[] args) {

        //district is a root
        Composite district = new Composite("Livoberezna");
        //streets
        Composite street1 = new Composite("Ivana Mulolaychuka street");
        district.Add(street1);
        Composite street2 = new Composite("Entyziastiv street");
        district.Add(street2);
        //buildings
        Composite build1 = new Composite("build#10");
        Composite build2 = new Composite("build#12");
        Composite build3 = new Composite("build#5");
        street1.Add(build1);
        street1.Add(build2);
        street2.Add(build3);
        Composite entrance1 = new Composite("Entrance 1");
        Composite entrance2 = new Composite("Entrance 3");
        Composite entrance3 = new Composite("Entrance 1");
        build1.Add(entrance1);
        build2.Add(entrance2);
        build3.Add(entrance3);
        Flat fl1 = new Flat("flat #88");
        Flat fl2 = new Flat("flat #56");
        Flat fl3 = new Flat("flat #12");
        Flat fl4 = new Flat("flat #43");
        entrance1.Add(fl1);
        entrance2.Add(fl2);
        entrance2.Add(fl3);
        entrance3.Add(fl4);

        district.Display(2);
        System.out.println();
        System.out.println("Population of the district: "+ district.GetPopulationInfo());
    }
}
