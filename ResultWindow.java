import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResultWindow{
    private JFrame gui = new JFrame("Tic-Tac-Toe 1.0");
    private JButton exit = new JButton("exit");
    private JButton restart = new JButton("restart");
    private JButton label1;
    private JButton label2 = new JButton("Won!!!");
    
    public ResultWindow(int res){
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setSize(300, 300);
        gui.setLayout(new GridLayout(2, 2));
        
        if(res == 1){
            label1 = new JButton("Player X");
        }else if(res == 0){
            label1 = new JButton("Player O");
        }else if(res == -1){
            label1 = new JButton("The game");
            label2 = new JButton("was ended.");
        }
        label1.setOpaque(true);
        label1.setBackground(Color.WHITE);
        label2.setOpaque(true);
        label2.setBackground(Color.WHITE);
        
        exit.setOpaque(true);
        exit.setBackground(Color.CYAN);
        restart.setOpaque(true);
        restart.setBackground(Color.CYAN);
        addListeners();

        gui.add(label1);
        gui.add(label2);
        gui.add(exit);
        gui.add(restart);
        gui.setVisible(true);
    }

    private void addListeners(){
        exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            }
        );
        restart.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Game.start();
                }
            }
        );
    }
}