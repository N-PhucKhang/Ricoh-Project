
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.LinkedList

import java.lang.Integer

import java.util.ArrayList


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
