
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import java.util.LinkedList


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

def static "com.helpers.Tab2Helpers.countItems"(
    	java.util.LinkedList<String[]> array	) {
    (new com.helpers.Tab2Helpers()).countItems(
        	array)
}

def static "com.helpers.Tab2Helpers.getUncollectedTotal"(
    	java.util.LinkedList<String[]> array	) {
    (new com.helpers.Tab2Helpers()).getUncollectedTotal(
        	array)
}

def static "com.helpers.Tab2Helpers.getOverpaymentTotal"(
    	java.util.LinkedList<String[]> array	) {
    (new com.helpers.Tab2Helpers()).getOverpaymentTotal(
        	array)
}

def static "com.helpers.Tab2Helpers.getAmountOfMoneyTotal"(
    	java.util.LinkedList<String[]> array	) {
    (new com.helpers.Tab2Helpers()).getAmountOfMoneyTotal(
        	array)
}
