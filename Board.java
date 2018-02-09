import java.util.Arrays;

public class Board{

    private int emptyMarker = -1;
    private int[][] cells;

    public Board(int boardSize){
        int[][] cells = new int[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            Arrays.fill(cells[i], emptyMarker);
        }
    }
    
    public int getCell(int r, int c){
        return cells[r][c];
    }

    public boolean putX(int r, int c){
        if(cells[r][c] == emptyMarker){
            cells[r][c] = 1;
            return true;
        }
        return false;
    }

    public boolean putO(int r, int c){
        if(cells[r][c] == emptyMarker){
            cells[r][c] = 0;
            return true;
        }
        return false;
    }

    public int checkWinners(){
        int checkFor = cells[0][0];
        int tempCtn = 0;
        
        for(int i = 1; i < cells.length; i++){
            if(cells[i][i] != checkFor){
                break;
            }
            tempCtn++;
        }
        
        if(tempCtn == cells.length){
            return checkFor;
        }
        tempCtn = 0;
        
        checkFor = cells[cells.length][0];
        for(int i = 1; i < cells.length; i++){
            if(cells[cells.length - i][i] != checkFor){
                break;
            }
            tempCtn++;
        }
        
        if(tempCtn == cells.length){
            return checkFor;
        }
        tempCtn = 0;

        for(int r = 0; r < cells.length; r++){
            checkFor = cells[r][0];
            for(int c = 0; c < cells.length; c++){
                if(cells[r][c] != checkFor){
                    break;
                }
            tempCtn++;
            }
        }
        
        if(tempCtn == cells.length){
            return checkFor;
        }
        tempCtn = 0;

        for(int c = 0; c < cells.length; c++){
            checkFor = cells[0][c];
            for(int r = 0; r < cells.length; r++){
                if(cells[r][c] != checkFor){
                    break;
                }
            tempCtn++;
            }
        }
        
        if(tempCtn == cells.length){
            return checkFor;
        }
        tempCtn = 0;
        
        return -1;
    }
}
