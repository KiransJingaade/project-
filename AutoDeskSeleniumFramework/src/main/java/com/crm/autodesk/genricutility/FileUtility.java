package com.crm.autodesk.genricutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Kiran
 *
 */

public class FileUtility  {
	/**
	 * its used to read the data from commonData.properties File based on Key which you pass as an argument
	 * @param key
	 * @throwsThrowable
	 */
     public String getPropertyKeyValue(String key) throws Throwable{
    	 FileInputStream fis=new FileInputStream(IPathConstants.PROPERTYFILE_PATH);
    	 Properties pobj=new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
    	 return value;
     }
}
