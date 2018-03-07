public class Game{
    static int boardSize = 5;
    static int emptyCellMarker = -1;
    static final int tiedLineMarker = boardSize+1;

    public static Board board;
    public static GameWindow gameW;
    public static StartWindow startW;
    public static Controller controller;
    public static ResultWindow resultW;

    public static int mode;

    public static void main(){
        startW = new StartWindow();
    }

    public static void start(){
        board = new Board();
        controller = new Controller();
        gameW = new GameWindow(boardSize);
    }

    public static void end(int res){
        resultW = new ResultWindow(res);
    }
}
