import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartWindow{
    private JFrame gui = new JFrame("Tic-Tac-Toe 1.0");
    private JButton single = new JButton("Singleplayer");
    private JButton multi = new JButton("Multiplayer");
    private JButton label1 = new JButton("Welcome to... ");
    private JButton label2 = new JButton("Tic-Tac-Toe (v1.0)!");

    public StartWindow(){
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setSize(300, 300);
        gui.setLayout(new GridLayout(2, 2));

        single.setOpaque(true);
        single.setBackground(Color.CYAN);
        multi.setOpaque(true);
        multi.setBackground(Color.CYAN);
        
        label1.setOpaque(true);
        label1.setBackground(Color.WHITE);
        label2.setOpaque(true);
        label2.setBackground(Color.WHITE);

        single.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Game.mode = 1;
                    Game.start();
                }
            }
        );
        multi.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Game.mode = 2;
                    Game.start();
                }
            }
        );
        
        gui.add(label1);
        gui.add(label2);
        gui.add(single);
        gui.add(multi);
        gui.setVisible(true);
    }
}