
package com.example.demo;


import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaumverwaltungsController extends JFrame {

	private static final long serialVersionUID = 1L;
	@Autowired // teilt Spring mit, dass es folgende Objekte in andere Klassen einfügen soll
	private NamedParameterJdbcTemplate jdbcTemplateNamed;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public RaumverwaltungsController(NamedParameterJdbcTemplate jdbcTemplateNamed, JdbcTemplate jdbcTemplate) {
		this.jdbcTemplateNamed = jdbcTemplateNamed;
		this.jdbcTemplate = jdbcTemplate;
	}

	@RequestMapping(path = "/ChangeBelegung") // bildet URLs auf Methoden ab -> ist unter anderem fuer API-Schnittstelle
												// relevant
	public String changeBelegung(@RequestParam("Raumnummer") String raumnummer) { // input variable
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("Raumnummer", raumnummer);

		// wie heißt Parameter?

		String belegung = jdbcTemplateNamed.queryForObject(
				"SELECT Zustand FROM Belegung WHERE Raumnummer = :Raumnummer", namedParameters, String.class);
//  hier wird etwas ausgelesen -> entweder t oder f; damit etwas ausgelesen werden kann,
// braucht man die paramtersource "was wollen wir auslesen?"

		System.out.println(belegung);
		if (belegung.equals("t")) {
			jdbcTemplate.execute("UPDATE Belegung set Zustand = FALSE where Raumnummer = '" + raumnummer + "'");
			return "Zustand von Raum " + raumnummer + " wurde auf belegt ge\u00e4ndert.";

		} else if (belegung.equals("f")) {
			jdbcTemplate.execute("UPDATE Belegung set Zustand = TRUE where Raumnummer = '" + raumnummer + "'");
			return "Zustand von Raum " + raumnummer + " wurde auf frei ge\u00e4ndert.";
		} else {
			return "Hier ist etwas schief gelaufen";
		}

	}
	
	@RequestMapping(path = "/showBelegung")
	public String showBelegung(@RequestParam("Raumnummer") String raumnummer) { // input variable
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("Raumnummer", raumnummer); // wie
																												// heißt
																												// Parameter?
		String belegung = jdbcTemplateNamed.queryForObject(
				"SELECT Zustand FROM Belegung WHERE Raumnummer = :Raumnummer", namedParameters, String.class);

		System.out.println(belegung);
		return belegung;

	}

	@RequestMapping(path = "/ShowKapazitaet")
	public String showKapazitaet(@RequestParam("Raumnummer") String raumnummer) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("Raumnummer", raumnummer);
		String kapazitaet = jdbcTemplateNamed.queryForObject(
				"SELECT Sitzplaetze FROM kapazitaet WHERE Raumnummer = :Raumnummer", namedParameters, String.class);
		System.out.println(kapazitaet);

		JOptionPane.showMessageDialog(null,
				"Die Sitzplatzanzahl in Raum " + raumnummer + " betr\u00e4gt " + kapazitaet);

		return "Die Sitzplatzanzahl in Raum " + raumnummer + " betraegt " + kapazitaet;
	}

	@RequestMapping(path = "/ShowInventar")
	public

			String showInventar(@RequestParam("Raumnummer") String raumnummer) {
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("Raumnummer", raumnummer);
		String inventar = jdbcTemplateNamed.queryForObject("SELECT Inhalt FROM inventar WHERE Raumnummer = :Raumnummer",
				namedParameters, String.class);
		System.out.println(inventar);

		JOptionPane.showMessageDialog(null, "Folgendes Inventar ist in Raum " + raumnummer + " vorhanden: " + inventar);

		return "Folgendes Inventar ist in Raum " + raumnummer + " vorhanden: " + inventar;

	}



	@RequestMapping(path = "/ShowBelegungstabelle")
	public SqlRowSet showBelegungstabelle(@RequestParam("Raumnummer") String raumnummer) {
//sqlRowSet weil wir jetzt mehrere Daten haben, die uebergeben werden muessen, nicht mehr nur einen Wert 		
		String sql = "SELECT Startdatum, Enddatum FROM Belegungstabelle WHERE Raumnummer ='" + raumnummer.toUpperCase()
				+ "'";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
		return rs;
	}

	@RequestMapping(path = "/UpdateBelegungstabelle")
	public String updateBelegungstabelle(@RequestParam("Raumnummer") String raumnummer,
			@RequestParam("Startdatum") Timestamp startdatum, @RequestParam("Enddatum") Timestamp enddatum) {
		jdbcTemplate.execute(
				"INSERT INTO Belegungstabelle VALUES ('" + raumnummer + "', '" + startdatum + "', '" + enddatum + "')");
		return "";
	}

}
