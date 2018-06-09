package part2;

abstract class Repair
{
    public abstract void dismantlingWorks();
    public abstract void removalOfConstructionWaste();
    public abstract void replacementOfWindows();
    public abstract void layingOfElectricCables();
    public abstract void plasteringWorks();
    public abstract void floorPreparation();
    public abstract void doorInstallation();
    public abstract void finishingWorks();
    public void makeRepairs()
    {
        dismantlingWorks();
        removalOfConstructionWaste();
        replacementOfWindows();
        layingOfElectricCables();
        plasteringWorks();
        floorPreparation();
        doorInstallation();
        finishingWorks();
    }
}
class CheapRepair extends Repair{

    @Override
    public void dismantlingWorks() {
        System.out.println("--- removal of old wallpaper ---");
        System.out.println("--- installation of a simple floor ---");
    }

    @Override
    public void removalOfConstructionWaste() {
        System.out.println("--- took the rubbish ---");
    }

    @Override
    public void replacementOfWindows() {
        System.out.println("--- replacing windows is not required ---");
    }

    @Override
    public void layingOfElectricCables() {
        System.out.println("--- laying of electric cables ---");
    }

    @Override
    public void plasteringWorks() {
        System.out.println("--- leveling walls and ceiling ---");
    }

    @Override
    public void floorPreparation() {
        System.out.println("--- leveling the floor ---");
    }

    @Override
    public void doorInstallation() {
        System.out.println("--- installation of wood doors ---");
    }

    @Override
    public void finishingWorks() {
        System.out.println("--- decoration is not required ---");
    }
}
class MiddleRepair extends  Repair{

    @Override
    public void dismantlingWorks() {
        System.out.println("--- removal of old wallpaper ---");
        System.out.println("--- installation of a insulated floor ---");
    }

    @Override
    public void removalOfConstructionWaste() {
        System.out.println("--- took the rubbish ---");
    }

    @Override
    public void replacementOfWindows() {
        System.out.println("--- replacing windows is not required ---");
    }

    @Override
    public void layingOfElectricCables() {
        System.out.println("--- laying of electric cables ---");
    }

    @Override
    public void plasteringWorks() {
        System.out.println("--- leveling walls and ceiling ---");
    }

    @Override
    public void floorPreparation() {
        System.out.println("--- installation of warm floor ---");
    }

    @Override
    public void doorInstallation() {
       System.out.println("--- installation of aluminum doors ---");
    }

    @Override
    public void finishingWorks() {
        System.out.println("--- decoration is not required ---");
    }
}
class ExpensiveRepair extends Repair{

    @Override
    public void dismantlingWorks() {
        System.out.println("--- removal of old wallpaper ---");
        System.out.println("--- installation of a insulated floor ---");
    }

    @Override
    public void removalOfConstructionWaste() {
        System.out.println("--- took the rubbish ---");
    }

    @Override
    public void replacementOfWindows() {
        System.out.println("--- installation of plastic windows ---");
    }

    @Override
    public void layingOfElectricCables() {
        System.out.println("--- laying of electric cables ---");
    }

    @Override
    public void plasteringWorks() {
        System.out.println("--- leveling walls and ceiling ---");
    }

    @Override
    public void floorPreparation() {
        System.out.println("--- installation of warm floor ---");
    }

    @Override
    public void doorInstallation() {
      System.out.println("--- installation of metal doors ---");
    }

    @Override
    public void finishingWorks() {
        System.out.println("--- decoration  ---");
    }
}

