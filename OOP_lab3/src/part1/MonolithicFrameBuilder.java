package part1;

import java.util.Random;

public class MonolithicFrameBuilder extends Builder{
    @Override
    public void SetGroundWork() {
        building.groundWork = "combined";
    }

    @Override
    public void SetInternalWork() {
        building.typeOfWindows = "plactic";
        building.typeOfDoors = "wooden";
    }

    @Override
    public void SetRoofInstallation() {
        Random rnd = new Random();
        building.numberOfFloors = rnd.nextInt(50);
    }

    @Override
    public void SetWallAndOverlap() {
        building.typeOfRoof = "plane";
        building.materialOfRoof="metal-tile";
    }
}
