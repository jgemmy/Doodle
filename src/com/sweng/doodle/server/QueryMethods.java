package com.sweng.doodle.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryMethods {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/test";
	String NOMECOGNPASSW = "SELECT nome, nick, password,mail from users";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	static final String TABLENAME = "users";
	static final String TABLENAME2 = "eventi";

	
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
		  System.out.println("Created table in given database...");
	}
	/*REGISTRAZIONE UTENTE*/
	public static void insertUser(Statement statement, String nome, String nick, String password,String mail) throws SQLException{
		String insertTableSQL = "INSERT INTO "+TABLENAME
				+ "(nome, nick, password,mail) " + "VALUES"
				+ "('"+nome+"','"+nick+"','"+password+"', '"+mail+"')";
		statement.executeUpdate(insertTableSQL);   
		  System.out.println("Created user in given database...");
	}
	
	public static String login(Statement statement, String nick, String passw) throws SQLException{
		String get = "SELECT * FROM "+TABLENAME + " WHERE password = '"+passw+"' AND nick = '"+nick+"' ";
				
		String userid = "empty";
		ResultSet rs = statement.executeQuery(get);
		while (rs.next()) {

			 userid = rs.getString("nome");
			System.out.println("nome : " + userid);
		
		}
		return userid;
	}
	
	public static void getAllInformations(Statement statement) throws SQLException{
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
	}

	public static void changepassword(Statement stmt,String password) throws SQLException{


		String changepsw = "SET PASSWORD FOR 'root'@'localhost' = PASSWORD('"+password+"');";
		stmt.executeUpdate(changepsw);
	}
	
	
	/*__________________________________________________EVENTI_____________________________________________________*/
	
	public static void   creatabellaeventi(Statement statement, String tablename2) throws SQLException{
		String createTablee = "CREATE TABLE IF NOT EXISTS "+tablename2 +
				" (id INTEGER not NULL PRIMARY KEY , " +
				" nome VARCHAR(255), " +
				" luogo VARCHAR(255), " +
				" descrizione VARCHAR(255), " +
				" dal VARCHAR(255), " +
				" al VARCHAR(255))" ; 
		statement.executeUpdate(createTablee);
		  System.out.println("Created table in given database...");
	}
	
	public static void insertEvent(Statement statement, String nome, String luogo, String descrizione,String dal, String al) throws SQLException{
		String insertTableSQL = "INSERT INTO "+TABLENAME2
				+ "(nome, luogo, descrizione, dal, al) " + "VALUES"
				+ "('"+nome+"','"+luogo+"','"+descrizione+"', '"+dal+"', '"+al+"')";
		statement.executeUpdate(insertTableSQL);   
		  System.out.println("Created event in given database...");
	}

	
	/*__________________________________________________PARTECIPANTI_______________________________________________*/
	
	
	
	
	
	/*__________________________________________________COMMENTI___________________________________________________*/

}
