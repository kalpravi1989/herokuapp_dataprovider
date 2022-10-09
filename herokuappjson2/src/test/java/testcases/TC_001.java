package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import herokuappjson_Base.BaseClass;
import herokuappjson_Base.JsonReaderDP;
import pages.Login_Page;

public class TC_001 extends BaseClass {
	String expectedurl = "https://the-internet.herokuapp.com/secure";
	String actualurl;

	@Test(dataProvider = "jsondata", dataProviderClass = JsonReaderDP.class)
	public void logintest(String data) {
		test = extent.createTest(new Object() {
		}.getClass().getEnclosingMethod().getName());
		try {
			Login_Page login = new Login_Page(driver);
			String[] usrdata=data.split(",");
			login.login(usrdata[0],usrdata[1]);
			actualurl = driver.getCurrentUrl();

			Assert.assertEquals(actualurl, expectedurl);
			test.log(Status.PASS, "Login Successfull");
		} catch (Exception e) {
			test.log(Status.FAIL,"login unsuccessfull");
		}

	}
	}

