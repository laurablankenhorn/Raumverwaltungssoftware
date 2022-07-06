package com.example.demo;

import java.sql.Date;
import java.sql.Timestamp;

public class RaumBelegung {
public RaumBelegung(Timestamp startDate, Timestamp endDate) {
this.setStartdatum(startDate);
this.setEnddatum(endDate);
}

	public Timestamp getStartdatum() {
	return Startdatum;
	}
public void setStartdatum(Timestamp startDate) {
	Startdatum = startDate;
	}
public Timestamp getEnddatum() {
	return Enddatum;
	}
public void setEnddatum(Timestamp endDate) {
Enddatum = endDate;
}
public Timestamp Startdatum;
public Timestamp Enddatum;
}

