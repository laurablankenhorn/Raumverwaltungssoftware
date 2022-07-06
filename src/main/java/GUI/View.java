package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.example.demo.RaumverwaltungsController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

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

	// fuer GridBag Layout
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;
	private JPanel bcontentPane;

	@Autowired
	private RaumverwaltungsController raumverwaltungsController;

	public View() {

		zs = 100; // Random Anfangswert fuer zs um default case abzudecken

// Erzeugen eines JFrames mit JLabel und JPanels

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

		panelControl2 = new JPanel();
		contentPane.add(panelControl2, BorderLayout.EAST);
		JButton btnback = new JButton("zur\u00fcck");
		panelControl2.add(btnback);

// zurueck-Button soll einen aus jedem Stockwerk auf die Startseite zurueck bringen

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

// Einzelne Panels erstellt für die unterschiedlichen Stockwerke, die spaeter die neuen Buttons enthalten sollen

		eg = new JPanel();
		og1 = new JPanel();
		og2 = new JPanel();
		og3 = new JPanel();
		og4 = new JPanel();
		og5 = new JPanel();
		og6 = new JPanel();
		og7 = new JPanel();

// Buttons erstellt fuer Geschosse

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

// Erscheinen des EG-Bildgrundrisses bei Buttonklick auf "EG"

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

				revalidate();
				repaint();

			}
		});

///////////////////STOCKWERK 1//////////////////////////////////////		

// Raum-Buttons fuer 1.OG

		JButton btnM102 = new JButton("M102");
		og1.add(btnM102);

		JButton btnM105 = new JButton("M105");
		og1.add(btnM105);

		JButton btnM114 = new JButton("M114");
		og1.add(btnM114);

		JButton btnM115 = new JButton("M115");
		og1.add(btnM115);

// Button fuer 1.OG (Bild tauscht sich aus und Raumbuttons werden hinzugefuegt)

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

//---------------------------------------------------------------------------------------------------			
// Jedes Mal, wenn der Button fuer ein Stockwerk geklickt wird, wird geprueft welcher Belegungszustand bei den zugehoerigen Raeumen aktuell ist				
// je nachdem, ob er frei oder belegt ist, wird die Buttonfarbe danach angepasst

				if (raumverwaltungsController.showBelegung("M102").equals("t")) {
					btnM102.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM102.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M105").equals("t")) {
					btnM105.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM105.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M114").equals("t")) {
					btnM114.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM114.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M115").equals("t")) {
					btnM115.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM115.setBackground(Color.RED);
					repaint();
				}
//--------------------------------------------------------------------------------------

				revalidate();
				repaint();

			}
		});

// Auf die Raumbuttons werden alle zugehoerigen Methoden gelegt

		btnM102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M102");

// Belegungszustand wird geprueft, geandert und neu geladen -> Farbwechsel bei Buttonklick 

					if (raumverwaltungsController.showBelegung("M102").equals("t")) {
						btnM102.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM102.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M102");

				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M102");
				}

