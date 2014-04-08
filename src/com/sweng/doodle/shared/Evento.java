package com.sweng.doodle.shared;
import java.io.Serializable;

public class Evento implements Serializable {
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1058023843439640732L;
	private  String id, nome, luogo, descrizione,cause;
	private  String dal,al;
	private int check;
	

	public Evento (String id, String nome, String luogo,String descrizione, String dal, String al, int check, String cause) {
		this.id = id;
		this.nome = nome;
		this.luogo = luogo;
		this.descrizione = descrizione;
		this.dal = dal;
		this.al = al;
		this.check = check;
		this.cause = cause;
	}

	public Evento (){
		this.id = "no data";
		this.nome = "no data";
		this.luogo = "no data";
		this.descrizione = "no data";
		this.dal = "no data";
		this.al = "no data";
		this.check = 0;
		this.cause = "nodata";
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

	public String getDal() {
		return dal;
	}

	public String getAl() {
		return al;
	}
	public int getCheck() {
		return check;
	}
	public String getCause() {
		return cause;
	}
}
