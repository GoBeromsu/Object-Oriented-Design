package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Game_resultPage extends JFrame {

    public Game_resultPage(String result){
        setResizable(false);
        setBounds(100, 100, 600, 480);

        if(result == "win"){
            Image win_img = null;
            try {
                win_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/Victory.png"))).getImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image win_tempimg = win_img.getScaledInstance(600,480,Image.SCALE_SMOOTH);
            JLabel win = new JLabel(new ImageIcon(win_tempimg));
            getContentPane().add(win);
            win.setVisible(true);
        }
        else if(result == "defeat"){
            Image defeat_img = null;
            try {
                defeat_img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/Defeat.png"))).getImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Image defeat_tempimg = defeat_img.getScaledInstance(600,480,Image.SCALE_SMOOTH);
            JLabel defeat = new JLabel(new ImageIcon(defeat_tempimg));
            getContentPane().add(defeat);
            defeat.setVisible(true);
        }
    }
}
