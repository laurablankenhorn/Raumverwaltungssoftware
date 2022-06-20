package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Startseite extends JPanel {

	public Startseite() {

		Icon icon;
		icon = new ImageIcon(getClass().getResource("DHBW.png"));
		setLayout(null);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(20, 0, 750, 650);
		lblNewLabel.setIcon(new ImageIcon("DHBW.png"));
		lblNewLabel.setIcon(icon);

		add(lblNewLabel);

		JLabel lblWillkommen = new JLabel("DHBW Heidenheim");
		lblWillkommen.setBounds(20, 20, 890, 60);
		lblWillkommen.setFont(new Font("Dialog", 0, 40));
		lblWillkommen.setBackground(Color.GRAY);
		lblWillkommen.setForeground(Color.BLACK);
		lblWillkommen.setOpaque(true);
		add(lblWillkommen);

		/*
		 * btnM = new JButton("Einspieler"); btnEinspieler.setBounds(50, 650, 300, 94);
		 * btnEinspieler.setFont(new Font("Dialog", 0, 50));
		 * 
		 * btnNewButton_1.setBounds(440, 11, 89, 23);
		 * 
		 */

	}

}
