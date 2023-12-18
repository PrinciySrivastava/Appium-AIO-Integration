package testcase;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import io.appium.java_client.AppiumBy;

public class LoginPage extends BaseTest {

	
	@Test(priority = 1, groups="OPAA-TC-234")
	public void loginWithInvalidCredentials() throws InterruptedException {

		String expectedText = "Invalid Credentials";
		SoftAssert softAssert = new SoftAssert();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]")).click();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]"))
				.sendKeys("Albus@mail.com");
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[2]")).click();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[2]"))
				.sendKeys("Albus@12345");
		driver.findElement(AppiumBy.accessibilityId("LOGIN")).click();
		Thread.sleep(1000);

		System.out.println("test");
		String actualText = driver
				.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Invalid Credentials\"]")).getText();

		System.out.println(actualText);

		Assert.assertEquals(actualText, expectedText);
		System.out.println("Test completed");
		softAssert.assertAll();

	}

	@Test(priority = 2, groups="OPAA-TC-235")
	public void loginWithoutUsername() {

		String expectedText = "Email is required";
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]")).click();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]")).clear();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[2]")).click();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[2]")).clear();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[2]"))
				.sendKeys("Albus@12345");
		driver.findElement(AppiumBy.accessibilityId("LOGIN")).click();

		System.out.println("test1");

		System.out.println(driver.findElement(AppiumBy.accessibilityId("Email is required")));

		String actualText = driver.findElement(AppiumBy.accessibilityId("Email is required")).getText();
		softAssert.assertEquals(actualText, expectedText);
		System.out.println("Test One completed");
		softAssert.assertAll();

	}

	@Test(priority = 3, groups="OPAA-TC-236")
	public void loginWithoutPassword() {

		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]")).click();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]"))
				.sendKeys("albus@mail.com");
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[2]")).click();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[2]")).clear();
		driver.findElement(AppiumBy.accessibilityId("LOGIN")).click();
	
	}

	@Test(priority = 4, groups="OPAA-TC-238")
	public void linkClickHere() {

		String expectedTextOne = "An Educator\r\n" + "This option is for educators at school,\r\n"
				+ "colleges , Universities, and other institutions";
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]")).click();
		driver.findElement(
				AppiumBy.xpath("//android.view.View[@content-desc=\"Login Here\"]/android.widget.EditText[1]")).clear();
		driver.findElement(AppiumBy.accessibilityId("LOGIN")).click();
		driver.findElement(AppiumBy.accessibilityId("Here")).click();
		String actualTextOne = driver.findElement(AppiumBy.xpath(
				"//android.view.View[@content-desc=\"An Educator This option is for educators at school, colleges , Universities, and other institutions\"]"))
				.getText();
		softAssert.assertEquals(actualTextOne, expectedTextOne);

		driver.findElement(AppiumBy.xpath(
				"//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[4]"))
				.click();
		softAssert.assertAll();

	}

}
