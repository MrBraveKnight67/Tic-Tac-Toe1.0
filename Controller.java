import java.util.Random;

public class Controller{
    private boolean player1;
    private boolean wait;

    public Controller(){
        player1 = true;
        wait = true;
    }

    public void click(int r, int c){
        if(player1){
            Game.board.putX(r, c);
            Game.gameW.showX(r, c);
        }else{
            Game.board.putO(r, c);
            Game.gameW.showO(r, c);
        }
        int winner = Game.board.checkWinners();
        if(winner == 1){
            Game.end(1);
        }else if(winner == 0){
            Game.end(0);
        }else{
            player1 = !player1;
            Game.gameW.showTurn(player1);
        }
    }

    public void aiClick(){
        wait = true;
        Random rng = new Random();
        int r = rng.nextInt(Game.boardSize);
        int c = rng.nextInt(Game.boardSize);
        while(!Game.board.checkEmpty(r, c)){
            r = rng.nextInt(Game.boardSize);
            c = rng.nextInt(Game.boardSize);
        }
        Game.board.putO(r, c);
        Game.gameW.showO(r, c);
        player1 = true;
        wait = false;
        Game.gameW.showTurn(player1);
    }
}
