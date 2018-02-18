import java.awt.event.*;
import javax.swing.*;

public class CellListener implements ActionListener{
    private boolean finished = false;
    private JButton[][] btns;

    public CellListener(JButton[][] btns){
        this.btns = btns;
    }

    public void actionPerformed(ActionEvent e){
        for(int r = 0; r < btns.length; r++){
            if(finished) break;
            for(int c = 0; c < btns[0].length; c++){
                if(e.getSource() == btns[r][c]){
                    Game.controller.safeClick(r, c);
                    finished = true;
                    break;
                }
            }
        }
        finished = false;
    }

}