// Erstellen der Belegungstabelle				

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M102",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM105.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M105");

					// Belegungszustand wird geÃ¤ndert geprÃ¼ft und neu geladen

					if (raumverwaltungsController.showBelegung("M105").equals("t")) {
						btnM105.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM105.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M105");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M105");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M105",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM114.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M114");

					// Belegungszustand wird geÃ¤ndert geprÃ¼ft und neu geladen

					if (raumverwaltungsController.showBelegung("M114").equals("t")) {
						btnM114.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM114.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M114");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M114");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M114",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM115.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen")) {
					raumverwaltungsController.changeBelegung("M115");

					// Belegungszustand wird geÃ¤ndert geprÃ¼ft und neu geladen

					if (raumverwaltungsController.showBelegung("M115").equals("t")) {
						btnM115.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM115.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M115");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M115");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M115",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

// !!!ab jetzt ist alles analog zum 1.OG bezüglich der Vorgehensweise!!! 		

/////////////////////////STOCKWERK 2////////////////////////////////////////////////////////////////////////////

// Button fuer 2.OG (Bild tauscht sich aus und Raumbuttons werden hinzugefuegt)		

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

				// ------------------------------------
				if (raumverwaltungsController.showBelegung("M201").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM201.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM201.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M202").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM202.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM202.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M203").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM203.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM203.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M204").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM204.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM204.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M206").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM206.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM206.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M207").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM207.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM207.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M215").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM215.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM215.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M216").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM216.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM216.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M218").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM218.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM218.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M219").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM219.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM219.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M220").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM220.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM220.setBackground(Color.RED);
					repaint();
				}

				// -----------------------------------------------------------------------------

				revalidate();
				repaint();

			}
		});

		btnM201.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M201");

					if (raumverwaltungsController.showBelegung("M201").equals("t")) {
						btnM201.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM201.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M201");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M201");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M201",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM202.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M202");

					if (raumverwaltungsController.showBelegung("M202").equals("t")) {
						btnM202.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM202.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M202");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M202");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M202",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM203.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M203");

					if (raumverwaltungsController.showBelegung("M203").equals("t")) {
						btnM203.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM203.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M203");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M203");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M203",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM204.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M204");

					if (raumverwaltungsController.showBelegung("M204").equals("t")) {
						btnM204.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM204.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M204");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M204");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M204",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM206.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M206");

					if (raumverwaltungsController.showBelegung("M206").equals("t")) {
						btnM206.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM206.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M206");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M206");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M206",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM207.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M207");

					if (raumverwaltungsController.showBelegung("M207").equals("t")) {
						btnM207.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM207.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M207");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M207");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M207",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM215.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M215");

					if (raumverwaltungsController.showBelegung("M215").equals("t")) {
						btnM215.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM215.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M215");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M215");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M215",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM216.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M216");

					if (raumverwaltungsController.showBelegung("M216").equals("t")) {
						btnM216.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM216.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M216");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M216");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M216",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}
			}

		});

		btnM218.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M218");

					if (raumverwaltungsController.showBelegung("M218").equals("t")) {
						btnM218.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM218.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M218");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M218");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M218",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM219.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M219");

					if (raumverwaltungsController.showBelegung("M219").equals("t")) {
						btnM219.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM219.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M219");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M219");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M219",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM220.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M220");

					if (raumverwaltungsController.showBelegung("M220").equals("t")) {
						btnM220.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM220.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M220");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M220");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M220",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

////////////////////////STOCKWERK 3//////////////////////////////////////////////////

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

//----------------------------------------------------------------------------------------------------

				if (raumverwaltungsController.showBelegung("M301").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM301.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM301.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M303").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM303.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM303.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M304").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM304.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM304.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M305").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM305.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM305.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M306").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM306.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM306.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M315").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM315.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM315.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M317").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM317.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM317.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M318").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM318.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM318.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M320").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM320.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM320.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M321").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM321.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM321.setBackground(Color.RED);
					repaint();
				}

//------------------------------------------------------------------------------------------

				revalidate();
				repaint();

			}
		});

		btnM301.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M301");

					if (raumverwaltungsController.showBelegung("M301").equals("t")) {
						btnM301.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM301.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M301");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M301");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M301",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM303.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M303");

					if (raumverwaltungsController.showBelegung("M303").equals("t")) {
						btnM303.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM303.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M303");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M303");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M303",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM304.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M304");

					if (raumverwaltungsController.showBelegung("M304").equals("t")) {
						btnM304.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM304.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M304");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M304");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M304",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM305.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M305");

					if (raumverwaltungsController.showBelegung("M305").equals("t")) {
						btnM305.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM305.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M305");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M305");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M305",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM306.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M306");

					if (raumverwaltungsController.showBelegung("M306").equals("t")) {
						btnM306.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM306.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M306");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M306");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M306",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM315.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M315");

					if (raumverwaltungsController.showBelegung("M315").equals("t")) {
						btnM315.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM315.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M315");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M315");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M315",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM317.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M317");

					if (raumverwaltungsController.showBelegung("M317").equals("t")) {
						btnM317.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM317.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M317");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M317");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M317",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM318.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M318");

					if (raumverwaltungsController.showBelegung("M318").equals("t")) {
						btnM318.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM318.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M318");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M318");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M318",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}
			}

		});

		btnM320.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M320");

					if (raumverwaltungsController.showBelegung("M320").equals("t")) {
						btnM320.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM320.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M320");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M320");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M320",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}
			}

		});

		btnM321.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M321");

					if (raumverwaltungsController.showBelegung("M321").equals("t")) {
						btnM321.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM321.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M321");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M321");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M321",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

