package test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;
import org.junit.Assert;
import org.junit.Test;


public class ListUsersTest {
	public static final String ADDRESS = "http://localhost:8080/SampleWebAppJpa/UserList";
	
	@Test
	public void testUserList() {
	 	try {
				WebConversation webConversation = new WebConversation();
				WebResponse menuResponse = webConversation.getResponse(ADDRESS);
				Assert.assertEquals("User List", menuResponse.getTitle());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
