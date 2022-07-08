package practice;

import java.util.Date;

public class GetSystemAndTime {

	public static void main(String[] args) {
		Date date=new Date();
		String dateAndTime = date.toString();

		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		
	System.out.println(finalFormat);
	}

}
