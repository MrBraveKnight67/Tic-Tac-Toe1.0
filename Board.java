import java.util.Arrays;
import java.util.Random;

public class Board{
    private int emptyMarker;
    private int tiedLineMarker;
    private int size;
    private int[][] cells;
    public int[] rowTotal, colTotal, diagTotal;

    public Board(){
        size = Game.boardSize;
        emptyMarker = Game.emptyCellMarker;
        tiedLineMarker = Game.tiedLineMarker;

        cells = new int[size][size];
        for(int i = 0; i < size; i++){
            Arrays.fill(cells[i], emptyMarker);
        }

        rowTotal = new int[size];
        colTotal = new int[size];
        diagTotal = new int[2];
    }

    public void recordX(int r, int c){
        cells[r][c] = 1;
        if(rowTotal[r] != tiedLineMarker){
            if(rowTotal[r] < 0){
                rowTotal[r] = tiedLineMarker;
            }else{
                rowTotal[r]++;
            }
        }
        if(colTotal[c] != tiedLineMarker){
            if(colTotal[c] < 0){
                colTotal[c] = tiedLineMarker;
            }else{
                colTotal[c]++;
            }
        }
        if(r == c && diagTotal[0] != tiedLineMarker){
            if(diagTotal[0] < 0){
                diagTotal[0] = tiedLineMarker;
            }else{
                diagTotal[0]++;
            }
        }
        if(r == Game.boardSize - c - 1 && diagTotal[1] != tiedLineMarker){
            if(diagTotal[1] < 0){
                diagTotal[1] = tiedLineMarker;
            }else{
                diagTotal[1]++;
            }
        }
    }

    public void recordO(int r, int c){
        cells[r][c] = 0;
        if(rowTotal[r] != tiedLineMarker){
            if(rowTotal[r] > 0){
                rowTotal[r] = tiedLineMarker;
            }else{
                rowTotal[r]--;
            }
        }
        if(colTotal[c] != tiedLineMarker){
            if(colTotal[c] > 0){
                colTotal[c] = tiedLineMarker;
            }else{
                colTotal[c]--;
            }
        }
        if(r == c && diagTotal[0] != tiedLineMarker){
            if(diagTotal[0] > 0){
                diagTotal[0] = tiedLineMarker;
            }else{
                diagTotal[0]--;
            }
        }
        if(r == Game.boardSize - c - 1 && diagTotal[1] != tiedLineMarker){
            if(diagTotal[1] > 0){
                diagTotal[1] = tiedLineMarker;
            }else{
                diagTotal[1]--;
            }
        }
    }

    public boolean empty(int r, int c){
        if(cells[r][c] == emptyMarker){
            return true;
        }
        return false;
    }

    public boolean full(){
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                if(empty(r, c)) return false;
            }
        }
        return true;
    }
    
    public int checkWinners(){
        for(int n : rowTotal){
            if(n == size) return 1;
            if(n == -size) return 0;
        }
        for(int n : colTotal){
            if(n == size) return 1;
            if(n == -size) return 0;
        }
        for(int n : diagTotal){
            if(n == size) return 1;
            if(n == -size) return 0;
        }
        if(full()){
            return 3;
        }
        return -1;
    }
}
