import java.util.Date;

public class Sample {

	public static void main(String[] args) {
		Date date=new Date();
	     String dateAndTime = date.toString();
	             
	     String YYYY = dateAndTime.split(" ")[5];
	     String DD= dateAndTime.split(" ")[2];
	     System.out.println("Enter text for month");
	           System.out.println(date.getMonth());
	     
	}

}
