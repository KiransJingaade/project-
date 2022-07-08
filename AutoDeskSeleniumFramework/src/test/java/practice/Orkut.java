package practice;

import org.testng.annotations.Test;

public class Orkut {

	@Test(groups="IntegrationtTest")
	public void uploadPic() {
		System.out.println("uploading pic");
	}
	
	@Test(groups="SystemTest")
	public void likePic() {
		System.out.println("like the pic");
	}
}
