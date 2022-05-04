
package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaumverwaltungsController {

    private NamedParameterJdbcTemplate jdbcTemplateNamed;
    private JdbcTemplate jdbcTemplate;

    public RaumverwaltungsController(NamedParameterJdbcTemplate jdbcTemplateNamed, JdbcTemplate jdbcTemplate) {
        this.jdbcTemplateNamed = jdbcTemplateNamed;
        this.jdbcTemplate = jdbcTemplate;
    }


    @RequestMapping(path = "/ChangeBelegung")
    String changeBelegung(@RequestParam("Raumnummer") String raumnummer) { //input variable
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("Raumnummer", raumnummer); // wie heißt Parameter?
        String belegung = jdbcTemplateNamed.queryForObject("SELECT Zustand FROM Belegung WHERE Raumnummer = :Raumnummer", namedParameters, String.class); // hier wird etwas ausgelesen -> t und f; damit wird was auslesen können, brauchen wir die ParameterSource.. was wollen wir auslesen?
        System.out.println(belegung); // :raumnummer wichtig! .. für mehrere Parameter ->.addvalue
        if (belegung.equals("t")) {
            jdbcTemplate.execute("UPDATE Belegung set Zustand = FALSE where Raumnummer = '" + raumnummer + "'");
            return "Zustand von Raum " + raumnummer + " wurde auf belegt geaendert.";

        } else if (belegung.equals("f")) {
            jdbcTemplate.execute("UPDATE Belegung set Zustand = TRUE where Raumnummer = '" + raumnummer + "'");
            return "Zustand von Raum " + raumnummer + " wurde auf frei geaendert.";
        } else {
            return "Hier ist etwas schief gelaufen";
        }

    }

    @RequestMapping(path = "/ShowKapazitaet")
    String showKapazitaet(@RequestParam("Raumnummer") String raumnummer) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("Raumnummer", raumnummer);
        String kapazitaet = jdbcTemplateNamed.queryForObject("SELECT Sitzplaetze FROM kapazitaet WHERE Raumnummer = :Raumnummer", namedParameters, String.class);
        System.out.println(kapazitaet);

        return "Die Sitzplatzanzahl in Raum " + raumnummer + " betraegt " + kapazitaet;
    }

    @RequestMapping(path = "/ShowInventar")
    String showInventar(@RequestParam("Raumnummer") String raumnummer) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("Raumnummer", raumnummer);
        String inventar = jdbcTemplateNamed.queryForObject("SELECT Inhalt FROM inventar WHERE Raumnummer = :Raumnummer", namedParameters, String.class);
        System.out.println(inventar);

        return "Folgendes Inventar ist in Raum " + raumnummer + " vorhanden: " + inventar;

    }
}



