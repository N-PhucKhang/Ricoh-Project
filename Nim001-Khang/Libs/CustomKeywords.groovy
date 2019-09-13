
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String


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
