package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.ChangedCharSetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.DemoApplication;
import com.example.demo.RaumverwaltungsController;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class View extends JFrame {

	private JPanel contentPane;
	private Startseite start;
	private EG erdgeschoss;
	private OG1 obergeschoss1;
	private OG2 obergeschoss2;
	private OG3 obergeschoss3;
	private OG4 obergeschoss4;
	private OG5 obergeschoss5;
	private OG6 obergeschoss6;
	private OG7 obergeschoss7;

	private JPanel panel;
	private JPanel panelControl;
	private JPanel panelControl2;
	private JPanel eg;
	private JPanel og1;
	private JPanel og2;
	private JPanel og3;
	private JPanel og4;
	private JPanel og5;
	private JPanel og6;
	private JPanel og7;

	public Integer zs;
	
	@Autowired
	private RaumverwaltungsController raumverwaltungsController;
	
	

	
	public View() {

		zs = 100; // Anfangswert f�r zs um default case abzudecken

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setBounds(100, 100,900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		start = new Startseite();

		start.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		start.setPreferredSize(getPreferredSize());
		contentPane.add(start, BorderLayout.CENTER);

		contentPane.add(start);
		start.setLayout(null);

		panelControl = new JPanel();
		contentPane.add(panelControl, BorderLayout.SOUTH);

		// Erzeugen eines zweiten PanelControls rechts auf der Seite mit Hinzuf�gen
		// eines zur�ck-Buttons

		panelControl2 = new JPanel();
		contentPane.add(panelControl2, BorderLayout.EAST);
		JButton btnback = new JButton("zur�ck");
		panelControl2.add(btnback);
		

		// zur�ck-Button soll einen auf die Startseite zur�ck bringen

		btnback.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				switch (zs) {
				case 0:
					remove(eg);
					remove(erdgeschoss);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;

				case 1:
					remove(og1);
					remove(obergeschoss1);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;

				case 2:
					remove(og2);
					remove(obergeschoss2);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;
				case 3:
					remove(og3);
					remove(obergeschoss3);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;
				case 4:
					remove(og4);
					remove(obergeschoss4);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;

				case 5:
					remove(og5);
					remove(obergeschoss5);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;

				case 6:
					remove(og6);
					remove(obergeschoss6);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;

				case 7:
					remove(og7);
					remove(obergeschoss7);

					add(start, BorderLayout.CENTER);
					add(panelControl, BorderLayout.SOUTH);

					repaint();
					revalidate();
					break;

				default:
					dispose();

				}
				zs = 100; // nach Aktion wieder auf default setzen

			}
		});

// Einzelne Panels erstellt

		eg = new JPanel();
		og1 = new JPanel();
		og2 = new JPanel();
		og3 = new JPanel();
		og4 = new JPanel();
		og5 = new JPanel();
		og6 = new JPanel();
		og7 = new JPanel();

		// Buttons erstellt f�r Geschosse

		JButton btnNewButton_2 = new JButton("EG");

		panelControl.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("1.OG");

		panelControl.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("2.OG");

		panelControl.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("3.OG");

		panelControl.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("4.OG");

		panelControl.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("5.OG");
		btnNewButton_7.setBounds(440, 216, 89, 23);

		panelControl.add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("6.OG");

		panelControl.add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("7.OG");

		panelControl.add(btnNewButton_9);

		//////////////////

		// Bild f�r EG

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zs = 0;
				remove(start);
				remove(panelControl);
				contentPane.add(eg, BorderLayout.SOUTH);

				erdgeschoss = new EG();
				erdgeschoss.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				erdgeschoss.setPreferredSize(getPreferredSize());
				contentPane.add(erdgeschoss, BorderLayout.CENTER);

				contentPane.add(erdgeschoss);
				erdgeschoss.setLayout(null);

				/*
				 * panelControl = new JPanel(); contentPane.add(panelControl,
				 * BorderLayout.SOUTH);
				 */

				revalidate();
				repaint();

			}
		});

		// Raum-Buttons f�r 1.OG

		JButton btnM102 = new JButton("M102");
		og1.add(btnM102);
		
		

		JButton btnM105 = new JButton("M105");
		og1.add(btnM105);

		JButton btnM114 = new JButton("M114");
		og1.add(btnM114);

		JButton btnM115 = new JButton("M115");
		og1.add(btnM115);

		// Button f�r dass man ins 1.OG kommt so programmieren, dass sich das Bild
		// austauscht und die Raumbuttons hinzugef�gt werden

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zs = 1;

				remove(start);
				remove(panelControl);
				contentPane.add(og1, BorderLayout.SOUTH);

				obergeschoss1 = new OG1();
				obergeschoss1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				obergeschoss1.setPreferredSize(getPreferredSize());
				contentPane.add(obergeschoss1, BorderLayout.CENTER);

				contentPane.add(obergeschoss1);
				obergeschoss1.setLayout(null);

				/*
				 * panelControl = new JPanel(); contentPane.add(panelControl,
				 * BorderLayout.SOUTH);
				 */

				revalidate();
				repaint();

			}
		});

