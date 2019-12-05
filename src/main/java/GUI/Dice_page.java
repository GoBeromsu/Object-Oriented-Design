package GUI;

import lombok.Getter;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 전투시 주사위를 굴릴수 있는 프레임이다
 */
public class Dice_page extends JFrame {
 @Getter
    private int savedDice_num;
    String path;
    public Dice_page() {
        setBounds(100, 100, 550, 600);
        getContentPane().setLayout(null);
        setUndecorated(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width/2)-(getWidth()/2), (dim.height/2)-(getHeight()/2));

        path = "images/diceForRoll-export.gif";
        JLabel showDice = null;
        try {
            showDice = new JLabel(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        showDice.setBounds(14, 22, 500, 500);
        getContentPane().add(showDice);

        savedDice_num = select_Dicenum();
        System.out.println(savedDice_num);
        System.out.println("Dice_page select_Dicenum");
        try {
            showDice.setIcon(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(DiceImage(savedDice_num)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
