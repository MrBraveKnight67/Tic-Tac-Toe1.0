import java.util.Arrays;
import java.util.Random;

public class Board{
    private int emptyMarker;
    private int size;
    private int[][] cells;

    public Board(){
        size = Game.boardSize;
        emptyMarker = Game.emptyMarker;

        cells = new int[size][size];
        for(int i = 0; i < size; i++){
            Arrays.fill(cells[i], emptyMarker);
        }
    }

    public int getCell(int r, int c){
        return cells[r][c];
    }

    public void putX(int r, int c){
        if(cells[r][c] == emptyMarker){
            cells[r][c] = 1;
        }
    }

    public void putO(int r, int c){
        if(cells[r][c] == emptyMarker){
            cells[r][c] = 0;
        }
    }

    public boolean checkEmpty(int r, int c){
        if(cells[r][c] == emptyMarker){
            return true;
        }
        return false;
    }
    
    public boolean checkFull(){
        for(int[] v1 : cells){
            for(int v2 : v1){
                if(v2 != emptyMarker) return false;
            }
        }
        return true;
    }

    public int checkWinners(){
        int checkFor = cells[0][0];
        for(int i = 1; i < cells.length; i++){
            if(cells[i][i] != checkFor){
                break;
            }
            if(i == cells.length - 1){
                return checkFor;
            }
        }

        checkFor = cells[cells.length-1][0];
        for(int i = 1; i < cells.length; i++){
            if(cells[cells.length - i - 1][i] != checkFor){
                break;
            }
            if(i == cells.length - 1){
                return checkFor;
            }
        }

        for(int r = 0; r < cells.length; r++){
            checkFor = cells[r][0];
            for(int c = 0; c < cells.length; c++){
                if(cells[r][c] != checkFor){
                    break;
                }
                if(c == cells.length - 1){
                    return checkFor;
                }
            }
        }

        for(int c = 0; c < cells.length; c++){
            checkFor = cells[0][c];
            for(int r = 0; r < cells.length; r++){
                if(cells[r][c] != checkFor){
                    break;
                }
                if(r == cells.length - 1){
                    return checkFor;
                }
            }
        }

        return -1;
    }
}
