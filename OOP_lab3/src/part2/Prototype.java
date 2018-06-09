package part2;

import java.util.*;

abstract class  Figure implements Cloneable{
    String position;
    String name;
    String color;
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
    public abstract void GetInfo();
}
class ChessBoard{
    private static ChessBoard _chessBoardInstance = null;
    private static final Map<String, Figure> prototypes = new HashMap<>();
    private ChessBoard(){
    }
    public static ChessBoard Instance(){
        if (_chessBoardInstance == null) {
            _chessBoardInstance = new ChessBoard();
        }
        return _chessBoardInstance;
    }
    public static Figure getFigure(String type) {
        try {
            return (Figure) prototypes.get(type).clone();
        } catch (NullPointerException ex) {
            System.out.println("Prototype with name: " + type + ", doesn't exist");
            return null;
        }

    }
    public static  void loadChessBoard(){
        King king = new King("A4","King","white");
        Queen queen = new Queen("E2","Queen","black");
        prototypes.put("King",king);
        prototypes.put("Queen",queen);

    }
}
//King
class King extends Figure{

     public King(String pos,String nam,String col){
           position = pos;
           name = nam;
           color = col;
     }
     @Override
     public void GetInfo() {
         System.out.println("Position: "+position+" "+"Name: "+name+" "+"Color: "+color);
     }
}

//Horse
class Horse extends  Figure{
    public Horse(String pos,String nam,String col){
        position = pos;
        name = nam;
        color = col;
    }
    @Override
    public void GetInfo() {
        System.out.println("Position: "+position+" "+"Name: "+name+" "+"Color: "+color);
    }
}
//Pawn
class Pawn extends  Figure{
    public Pawn(String pos,String nam,String col){
        position = pos;
        name = nam;
        color = col;
    }
    @Override
    public void GetInfo() {
        System.out.println("Position: "+position+" "+"Name: "+name+" "+"Color: "+color);
    }
}
//Queen
class Queen extends Figure{
    public Queen(String pos,String nam,String col){
        position = pos;
        name = nam;
        color = col;
    }
    @Override
    public void GetInfo() {
        System.out.println("Position: "+position+" "+"Name: "+name+" "+"Color: "+color);
    }
}
//Elephant
class Elephant extends Figure{
    public Elephant(String pos,String nam,String col){
        position = pos;
        name = nam;
        color = col;
    }
    @Override
    public void GetInfo() {
        System.out.println("Position: "+position+" "+"Name: "+name+" "+"Color: "+color);
    }
}
//Rook
class Rook extends  Figure{
    public Rook(String pos,String nam,String col){
        position = pos;
        name = nam;
        color = col;
    }
    @Override
    public void GetInfo() {
        System.out.println("Position: "+position+" "+"Name: "+name+" "+"Color: "+color);
    }
}