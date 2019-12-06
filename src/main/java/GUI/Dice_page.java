package GUI;

import com.google.common.io.ByteStreams;
import lombok.Getter;
import java.awt.*;
import java.io.InputStream;
import javax.swing.*;

/**
 * 전투시 주사위를 굴릴수 있는 프레임이다
 */
public class Dice_page extends JFrame {
 @Getter
    private int savedDice_num;
    ImagePanel panel_dice_img;
    class ImagePanel extends JPanel{
        Image img_dice;
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img_dice, 0, 0, this);
        }
        public ImagePanel(){
            JLabel showDice;
            savedDice_num = select_Dicenum();
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(DiceImage(savedDice_num));
            try {
                img_dice = Toolkit.getDefaultToolkit().createImage(ByteStreams.toByteArray(is));
                MediaTracker mt = new MediaTracker(this);
                mt.addImage(img_dice, 0);
                mt.waitForAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Dice_page() {
        setBounds(100, 100, 550, 600);
        getContentPane().setLayout(null);
        setUndecorated(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width/2)-(getWidth()/2), (dim.height/2)-(getHeight()/2));
        System.out.println(savedDice_num);
        System.out.println(DiceImage(savedDice_num));
        panel_dice_img  = new ImagePanel();
        panel_dice_img.setBounds(14, 22, 500, 500);
        getContentPane().add(panel_dice_img);
    }

    public String DiceImage(int Dice_num) {
        setResizable(false);
        if (Dice_num == 1) {
            return "images/diceForRoll-export.gif";
        } else if (Dice_num == 2) {
            return "images/diceForRoll2-export.gif";
        } else if (Dice_num == 3) {
            return "images/diceForRoll3-export.gif";
        } else if (Dice_num == 4) {
            return "images/diceForRoll4-export.gif";
        } else if (Dice_num == 5) {
            return "images/diceForRoll5-export.gif";
        } else return "images/diceForRoll6-export.gif";

    }

    public int select_Dicenum() {
        double randomValue = Math.random();
        int intValue = (int) (randomValue * 6) + 1;
        return intValue;
    }

}
