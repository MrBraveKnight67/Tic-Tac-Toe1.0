import java.util.Random;

public class Controller{
    private boolean player1;
    private boolean wait;
    private boolean finished;

    public Controller(){
        player1 = true;
        wait = true;
        finished = false;
    }

    public boolean safeClick(int r, int c){
        if(Game.board.full()){
            Game.end(Game.board.checkWinners());
        }else if (Game.board.empty(r, c)){
            click(r, c);
            int winner = Game.board.checkWinners();
            if(winner != -1){
                Game.end(winner);
            }else{
                player1 = !player1;
                Game.gameW.showTurn(player1);
                if(Game.mode == 1 && !player1){
                    AI.smartTurn();
                }
            }
            return true;
        }
        return false;
    }

    public void click(int r, int c){
        if(player1){
            Game.board.recordX(r, c);
            Game.gameW.showX(r, c);
        }else{
            Game.board.recordO(r, c);
            Game.gameW.showO(r, c);
        }
    }
}
