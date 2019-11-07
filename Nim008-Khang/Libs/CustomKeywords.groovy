
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.sql.Connection

import java.lang.String

import com.katalon.plugin.keyword.connection.DBType

import java.sql.ResultSet

import java.util.LinkedList

import java.lang.Integer

import java.util.ArrayList


def static "com.katalon.plugin.keyword.connection.DatabaseKeywords.execute"(
    	Connection conn	
     , 	String queryString	) {
    (new com.katalon.plugin.keyword.connection.DatabaseKeywords()).execute(
        	conn
         , 	queryString)
}

def static "com.katalon.plugin.keyword.connection.DatabaseKeywords.executeQuery"(
    	Connection conn	
     , 	String queryString	) {
    (new com.katalon.plugin.keyword.connection.DatabaseKeywords()).executeQuery(
        	conn
         , 	queryString)
}

def static "com.katalon.plugin.keyword.connection.DatabaseKeywords.executeUpdate"(
    	Connection conn	
     , 	String queryString	) {
    (new com.katalon.plugin.keyword.connection.DatabaseKeywords()).executeUpdate(
        	conn
         , 	queryString)
}

def static "com.katalon.plugin.keyword.connection.DatabaseKeywords.createConnection"(
    	DBType type	
     , 	String server	
     , 	String port	
     , 	String dbName	
     , 	String userName	
     , 	String Password	) {
    (new com.katalon.plugin.keyword.connection.DatabaseKeywords()).createConnection(
        	type
         , 	server
         , 	port
         , 	dbName
         , 	userName
         , 	Password)
}

def static "com.katalon.plugin.keyword.connection.DatabaseKeywords.closeConnection"(
    	Connection conn	) {
    (new com.katalon.plugin.keyword.connection.DatabaseKeywords()).closeConnection(
        	conn)
}

def static "com.katalon.plugin.keyword.connection.DatabaseKeywords.getGlobalConnection"() {
    (new com.katalon.plugin.keyword.connection.DatabaseKeywords()).getGlobalConnection()
}

def static "com.katalon.plugin.keyword.generator.DataFileKeywords.createUsingInternalConnection"(
    	String fileName	
     , 	String query	
     , 	String user	
     , 	String password	
     , 	DBType dbType	
     , 	String host	
     , 	String port	
     , 	String dbName	) {
    (new com.katalon.plugin.keyword.generator.DataFileKeywords()).createUsingInternalConnection(
        	fileName
         , 	query
         , 	user
         , 	password
         , 	dbType
         , 	host
         , 	port
         , 	dbName)
}

def static "com.katalon.plugin.keyword.generator.DataFileKeywords.createUsingGlobalConnection"(
    	String fileName	
     , 	String query	) {
    (new com.katalon.plugin.keyword.generator.DataFileKeywords()).createUsingGlobalConnection(
        	fileName
         , 	query)
}

def static "com.database.connectSql.connectDB"(
    	String server	
     , 	String port	
     , 	String dbname	
     , 	String username	
     , 	String password	
     , 	String schema	) {
    (new com.database.connectSql()).connectDB(
        	server
         , 	port
         , 	dbname
         , 	username
         , 	password
         , 	schema)
}

def static "com.database.connectSql.executeQuery"(
    	String queryString	) {
    (new com.database.connectSql()).executeQuery(
        	queryString)
}

def static "com.database.connectSql.closeDatabaseConnection"() {
    (new com.database.connectSql()).closeDatabaseConnection()
}

def static "com.database.connectSql.execute"(
    	String queryString	) {
    (new com.database.connectSql()).execute(
        	queryString)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue"(
    	ResultSet rs	
     , 	int columnIndex	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getListCellValue(
        	rs
         , 	columnIndex)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getListCellValue"(
    	ResultSet rs	
     , 	String columnName	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getListCellValue(
        	rs
         , 	columnName)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getListRowValue"(
    	ResultSet rs	
     , 	int fromRowIndex	
     , 	int toRowIndex	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getListRowValue(
        	rs
         , 	fromRowIndex
         , 	toRowIndex)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.exportToCSV"(
    	ResultSet rs	
     , 	String pathFile	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).exportToCSV(
        	rs
         , 	pathFile)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.isEmptyResult"(
    	ResultSet rs	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).isEmptyResult(
        	rs)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getRowCount"(
    	ResultSet rs	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getRowCount(
        	rs)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getColumnCount"(
    	ResultSet rs	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getColumnCount(
        	rs)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleRowValue"(
    	ResultSet rs	
     , 	int rowIndex	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getSingleRowValue(
        	rs
         , 	rowIndex)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue"(
    	ResultSet rs	
     , 	int rowIndex	
     , 	int colIndex	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getSingleCellValue(
        	rs
         , 	rowIndex
         , 	colIndex)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.getSingleCellValue"(
    	ResultSet rs	
     , 	int rowIndex	
     , 	String columnName	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).getSingleCellValue(
        	rs
         , 	rowIndex
         , 	columnName)
}

def static "com.katalon.plugin.keyword.connection.ResultSetKeywords.resultSetToArrayList"(
    	ResultSet rs	) {
    (new com.katalon.plugin.keyword.connection.ResultSetKeywords()).resultSetToArrayList(
        	rs)
}

def static "com.helper.UploadFile.UpFile.getDefaultAppicationRunningPath"() {
    (new com.helper.UploadFile.UpFile()).getDefaultAppicationRunningPath()
}

def static "com.helpers.Tab2Helpers.convert"(
    	String string	) {
    (new com.helpers.Tab2Helpers()).convert(
        	string)
}

def static "com.helpers.Tab2Helpers.convertStringToBigDecimal"(
    	String string	) {
    (new com.helpers.Tab2Helpers()).convertStringToBigDecimal(
        	string)
}

def static "com.helpers.Tab2Helpers.countItems"(
    	java.util.LinkedList<String[]> array	) {
    (new com.helpers.Tab2Helpers()).countItems(
        	array)
}

def static "com.helpers.Tab2Helpers.getColumnTotalValue"(
    	java.util.LinkedList<String[]> array	
     , 	Integer columnNo	) {
    (new com.helpers.Tab2Helpers()).getColumnTotalValue(
        	array
         , 	columnNo)
}

def static "com.helpers.Tab2Helpers.getGridTableHeaderName"(
    	String gridTable	) {
    (new com.helpers.Tab2Helpers()).getGridTableHeaderName(
        	gridTable)
}

def static "com.helpers.Tab2Helpers.getGridTableData"(
    	String gridTable	) {
    (new com.helpers.Tab2Helpers()).getGridTableData(
        	gridTable)
}

def static "com.helpers.Tab2Helpers.surveySumariesData"(
    	java.util.ArrayList<java.math.BigDecimal> array_summaries_detail_from_db	
     , 	java.util.ArrayList<java.math.BigDecimal> array_summaries_from_db	
     , 	java.util.ArrayList<java.math.BigDecimal> array_summaries_detail_from_grid_table	
     , 	java.util.ArrayList<java.math.BigDecimal> array_summaries_from_grid_table	) {
    (new com.helpers.Tab2Helpers()).surveySumariesData(
        	array_summaries_detail_from_db
         , 	array_summaries_from_db
         , 	array_summaries_detail_from_grid_table
         , 	array_summaries_from_grid_table)
}
