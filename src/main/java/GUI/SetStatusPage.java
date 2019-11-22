package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 각각의 플레이어들의 초기 스탯 분배하는 페이지이다.
 */
public class SetStatusPage extends JFrame {


    SetStatusPage() {

        getContentPane().setLayout(null);
        setBounds(0, 0, 1200, 960);


        JPanel movetab = new JPanel();
        JButton next = new JButton("next");
        JButton prev = new JButton("prev");

        movetab.setBackground(Color.white);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MainGamePage next = new MainGamePage();
                next.setVisible(true);
                dispose();
            }
        });

        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SetBossPage prev = new SetBossPage();
                prev.setVisible(true);
                dispose();
            }
        });

        getContentPane().add(movetab);
        movetab.setLayout(null);
        movetab.setBounds(0, 0, 1182, 146);

        next.setBounds(935, 32, 180, 70);
        prev.setBounds(78, 32, 180, 70);

        movetab.add(next);
        movetab.add(prev);


        JLabel player_name = new JLabel(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\player_name.png"));
        player_name.setBounds(121, 566, 365, 155);
        getContentPane().add(player_name);

        JLabel player_img = new JLabel(new ImageIcon("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\player.png"));
        player_img.setBounds(128, 216, 358, 356);
        getContentPane().add(player_img);

        perstatus_set status_power = new perstatus_set("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\1.png");
        JPanel perstatus = new JPanel();
        perstatus.setBounds(592, 206, 590, 82);
        getContentPane().add(perstatus);
        perstatus.add(status_power);

        perstatus_set status_dex = new perstatus_set("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\2.png");
        JPanel perstatus_1 = new JPanel();
        perstatus_1.setBounds(592, 477, 590, 82);
        getContentPane().add(perstatus_1);
        perstatus_1.add(status_dex);

        perstatus_set status_intelligence = new perstatus_set("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\3.png");
        JPanel perstatus_2 = new JPanel();
        perstatus_2.setBounds(592, 345, 590, 82);
        getContentPane().add(perstatus_2);
        perstatus_2.add(status_intelligence);

        perstatus_set status_mental = new perstatus_set("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\4.png");
        JPanel perstatus_3 = new JPanel();
        perstatus_3.setBounds(592, 602, 590, 82);
        getContentPane().add(perstatus_3);
        perstatus_3.add(status_mental);

        perstatus_set statuts_health = new perstatus_set("C:\\Users\\182899\\Documents\\GitHub\\Object-Oriented-Design\\Object-Oriented-Design\\src\\main\\java\\GUI\\imgaes\\5.png");
        JPanel perstatus_4 = new JPanel();
        perstatus_4.setBounds(592, 728, 590, 82);
        getContentPane().add(perstatus_4);
        perstatus_4.add(statuts_health);


    }

    class perstatus_set extends JPanel {

        perstatus_set(String path) {
            JLabel status_name = new JLabel(new ImageIcon(path));
            JButton plus = new JButton("plus");
            JButton minus = new JButton("minus");

            add(status_name);
            add(plus);
            add(minus);

        }

    }


    public static void main(String[] args) {

        SetStatusPage frame = new SetStatusPage();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
