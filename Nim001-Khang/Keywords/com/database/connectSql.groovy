package com.database

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.DriverManager

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.sql.Sql
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import internal.GlobalVariable

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


	@Keyword
	def executeQuery(String queryString) {
		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		return rs
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