//////////////////////////STOCKWERK 4/////////////////////////////////////////////////////////////////

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

//--------------------------------------------------------------------------

				if (raumverwaltungsController.showBelegung("M401").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM401.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM401.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M4021").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM4021.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM4021.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M4022").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM4022.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM4022.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M403").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM403.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM403.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M414").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM414.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM414.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M415").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM415.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM415.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M416").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM416.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM416.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M418").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM418.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM418.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M419").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM419.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM419.setBackground(Color.RED);
					repaint();
				}

//-----------------------------------------------------------------------------------				

				revalidate();
				repaint();

			}
		});

		btnM401.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M401");

					if (raumverwaltungsController.showBelegung("M401").equals("t")) {
						btnM401.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM401.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M401");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M401");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M401",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM4021.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M4021");

					if (raumverwaltungsController.showBelegung("M4021").equals("t")) {
						btnM4021.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM4021.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M4021");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M4021");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M4021",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM4022.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M4022");

					if (raumverwaltungsController.showBelegung("M4022").equals("t")) {
						btnM4022.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM4022.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M4022");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M4022");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M4022",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM403.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M403");

					if (raumverwaltungsController.showBelegung("M403").equals("t")) {
						btnM403.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM403.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M403");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M403");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M403",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM414.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M414");

					if (raumverwaltungsController.showBelegung("M414").equals("t")) {
						btnM414.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM414.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M414");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M414");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M414",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM415.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M415");

					if (raumverwaltungsController.showBelegung("M415").equals("t")) {
						btnM415.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM415.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M415");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M415");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M415",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM416.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M416");

					if (raumverwaltungsController.showBelegung("M416").equals("t")) {
						btnM416.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM416.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M416");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M416");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M416",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM418.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M418");

					if (raumverwaltungsController.showBelegung("M418").equals("t")) {
						btnM418.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM418.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M418");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M418");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M418",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM419.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M419");

					if (raumverwaltungsController.showBelegung("M419").equals("t")) {
						btnM419.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM419.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M419");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M419");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M419",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

//////////////////////STOCKWERK 5//////////////////////////////////////////////////////////////////////

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

//-----------------------------------------------------------

				if (raumverwaltungsController.showBelegung("M501").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM501.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM501.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M503").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM503.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM503.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M504").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM504.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM504.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M505").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM505.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM505.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M513").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM513.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM513.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M514").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM514.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM514.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M515").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM515.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM515.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M516").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM516.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM516.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M517").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM517.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM517.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M518").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM518.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM518.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M520").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM520.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM520.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M521").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM521.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM521.setBackground(Color.RED);
					repaint();
				}

