package com.sweng.doodle.shared;
import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4199709767701362735L;
	/**
	 * 
	 */
	
	private  String id, nome, luogo, descrizione;
	private  Date dal,al;
	private int check;

	public Evento (String id, String nome, String luogo,String descrizione, Date dal, Date al, int check) {
		this.id = id;
		this.nome = nome;
		this.luogo = luogo;
		this.descrizione = descrizione;
		this.dal = dal;
		this.al = al;
		this.check = check;
	}

	public Evento (){
		this.id = "no data";
		this.nome = "no data";
		this.luogo = "no data";
		this.descrizione = "no data";
		this.dal = new Date();
		this.al = new Date();
		this.check = 0;
	}
	
	
	
	public String getID() {
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
	public int getCheck() {
		return check;
	}
}
