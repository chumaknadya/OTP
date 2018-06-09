package part1;

public abstract class Builder {
    public Building building;
    public void CreateBuilding(){
        building = new Building();
    }
    public abstract void SetGroundWork();
    public abstract  void SetInternalWork();
    public  abstract void SetRoofInstallation();
    public abstract void SetWallAndOverlap();

    public Building getBuilding() {
        return building;
    }
}
