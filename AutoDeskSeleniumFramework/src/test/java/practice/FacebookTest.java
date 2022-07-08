package practice;

import org.testng.annotations.Test;
//dependsOnMethods
public class FacebookTest {

		@Test
		public void uploadPic() throws Exception {
			System.out.println("uploading pic");
			throw new Exception();//creating error
		}
		
		@Test(dependsOnMethods="uploadPic")//dependent test will be skipped
		public void likePic() {
			System.out.println("like the pic");
		}
		
		@Test(dependsOnMethods="likePic")//dependent test will be skipped
		public void commentPic() {
			System.out.println("comment on pic");
		}
}
