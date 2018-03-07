import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow{
    private JFrame gui = new JFrame("Tic-Tac-Toe 1.0");

    private JButton exit = new JButton("exit");
    private JButton restart = new JButton("restart");
    private JButton turn = new JButton("Player X's Turn (GREEN)");

    private CellListener cellListener;
    private JButton[][] btns;

    public GameWindow(int size){
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setSize(1000, 1000);
        gui.setLayout(new GridLayout(size + 1, size));

        btns = new JButton[size][size];
        cellListener = new CellListener(btns);
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                btns[r][c] = new JButton("");
                btns[r][c].addActionListener(cellListener);
                btns[r][c].setOpaque(true);
                btns[r][c].setBackground(Color.CYAN);
                gui.add(btns[r][c]);
            }
        }

        turn.setOpaque(true);
        turn.setBackground(Color.GREEN);
        exit.setOpaque(true);
        exit.setBackground(Color.CYAN);
        restart.setOpaque(true);
        restart.setBackground(Color.CYAN);
        addListeners();

        gui.add(exit);
        gui.add(restart);
        gui.add(turn);
        gui.setVisible(true);
    }

    private void addListeners(){
        exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Game.end(-1);
                }
            }
        );
        restart.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Game.end(-1);
                    Game.start();
                }
            }
        );
    }

    public void showTurn(boolean player1){
        if(player1){
            turn.setBackground(Color.GREEN);
            turn.setText("Player X's Turn (GREEN)");
        }else{
            turn.setBackground(Color.RED);
            turn.setText("Player O's Turn (RED)");
        }
    }

    public void showX(int r, int c){
        btns[r][c].setText("X");
        btns[r][c].setBackground(Color.GREEN);
    }

    public void showO(int r, int c){
        btns[r][c].setText("O");
        btns[r][c].setBackground(Color.RED);
    }
}