package com.sweng.doodle.shared;
import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {
	
	/**
	 * 
	 */
	private static  long serialVersionUID = -3319509587649402955L;
	private  String id, nome, luogo, descrizione;
	private  Date dal,al;

	public Evento (String id, String nome, String luogo,String descrizione, Date dal, Date al) {
		this.id = id;
		this.nome = nome;
		this.luogo = luogo;
		this.descrizione = descrizione;
		this.dal = dal;
		this.al = al;
	}

	public Evento (){
		this.id = "no data";
		this.nome = "no data";
		this.luogo = "no data";
		this.descrizione = "no data";
		this.dal = new Date();
		this.al = new Date();
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
}
