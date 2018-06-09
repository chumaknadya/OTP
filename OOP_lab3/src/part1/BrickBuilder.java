package part1;

import java.util.Random;

public class BrickBuilder  extends Builder{
    private int MAX_NUMBERS_OF_FLOOR = 9;

    @Override
    public void SetGroundWork() {
        building.groundWork ="bearing";
    }

    @Override
    public void SetInternalWork() {
        building.typeOfWindows = "wooden";
        building.typeOfDoors = "wooden";
    }

    @Override
    public void SetRoofInstallation() {
        Random rnd = new Random();
        building.numberOfFloors = rnd.nextInt(MAX_NUMBERS_OF_FLOOR + 1);

    }

    @Override
    public void SetWallAndOverlap() {
        building.typeOfRoof="combined";
        building.materialOfRoof="metal-tile";
    }
}
