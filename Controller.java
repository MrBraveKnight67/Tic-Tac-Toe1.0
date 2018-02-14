import java.util.Random;

public class Controller{
    private boolean player1;
    private boolean wait;
    private boolean finished;
    private boolean okClick;

    public Controller(){
        player1 = true;
        wait = true;
        finished = false;
        okClick = true;
    }

    public void click(int r, int c){
        okClick = (Game.board.getCell(r, c) == Game.emptyMarker);
        if(finished){
            Game.end(-1);
        }
        if(okClick && !finished){
            if(player1){
                Game.board.putX(r, c);
                Game.gameW.showX(r, c);
            }else{
                Game.board.putO(r, c);
                Game.gameW.showO(r, c);
            }
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

    public void aiClick(){
        if(finished){
            Game.end(Game.board.checkWinners());
        }else if(okClick){
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
            wait = false;

            int winner = Game.board.checkWinners();
            if(winner == 1){
                finished = true;
                Game.end(1);
            }else if(winner == 0){
                finished = true;
                Game.end(0);
            }else{
                player1 = true;
                Game.gameW.showTurn(player1);
            }
        }
    }
}
