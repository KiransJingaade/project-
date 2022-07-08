package com.crm.autodesk.genricutility;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Kiran 
 *
 */ 

public class JavaUtility {
	/**
	 * its used to generate random number
	 * @return int data
	 */
	public int getRandomnumber() {
		Random random=new Random();
		int randomNum = random.nextInt(10000);
		return randomNum;
	}
	/**
	 * used to get system date & time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
	}
	/**
	 * used to get system date in YYYY-MM-DD format
	 * @return 
	 * @return
	 */
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String dateAndTime = date.toString();

		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		
		return finalFormat;
	}
}
