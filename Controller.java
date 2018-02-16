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

    public void safeClick(int r, int c){
        if(Game.board.full()){
            Game.end(Game.board.checkWinners());
        }else{
            click(r, c);
            int winner = Game.board.checkWinners();
            if(winner == 1){
                finished = true;
                Game.end(1);
            }else if(winner == 0){
                finished = true;
                Game.end(0);
            }else{
                player1 = !player1;
                Game.gameW.showTurn(player1);
            }
        }
    }

    public void safeClick(){
        wait = true;
        if(Game.board.full()){
            Game.end(Game.board.checkWinners());
        }else{
            aiClick();
            int winner = Game.board.checkWinners();
            if(winner == 1){
                finished = true;
                Game.end(1);
            }else if(winner == 0){
                finished = true;
                Game.end(0);
            }else{
                player1 = !player1;
                Game.gameW.showTurn(player1);
            }
        }
        wait = false;
    }

    public void click(int r, int c){
        if(player1){
            Game.board.putX(r, c);
            Game.gameW.showX(r, c);
        }else{
            Game.board.putO(r, c);
            Game.gameW.showO(r, c);
        }
    }

    public void aiClick(){
        Random rng = new Random();
        int r = rng.nextInt(Game.boardSize);
        int c = rng.nextInt(Game.boardSize);
        while(!Game.board.empty(r, c)){
            r = rng.nextInt(Game.boardSize);
            c = rng.nextInt(Game.boardSize);
        }
        Game.board.putO(r, c);
        Game.gameW.showO(r, c);
    }
}
