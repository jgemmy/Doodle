package com.sweng.doodle.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

public class QueryMethods {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/test";
	String NOMECOGNPASSW = "SELECT nome, nick, password,mail from users";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	static final String TABLENAME = "users";
	static final String TABLENAME2 = "eventi";

	/*__________________________________________________ConnessioneDB_____________________________________________________*/

	public static Statement connect(Connection conn) {

		Statement stmt = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();



			//		      insertUser(stmt, "Carmelo", "De Paperinis", "ndoCulo");
			//		      deleteUser(stmt, "Carmelo", "De Paperinis", "ndoCulo");
			//		      deleteIdUser(stmt, 0);

			System.out.println("Created table in given database...");

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		//finally block used to close resources
		return stmt;

	}//end main

	public static void close(Statement stmt,Connection conn){
		try{
			if(stmt!=null)
				conn.close();
		}catch(SQLException se){
		}// do nothing
		try{
			if(conn!=null)
				conn.close();
		}catch(SQLException se){
			se.printStackTrace();
		}//end finally try
		//end try
		System.out.println("Goodbye!");
	}


	/*__________________________________________________USERS_____________________________________________________*/


	public static void   creatabella(Statement statement, String tablename) throws SQLException{
		String createTable = "CREATE TABLE IF NOT EXISTS "+tablename +
				" (id INTEGER not NULL PRIMARY KEY AUTO_INCREMENT , " +
				" nome VARCHAR(255), " + 
				" nick VARCHAR(255), " +
				" mail VARCHAR(255), " +
				" password VARCHAR(255))"; 
		statement.executeUpdate(createTable);
		System.out.println("Created Users table in given database...");
	}
	/*REGISTRAZIONE UTENTE*/
	public static void insertUser(Statement statement, String nome, String nick, String password,String mail) throws SQLException{
		String insertTableSQL = "INSERT INTO "+TABLENAME
				+ "(nome, nick, password,mail) " + "VALUES"
				+ "('"+nome+"','"+nick+"','"+password+"', '"+mail+"')";
		statement.executeUpdate(insertTableSQL);   
		System.out.println("Created User in given database...Utente Registrato");
	}

	public static String login(Statement statement, String nick, String passw) throws SQLException{
		String get = "SELECT * FROM "+TABLENAME + " WHERE password = '"+passw+"' AND nick = '"+nick+"' ";

		String userid = "empty";
		ResultSet rs = statement.executeQuery(get);
		while (rs.next()) {

			userid = rs.getString("id");
			System.out.println("Loggato id : " + userid);

		}
		return userid;
	}

	public static void getAllInformationsUsers(Statement statement) throws SQLException{
		String get = "SELECT nome,nick,password,mail FROM "+TABLENAME;
		ResultSet rs = statement.executeQuery(get);
		while (rs.next()) {

			String userid = rs.getString("nome");
			String username = rs.getString("nick");
			String password = rs.getString("password");
			String mail = rs.getString("mail");
			System.out.println("nome : " + userid);
			System.out.println("nick : " + username);
			System.out.println("password : " + password);
			System.out.println("mail : " + mail);
		}
	}

	public static void deleteUser(Statement statement, String nome, String nick, String password,String mail) throws SQLException{
		String removeUser = "DELETE FROM "+TABLENAME+" WHERE nome = '"+nome+"' AND nick = '"+nick+"' AND password = '"+password+"' AND mail = '"+mail+"'";
		statement.executeUpdate(removeUser);   
	}

	public static void deleteIdUser(Statement statement, int id) throws SQLException{
		String removeUser = "DELETE FROM "+TABLENAME+" WHERE id = "+id;
		statement.executeUpdate(removeUser);
		System.out.println("Utente Rimosso ID: " + id);
	}

	public static void changepassword(Statement stmt,String password) throws SQLException{


		String changepsw = "SET PASSWORD FOR 'root'@'localhost' = PASSWORD('"+password+"');";
		stmt.executeUpdate(changepsw);
	}


	/*__________________________________________________EVENTI_____________________________________________________*/

	public static void   creatabellaeventi(Statement statement ) throws SQLException{
		String createTablee = "CREATE TABLE IF NOT EXISTS "+ TABLENAME2 +
				" (id INTEGER not NULL PRIMARY KEY AUTO_INCREMENT , " +
				" idKey INTEGER, " +
				" nome VARCHAR(255), " +
				" luogo VARCHAR(255), " +
				" descrizione VARCHAR(255), " +
				" dal DATETIME, " +
				" al DATETIME)" ; 
		statement.executeUpdate(createTablee);
		System.out.println("Created Eventi table in given database...");
	}

	public static String insertEvent(Statement statement, String nome, String luogo, String descrizione,String dal, String al,String idKey) throws SQLException{
		//		Sun Mar 09 00:00:00 CET 2014
		StringTokenizer token = new StringTokenizer(dal, " ");
		token.nextToken();
		String month = token.nextToken();
		String day =  token.nextToken();
		String hour = token.nextToken();
		token.nextToken();
		String year = token.nextToken();
		String dateDal = day+","+month+","+year+" "+hour;
		System.out.println(dateDal);
		StringTokenizer token1 = new StringTokenizer(al, " ");
		token1.nextToken();
		String month1 = token1.nextToken();
		String day1 =  token1.nextToken();
		String hour1 = token1.nextToken();
		token1.nextToken();
		String year1 = token1.nextToken();
		String dateAl = day1+","+month1+","+year1+" "+hour1;
		System.out.println(dateAl);
		String insertTableSQL = "INSERT INTO "+ TABLENAME2
				+ "(nome, luogo, descrizione, dal, al,idKey) " + "VALUES"
				+ "('"+nome+"','"+luogo+"','"+descrizione+"',STR_TO_DATE('"+dateDal+"', '%d,%b,%Y %H:%i:%s'),  STR_TO_DATE('"+dateAl+"', '%d,%b,%Y %T'), '"+idKey+"')";
		statement.executeUpdate(insertTableSQL);
		String get = "SELECT id FROM "+TABLENAME2 + " WHERE nome = '"+nome+"' ";

		String userid = "empty";
		ResultSet rs = statement.executeQuery(get);
		while (rs.next()) {

			userid = rs.getString("id");
			System.out.println("Evento Inserito ID: " + userid);

		}
		return userid;
	}

	public static String deleteIdEvent(Statement statement, String id,String idKey) throws SQLException{

		String removeEvent = "DELETE FROM "+TABLENAME2+" WHERE idKey = "+idKey+" AND id = "+id;
		String eventid = id ;
		statement.executeUpdate(removeEvent);
		System.out.println("Evento Rimosso ID: " + id);

		return eventid;

	}

	public static void getAllInformationsEvent(Statement statement) throws SQLException{
		String get = "SELECT nome,luogo,descrizione,dal,al,idkey FROM "+TABLENAME2;
		ResultSet rs = statement.executeQuery(get);
		while (rs.next()) {

			String nome = rs.getString("nome");
			String luogo = rs.getString("luogo");
			String descrizione= rs.getString("descrizione");
			String dal = rs.getString("dal");
			String al = rs.getString("al");
			String idkey = rs.getString("idkey");
			System.out.println("nome : " + nome);
			System.out.println("luogo : " + luogo);
			System.out.println("descrizione : " + descrizione);
			System.out.println("dal : " + dal);
			System.out.println("al : " + al);
			System.out.println("ideky : " + idkey);
		}
	}

	/*__________________________________________________PARTECIPANTI_______________________________________________*/





	/*__________________________________________________COMMENTI___________________________________________________*/

}
