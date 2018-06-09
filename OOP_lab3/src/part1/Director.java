package part1;

public class Director {
    public Building Build(Builder builder){
        builder.CreateBuilding();
        builder.SetGroundWork();
        builder.SetInternalWork();
        builder.SetRoofInstallation();
        builder.SetWallAndOverlap();
        return builder.getBuilding();
    }
}
