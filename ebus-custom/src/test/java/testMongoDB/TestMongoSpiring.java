package testMongoDB;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lantaiyuan.ebus.realtime.model.AppUser;

/*@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-content.xml",
		"classpath:/spring-mvc.xml" })*/
public class TestMongoSpiring {/*
	@Autowired
	private MongoTemplate mt;

	@Test
	public void test1() {
		final String COL_NAME = "tuser122";

		// add
		AppUser appUser = new AppUser();
		appUser.setUserid(1333);
		mt.insert(appUser,COL_NAME);

	}
	
	@Test
	public void test2(){
		int i=0;
		
		AppUser appUser = new AppUser();
		while(i<1000){
			i++;
			appUser.setUserid(i);
			mt.insert(appUser,"tuser122");
		}
	}

*/}