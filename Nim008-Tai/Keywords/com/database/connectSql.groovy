package com.database

import java.sql.Connection;
import java.sql.DriverManager
import java.sql.ResultSet;
import java.sql.ResultSetMetaData
import java.sql.Statement;

import com.kms.katalon.core.annotation.Keyword

public class connectSql {
	private static Connection connection = null;

	@Keyword
	def connectDB(String server, String port, String dbname, String username, String password, String schema){

		Class.forName("oracle.jdbc.driver.OracleDriver")

		String url = "jdbc:oracle:thin:@" + server + ":" + port + "/" + dbname

		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(url, username, password)

		connection.setSchema(schema);
		return connection
	}

	/*
	 @Keyword
	 def executeQuery(String queryString) {
	 Statement stm = connection.createStatement()
	 ResultSet rs = stm.executeQuery(queryString)
	 return rs
	 }
	 */
	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()

		ResultSet resultSet = stm.executeQuery(queryString)

		ResultSetMetaData metadata = resultSet.getMetaData()
		int columnCount = metadata.getColumnCount()
		List<List<String>> rowList = new LinkedList<List<String>>()

		while (resultSet.next()) {

			List<String> row = new LinkedList<>()

			for(int i = 1; i <=columnCount; i++) {
				Object value = resultSet.getObject(i)
				row.add(value)
			}
			//System.out.println(row)
			rowList.add(row)
		}

		for(List<String> row: rowList) {
			for(String data: row) {
				System.out.print(data + " ")
			}
			System.out.println()
		}

		return rowList
	}

	@Keyword
	def closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}


	@Keyword
	def execute(String queryString) {
		Statement stm = connection.createStatement()
		boolean result = stm.execute(queryString)
		return result
	}
}