//----------------------------------------------------------------------------------------				

				revalidate();
				repaint();

			}
		});

		btnM501.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M501");

					if (raumverwaltungsController.showBelegung("M501").equals("t")) {
						btnM501.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM501.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M501");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M501");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M501",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM503.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M503");

					if (raumverwaltungsController.showBelegung("M503").equals("t")) {
						btnM503.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM503.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M503");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M503");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M503",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM504.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M504");

					if (raumverwaltungsController.showBelegung("M504").equals("t")) {
						btnM504.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM504.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M504");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M504");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M504",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM505.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M505");

					if (raumverwaltungsController.showBelegung("M505").equals("t")) {
						btnM505.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM505.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M505");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M505");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M505",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM513.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M513");

					if (raumverwaltungsController.showBelegung("M513").equals("t")) {
						btnM513.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM513.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M513");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M513");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M513",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM514.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M514");

					if (raumverwaltungsController.showBelegung("M514").equals("t")) {
						btnM514.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM514.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M514");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M514");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M514",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM515.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M515");

					if (raumverwaltungsController.showBelegung("M515").equals("t")) {
						btnM515.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM515.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M515");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M515");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M515",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM516.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M516");

					if (raumverwaltungsController.showBelegung("M516").equals("t")) {
						btnM516.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM516.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M516");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M516");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M516",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM517.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M517");

					if (raumverwaltungsController.showBelegung("M517").equals("t")) {
						btnM517.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM517.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M517");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M517");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M517",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM518.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M518");

					if (raumverwaltungsController.showBelegung("M518").equals("t")) {
						btnM518.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM518.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M518");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M518");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M518",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM520.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M520");

					if (raumverwaltungsController.showBelegung("M520").equals("t")) {
						btnM520.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM520.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M520");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M520");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M520",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM521.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M521");

					if (raumverwaltungsController.showBelegung("M521").equals("t")) {
						btnM521.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM521.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M521");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M521");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M521",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

//////////////////////////STOCKWERK 6//////////////////////////////////////////////////////////////

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

//-----------------------------------------------------------------------

				if (raumverwaltungsController.showBelegung("M601").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM601.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM601.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M603").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM603.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM603.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M604").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM604.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM604.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M605").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM605.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM605.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M610").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM610.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM610.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M618").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM618.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM618.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M619").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM619.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM619.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M620").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM620.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM620.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M622").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM622.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM622.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M625").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM625.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM625.setBackground(Color.RED);
					repaint();
				}

//---------------------------------------------------------------------------------------------------				

				revalidate();
				repaint();

			}
		});

		btnM601.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M601");

					if (raumverwaltungsController.showBelegung("M601").equals("t")) {
						btnM601.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM601.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M601");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M601");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M601",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM603.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M603");

					if (raumverwaltungsController.showBelegung("M603").equals("t")) {
						btnM603.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM603.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M603");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M603");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M603",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM604.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M604");

					if (raumverwaltungsController.showBelegung("M604").equals("t")) {
						btnM604.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM604.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M604");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M604");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M604",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM605.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M605");

					if (raumverwaltungsController.showBelegung("M605").equals("t")) {
						btnM605.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM605.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M605");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M605");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M605",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM610.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M610");

					if (raumverwaltungsController.showBelegung("M610").equals("t")) {
						btnM610.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM610.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M610");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M610");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M610",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM618.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M618");

					if (raumverwaltungsController.showBelegung("M618").equals("t")) {
						btnM618.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM618.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M618");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M618");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M618",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM619.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M619");

					if (raumverwaltungsController.showBelegung("M619").equals("t")) {
						btnM619.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM619.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M619");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M619");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M619",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM620.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M620");

					if (raumverwaltungsController.showBelegung("M620").equals("t")) {
						btnM620.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM620.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M620");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M620");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M620",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM622.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M622");

					if (raumverwaltungsController.showBelegung("M622").equals("t")) {
						btnM622.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM622.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M622");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M622");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M622",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM625.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M625");

					if (raumverwaltungsController.showBelegung("M625").equals("t")) {
						btnM625.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM625.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M625");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M625");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M625",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

//////////////////////////////STOCKWERK 7//////////////////////////////////////////////////

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

//---------------------------------------------------------------------------------------

				if (raumverwaltungsController.showBelegung("M703").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM703.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM703.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M704").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM704.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM704.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M709").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM709.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM709.setBackground(Color.RED);
					repaint();
				}

				if (raumverwaltungsController.showBelegung("M730").equals("t")) { // je nach dewm wird Buttonfarbe
																					// angepasst
					btnM730.setBackground(Color.GREEN);
					repaint();
				} else {
					btnM730.setBackground(Color.RED);
					repaint();
				}

