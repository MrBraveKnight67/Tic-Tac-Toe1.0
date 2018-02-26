import java.util.Random;
import java.util.Arrays;

public class AI{

    public static void smartTurn(){
        int max[] = findMax().clone();
        Random rng = new Random();
        int n = rng.nextInt(Game.boardSize);
        if(max[0] == 0){
            int r = max[1];
            System.out.println("ROW;; // first: " + r + " // second: " + n);
            while(!Game.board.empty(r, n)){
                n = rng.nextInt(Game.boardSize);
            }
            Game.controller.safeClick(r, n);
        }else if(max[0] == 1){
            int c = max[1];
            System.out.println("COL;; // first: " + n + " // second: " + c);
            while(!Game.board.empty(n, c)){
                n = rng.nextInt(Game.boardSize);
            }
            Game.controller.safeClick(n, c);
        }else if(max[0] == 2){
            if(max[1] == 0){
                System.out.println("DIAG1;; // first: " + n + " // second: " + n);
                while(!Game.board.empty(n, n)){
                    n = rng.nextInt(Game.boardSize);
                }
                Game.controller.safeClick(n, n);
            }
            System.out.println("DIAG2;; // first: " + n + " // second: " + n);
            while(!Game.board.empty(n, Game.boardSize - n - 1)){
                n = rng.nextInt(Game.boardSize);
            }
            Game.controller.safeClick(n, Game.boardSize - n - 1);
        }else if(max[0] == -1){
            System.out.println("rdm");
            randomTurn();
        }
    }

    public static void randomTurn(){
        Random rng = new Random();
        int r = rng.nextInt(Game.boardSize);
        int c = rng.nextInt(Game.boardSize);
        while(!Game.board.empty(r, c)){
            r = rng.nextInt(Game.boardSize);
            c = rng.nextInt(Game.boardSize);
        }
        Game.controller.safeClick(r, c);
        findMax();
    }

    private static int[] findMax(){
        int tied = Game.tiedLineMarker;
        int[] maxRow, maxCol, maxDiag;
        /*
         * max__[0] = the line
         * and [1] = the value in the line
         */

        maxRow = new int[2];
        maxRow[0] = 0;
        for(int r = 0; r < Game.boardSize; r++){
            int temp = Math.abs(Game.board.rowTotal[r]);
            if(temp != tied && maxRow[1] < temp){
                maxRow[0] = r;
                maxRow[1] = temp;
            }
        }

        maxCol = new int[2];
        maxCol[0] = 0;
        for(int c = 0; c < Game.boardSize; c++){
            int temp = Math.abs(Game.board.colTotal[c]);
            if(temp != tied && maxCol[1] < temp){
                maxCol[0] = c;
                maxCol[1] = temp;
            }
        }

        maxDiag = new int[2];
        maxDiag[0] = 0;
        maxDiag[1] = Math.abs(Game.board.diagTotal[0]);
        if(maxDiag[1] == tied) maxDiag[1] = 0;
        int temp = Math.abs(Game.board.diagTotal[1]);
        if(temp != tied && maxCol[1] < temp){
            maxCol[0] = 1;
            maxCol[1] = temp;
        }
        
        System.out.println("===========in AI:");
        System.out.println(Arrays.toString(maxRow));
        System.out.println(Arrays.toString(maxCol));
        System.out.println(Arrays.toString(maxDiag));

        int max[] = new int[2];
        /*
         * max[0] = the type of line
         * max[1] = the line
         */
        int finalMaxV = Math.max(Math.max(maxRow[1], maxCol[1]), maxDiag[1]);
        if(finalMaxV == maxRow[1]){
            max[0] = 0;
            max[1] = maxRow[0];
        }else if(finalMaxV == maxCol[1]){
            max[0] = 1;
            max[1] = maxCol[0];
        }else if(finalMaxV == maxDiag[1]){
            max[0] = 2;
            max[1] = maxDiag[0];
        }else if(finalMaxV == 0){
            return new int[] {-1, 0};
        }
        return max;
    }
}
