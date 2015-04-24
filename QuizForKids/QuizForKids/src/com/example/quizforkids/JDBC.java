package com.example.quizforkids;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.quizforkids.Age3to5Results;
import com.example.quizforkids.Age5to7Results;

public class JDBC {

	/**
	 * JDBC driver name and database URL
	 */
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://web2.eeecs.qub.ac.uk/40025827";

	/**
	 * Database credentials
	 */
	static final String USER = "40025827";
	static final String PASS = "UYN6542";

	public static void saveScoreToDB(String Age, int Lvl, String HighScore) {

		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...\n");
			stmt = conn.createStatement();
			String command;
			System.out.println("statement created");
			
			/*
			System.out.println("Setting variables");
			// settings vars
			String Age = Age3to5Results.;
			int Lvl = ;
			int HighScore = ;
			System.out.println("Variables set");
			*/
			
			// test message
			System.out.println("About to set command");
			// *** Assign values to mysql insert***
			command = "UPDATE highscores SET HighScore = "+ HighScore + " WHERE Age = "+ Age + " & Lvl = " + Lvl + ";";
			// test message
			System.out.println("command set");

			// command executed
			stmt.executeUpdate(command);
			// test message
			System.out.println("Command executed");

			// Clean-up environment
			stmt.close();
			conn.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();

		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

		System.out.println("Goodbye!");
	}// end main
}