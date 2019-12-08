package GUI;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

/**
 * 메인게임페이지에서 보이는 다이얼로그 창을 다루기 위한 클래스
 * @author Se-Ok Jeon, Beomsu Ko
 */
@Getter
@Setter
public class DialogPanel extends JPanel {


    Image dialog;

    {
        try {
            dialog = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/DIALOG-PANEL.PNG"))).getImage();
        } catch (IOException e) {
            dialog = null;
            e.printStackTrace();
        }
    }

    JLabel lb_just_text = new JLabel("Mac morning");
    JButton selectbtn3 = new JButton("",new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/SELECTOR.PNG"))));
    JButton selectbtn2 = new JButton("",new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/SELECTOR.PNG"))));
    JButton selectbtn1 = new JButton("",new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/SELECTOR.PNG"))));




    public DialogPanel() throws IOException {
      setLayout(null);
//        add(turnEnd);
//        setLayout(new GridLayout(4, 1, 0, 20));

        lb_just_text.setBounds(35, 32, 497, 90);
        selectbtn1.setBounds(84, 177, 401, 45);
        selectbtn2.setBounds(84, 248, 401, 45);
        selectbtn3.setBounds(84, 315, 401, 45);

        add(lb_just_text);
        add(selectbtn1);
        add(selectbtn2);
        add(selectbtn3);

    }
    /**
     * @author Se-Ok Jeon, Beomsu Ko
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(dialog, 0, 0, 569, 430, this);
    }

}
