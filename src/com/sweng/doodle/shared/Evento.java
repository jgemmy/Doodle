package com.sweng.doodle.shared;

import java.sql.Date;

public class Evento {
	private final int id;
	private final String nome, luogo, descrizione;
	private final Date dal,al;

	public Evento (int id, String nome, String luogo,String descrizione, Date dal, Date al) {
		this.id = id;
		this.nome = nome;
		this.luogo = luogo;
		this.descrizione = descrizione;
		this.dal = dal;
		this.al = al;
	}

	public int getID() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getLuogo() {
		return luogo;
	}

	public String getDesc() {
		return descrizione;
	}

	public Date getDal() {
		return dal;
	}

	public Date getAl() {
		return al;
	}
}
