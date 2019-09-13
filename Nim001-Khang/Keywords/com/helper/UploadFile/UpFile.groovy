package com.helper.UploadFile

import com.kms.katalon.core.annotation.Keyword

public class UpFile {
	
	@Keyword
    public  String getDefaultAppicationRunningPath(){
        return System.getProperty("user.dir")
    }
}
