package GUI;

import com.GameMaster;
import com.Mainmusic_thread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * New Game EXIT 2개의 버튼으로 게임 시작 및 종료를 담당하는 페이지이다.
 * @author Beomsu Ko
 */
public class Start_page extends JFrame {

    ImagePanel panel = new ImagePanel();
    Image img = new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResource("images/main_title.png"))).getImage();
    JButton newgame = new JButton(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResource("images/NewGame.png"))));
    JButton exitgame = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("images/EXIT.png")));

    public Start_page() throws IOException {

        setResizable(false);
        getContentPane().add(panel);
        panel.setLayout(null);
        setBounds(0, 0, 1200, 960);

        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameMaster.initiateGame();
                SetBoss_page test = null;
                try {
                    test = new SetBoss_page();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                test.setVisible(true);
                dispose();
            }
        });

        exitgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(newgame);
        panel.add(exitgame);

        newgame.setBounds(500, 480, 200, 70);
        exitgame.setBounds(500, 600, 200, 70);

        Mainmusic_thread music = new Mainmusic_thread(this.getClass().getClassLoader().getResourceAsStream("music/Main.mp3"), true);
        music.start();
    }




    static public void Start_pageView() throws IOException {
        Start_page frame = new Start_page();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * To paint background
     */
    class ImagePanel extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, 1200, 960, this);
        }
    }
}
