package GUI;

import javax.swing.*;
import java.awt.*;

/** boss나 monster와의 전투를 나타내는 페이지이다.*/

public class Fight_boss_page extends JFrame {

	public static void main(String[] args) {
		Fight_boss_page frame = new Fight_boss_page();
		frame.setVisible(true);
	}


	public Fight_boss_page() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 960);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1182, 146);
		getContentPane().add(panel);
		

		JButton Exit = new JButton("exit");
		Exit.setBounds(986, 40, 144, 54);
		panel.add(Exit);
		
		JTextPane Turn = new JTextPane();
		Turn.setBounds(827, 40, 127, 38);
		panel.add(Turn);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(456, 506, 712, 395);
		getContentPane().add(textPane);
		
		JLabel player_health = new JLabel("player_health");
		player_health.setBounds(232, 706, 62, 18);
		getContentPane().add(player_health);
		
		JLabel metal = new JLabel("mental");
		metal.setBounds(232, 768, 62, 18);
		getContentPane().add(metal);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(308, 700, 134, 34);
		getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(308, 768, 134, 34);
		getContentPane().add(textPane_2);
		
		JLabel monster_img = new JLabel(new ImageIcon("src/imgaes/azatoth.png"));
		monster_img.setBounds(732, 214, 108, 92);
		getContentPane().add(monster_img);
		
		JLabel boss_name = new JLabel("Azartuth");
		boss_name.setFont(new Font("Yu Gothic", Font.PLAIN, 35));
		boss_name.setBounds(862, 219, 225, 41);
		getContentPane().add(boss_name);
		
		JLabel health = new JLabel("health");
		health.setBounds(862, 288, 62, 18);
		getContentPane().add(health);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(969, 288, 134, 34);
		getContentPane().add(textPane_3);
		
		
		Dice_page dice = new Dice_page();
		
		
		JLabel label = new JLabel(new ImageIcon("src/imgaes/player_name.png"));
		label.setBounds(32, 810, 162, 48);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel((new ImageIcon("src/imgaes/player.png")));
		label_1.setBounds(32, 627, 162, 159);
		getContentPane().add(label_1);
	}
}