//-------------------------------------------------------------------------------------------------				

				revalidate();
				repaint();

			}
		});

		btnM703.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M703");

					if (raumverwaltungsController.showBelegung("M703").equals("t")) {
						btnM703.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM703.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M703");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M703");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M703",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM704.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M704");

					if (raumverwaltungsController.showBelegung("M704").equals("t")) {
						btnM704.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM704.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M704");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M704");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M704",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM709.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M709");

					if (raumverwaltungsController.showBelegung("M709").equals("t")) {
						btnM709.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM709.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M709");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M709");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M709",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

		btnM730.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] optionsToChoose = { "Raum belegen/freigeben", "Belegungstabelle", "Inventar",
						"Kapazit\u00e4t" };

				String Dropdown = (String) JOptionPane.showInputDialog(null, "Was m\u00f6chten Sie tun", "Dropdown",
						JOptionPane.QUESTION_MESSAGE, null, optionsToChoose, optionsToChoose[3]);

				if (Dropdown.equals("Raum belegen/freigeben")) {
					raumverwaltungsController.changeBelegung("M730");

					if (raumverwaltungsController.showBelegung("M730").equals("t")) {
						btnM730.setBackground(Color.GREEN);
						repaint();
					} else {

						btnM730.setBackground(Color.RED);
						repaint();
					}

				}

				if (Dropdown.equals("Kapazit\u00e4t")) {
					raumverwaltungsController.showKapazitaet("M730");
				}

				if (Dropdown.equals("Inventar")) {
					raumverwaltungsController.showInventar("M730");
				}

				if (Dropdown.equals("Belegungstabelle")) {
					SqlRowSet rs = raumverwaltungsController.showBelegungstabelle(e.getActionCommand().toString());
					DefaultTableModel model = new DefaultTableModel(new String[] { "Startdatum", "Enddatum" }, 0);
					while (rs.next()) {
						String d = rs.getString("Startdatum");
						String f = rs.getString("Enddatum");
						model.addRow(new Object[] { d, f });
					}
					JTable table = new JTable();
					table.setModel(model);
					JFrame Belegungstabellenframe = new JFrame();
					// Belegungstabellenframe.setSize(700, 750);
					bcontentPane = new JPanel();
					// bcontentPane.setBackground(Color.BLACK);
					bcontentPane.setLayout(new GridBagLayout());

					GridBagConstraints c = new GridBagConstraints();

					if (shouldFill) {
						// natural height, maximum width
						c.fill = GridBagConstraints.HORIZONTAL;
					}

					JTextField e1 = new JTextField("Startdatum:", 10);
					if (shouldWeightX) {
						c.weightx = 0.5;
					}
					c.fill = GridBagConstraints.HORIZONTAL;
					c.gridx = 0;
					c.gridy = 0;
					bcontentPane.add(e1, c);

					JTextField e2 = new JTextField("Enddatum:", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 0;
					bcontentPane.add(e2, c);

					JTextField t = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 0;
					c.gridy = 1;
					bcontentPane.add(t, c);

					JTextField t2 = new JTextField("", 10);
					c.fill = GridBagConstraints.HORIZONTAL;
					c.weightx = 0.5;
					c.gridx = 1;
					c.gridy = 1;
					bcontentPane.add(t2, c);

					JButton b = new JButton("speichern");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 3;
					bcontentPane.add(b, c);

					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 40; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 2;
					bcontentPane.add(table, c);

					JTextField anweisung = new JTextField("Eingabe im Format: 2002-06-08 11:11:00.0");
					c.fill = GridBagConstraints.HORIZONTAL;
					c.ipady = 15; // make this component tall
					c.weightx = 0.0;
					c.gridwidth = 3;
					c.gridx = 0;
					c.gridy = 4;
					bcontentPane.add(anweisung, c);

					Belegungstabellenframe.add(bcontentPane);
					Belegungstabellenframe.pack();
					Belegungstabellenframe.setLocationRelativeTo(null);
					Belegungstabellenframe.setVisible(true);

					b.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							t.getText();
							t2.getText();

							raumverwaltungsController.updateBelegungstabelle("M730",
									java.sql.Timestamp.valueOf(t.getText()), java.sql.Timestamp.valueOf(t2.getText()));
							Belegungstabellenframe.dispose();
						}
					});

				}

			}

		});

//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------		

		panel = new JPanel();
		pack();
	}

}
