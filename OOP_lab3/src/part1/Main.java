package part1;

public class Main {
    public static void main(String[] args) {
        Builder panelBuilder = new PanelBuilder();
        Director dir = new Director();
        Building panelBuild =  dir.Build(panelBuilder);
        System.out.println(panelBuild.materialOfRoof);
        System.out.println(panelBuild.numberOfFloors);
    }
}
