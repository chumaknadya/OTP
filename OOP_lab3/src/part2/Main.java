package part2;

public class Main {
    public static void main(String[] args) {
        ChessBoard board = ChessBoard.Instance();
        board.loadChessBoard();
        King king = (King)ChessBoard.getFigure("King");
        king.GetInfo();

    }
}