// Auf einen Raum-Button probeweise die Dropdownliste legen

		btnM102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen", "Belegungstabelle", "Inventar", "Kapazitaet" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was möchten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);
				
				if(Dropdown.equals("Raum belegen")) {
					raumverwaltungsController.changeBelegung("M102");
					
				}
				if(Dropdown.equals("Kapazitaet")) {
					raumverwaltungsController.showKapazitaet("M102");
					
				}
				
				
			}

		});

		///////////////////////////////////////////////////

		JButton btnM201 = new JButton("M201");
		og2.add(btnM201);

		JButton btnM202 = new JButton("M202");
		og2.add(btnM202);

		JButton btnM203 = new JButton("M203");
		og2.add(btnM203);

		JButton btnM204 = new JButton("M204");
		og2.add(btnM204);

		JButton btnM206 = new JButton("M206");
		og2.add(btnM206);

		JButton btnM207 = new JButton("M207");
		og2.add(btnM207);

		JButton btnM215 = new JButton("M215");
		og2.add(btnM215);

		JButton btnM216 = new JButton("M216");
		og2.add(btnM216);

		JButton btnM218 = new JButton("M218");
		og2.add(btnM218);

		JButton btnM219 = new JButton("M219");
		og2.add(btnM219);

		JButton btnM220 = new JButton("M220");
		og2.add(btnM220);

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zs = 2;

				remove(start);
				remove(panelControl);
				contentPane.add(og2, BorderLayout.SOUTH);

				obergeschoss2 = new OG2();
				obergeschoss2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				obergeschoss2.setPreferredSize(getPreferredSize());
				contentPane.add(obergeschoss2, BorderLayout.CENTER);

				contentPane.add(obergeschoss2);
				obergeschoss2.setLayout(null);

				revalidate();
				repaint();

			}
		});

		////////////////////////////////////////////////////////////////

		JButton btnM301 = new JButton("M301");
		og3.add(btnM301);

		JButton btnM303 = new JButton("M303");
		og3.add(btnM303);

		JButton btnM304 = new JButton("M304");
		og3.add(btnM304);

		JButton btnM305 = new JButton("M305");
		og3.add(btnM305);

		JButton btnM306 = new JButton("M306");
		og3.add(btnM306);

		JButton btnM315 = new JButton("M315");
		og3.add(btnM315);

		JButton btnM317 = new JButton("M317");
		og3.add(btnM317);

		JButton btnM318 = new JButton("M318");
		og3.add(btnM318);

		JButton btnM320 = new JButton("M320");
		og3.add(btnM320);

		JButton btnM321 = new JButton("M321");
		og3.add(btnM321);

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zs = 3;

				remove(start);
				remove(panelControl);
				contentPane.add(og3, BorderLayout.SOUTH);

				obergeschoss3 = new OG3();
				obergeschoss3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				obergeschoss3.setPreferredSize(getPreferredSize());
				contentPane.add(obergeschoss3, BorderLayout.CENTER);

				contentPane.add(obergeschoss3);
				obergeschoss3.setLayout(null);

				revalidate();
				repaint();

			}
		});

		////////////////////////////////

		JButton btnM401 = new JButton("M401");
		og4.add(btnM401);

		JButton btnM4021 = new JButton("M4021");
		og4.add(btnM4021);

		JButton btnM4022 = new JButton("M4022");
		og4.add(btnM4022);

		JButton btnM403 = new JButton("M403");
		og4.add(btnM403);

		JButton btnM414 = new JButton("M414");
		og4.add(btnM414);

		JButton btnM415 = new JButton("M415");
		og4.add(btnM415);

		JButton btnM416 = new JButton("M416");
		og4.add(btnM416);

		JButton btnM418 = new JButton("M418");
		og4.add(btnM418);

		JButton btnM419 = new JButton("M419");
		og4.add(btnM419);

		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zs = 4;

				remove(start);
				remove(panelControl);
				contentPane.add(og4, BorderLayout.SOUTH);

				obergeschoss4 = new OG4();
				obergeschoss4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				obergeschoss4.setPreferredSize(getPreferredSize());
				contentPane.add(obergeschoss4, BorderLayout.CENTER);

				contentPane.add(obergeschoss4);
				obergeschoss4.setLayout(null);

				revalidate();
				repaint();

			}
		});

		//////////////////////////////////////////////

		JButton btnM501 = new JButton("M501");
		og5.add(btnM501);

		JButton btnM503 = new JButton("M503");
		og5.add(btnM503);

		JButton btnM504 = new JButton("M504");
		og5.add(btnM504);

		JButton btnM505 = new JButton("M505");
		og5.add(btnM505);

		JButton btnM513 = new JButton("M513");
		og5.add(btnM513);

		JButton btnM514 = new JButton("M514");
		og5.add(btnM514);

		JButton btnM515 = new JButton("M515");
		og5.add(btnM515);

		JButton btnM516 = new JButton("M516");
		og5.add(btnM516);

		JButton btnM517 = new JButton("M517");
		og5.add(btnM517);

		JButton btnM518 = new JButton("M518");
		og5.add(btnM518);

		JButton btnM520 = new JButton("M520");
		og5.add(btnM520);

		JButton btnM521 = new JButton("M521");
		og5.add(btnM521);

		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zs = 5;

				remove(start);
				remove(panelControl);
				contentPane.add(og5, BorderLayout.SOUTH);

				obergeschoss5 = new OG5();
				obergeschoss5.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				obergeschoss5.setPreferredSize(getPreferredSize());
				contentPane.add(obergeschoss5, BorderLayout.CENTER);

				contentPane.add(obergeschoss5);
				obergeschoss5.setLayout(null);

				revalidate();
				repaint();

			}
		});

		///////////////////////////////////////////////////////////////////////

		JButton btnM601 = new JButton("M601");
		og6.add(btnM601);

		JButton btnM603 = new JButton("M603");
		og6.add(btnM603);

		JButton btnM604 = new JButton("M604");
		og6.add(btnM604);

		JButton btnM605 = new JButton("M605");
		og6.add(btnM605);

		JButton btnM610 = new JButton("M610");
		og6.add(btnM610);

		JButton btnM618 = new JButton("M618");
		og6.add(btnM618);

		JButton btnM619 = new JButton("M619");
		og6.add(btnM619);

		JButton btnM620 = new JButton("M620");
		og6.add(btnM620);

		JButton btnM622 = new JButton("M622");
		og6.add(btnM622);

		JButton btnM625 = new JButton("M625");
		og6.add(btnM625);

		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zs = 6;

				remove(start);
				remove(panelControl);
				contentPane.add(og6, BorderLayout.SOUTH);

				obergeschoss6 = new OG6();
				obergeschoss6.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				obergeschoss6.setPreferredSize(getPreferredSize());
				contentPane.add(obergeschoss6, BorderLayout.CENTER);

				contentPane.add(obergeschoss6);
				obergeschoss6.setLayout(null);

				revalidate();
				repaint();

			}
		});

		///////////////////////////////////////////////////////////

		JButton btnM703 = new JButton("M703");
		og7.add(btnM703);

		JButton btnM704 = new JButton("M704");
		og7.add(btnM704);

		JButton btnM709 = new JButton("M709");
		og7.add(btnM709);

		JButton btnM730 = new JButton("M730");
		og7.add(btnM730);

		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				zs = 7;

				remove(start);
				remove(panelControl);
				contentPane.add(og7, BorderLayout.SOUTH);

				obergeschoss7 = new OG7();
				obergeschoss7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				obergeschoss7.setPreferredSize(getPreferredSize());
				contentPane.add(obergeschoss7, BorderLayout.CENTER);

				contentPane.add(obergeschoss7);
				obergeschoss7.setLayout(null);

				revalidate();
				repaint();

			}
		});

		panel = new JPanel();
		pack();
	}

}
