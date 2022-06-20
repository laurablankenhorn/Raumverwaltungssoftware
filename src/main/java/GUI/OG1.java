package GUI;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class OG1 extends JPanel {

	public OG1() {

		Icon icon;
		icon = new ImageIcon(getClass().getResource("1.OG.png"));
		setLayout(null);
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(20, 0, 550, 550);
		lblNewLabel.setIcon(new ImageIcon("1.OG.png"));
		lblNewLabel.setIcon(icon);

		add(lblNewLabel);

	}

}
