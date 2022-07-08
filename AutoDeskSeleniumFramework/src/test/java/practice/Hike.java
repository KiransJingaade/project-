package practice;

import org.testng.annotations.Test;

public class Hike {

	@Test(groups="IntegrationTest")
	public void commentPic() {
		System.out.println("comment the pic");
	}
	
	@Test(groups="SystemTest")
	public void tagPic() {
		System.out.println("tag the pic");
	}
	
	@Test(groups="SystemTest")
	public void sharePic() {
		System.out.println("share the pic");
	}

}
