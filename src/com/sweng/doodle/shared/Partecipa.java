package com.sweng.doodle.shared;



public class Partecipa {
	private  String id, nome, cognome, nick, commento;
	private  int disp;

	public Partecipa (String id, String nome, String cognome,String nick, String commento, int disp) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.nick = nick;
		this.commento = commento;
		this.disp = disp;

	}
	
	public Partecipa () {
		this.id = "nodata";
		this.nome = "nodata";
		this.cognome = "nodata";
		this.nick = "nodata";
		this.commento = "nodata";
		this.disp = 0;

	}
	
	public String getID() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNick() {
		return nick;
	}

	public String getCommento() {
		return commento;
	}

	public int getDisp() {
		return disp;
	}
}
