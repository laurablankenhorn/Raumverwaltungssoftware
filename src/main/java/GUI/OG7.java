package GUI;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class OG7 extends JPanel {
	
	
	public OG7 () {
		
		Icon icon;
		icon = new ImageIcon(getClass().getResource("7.OG.png"));
		setLayout(null);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(20, 0, 550, 550);
		lblNewLabel.setIcon(new ImageIcon("7.OG.png"));
		lblNewLabel.setIcon(icon);

		add(lblNewLabel);
	/*	
		btnM = new JButton("Einspieler");
		btnEinspieler.setBounds(50, 650, 300, 94);
		btnEinspieler.setFont(new Font("Dialog", 0, 50));
		
		btnNewButton_1.setBounds(440, 11, 89, 23);
		
		*/
		
		
		
		
	}
	
	
}
