package base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {

	public static AndroidDriver driver;
	public static AppiumDriverLocalService service;
	public static AppiumServiceBuilder builder;

	String node_js_path = "C:\\Program Files\\nodejs\\node.exe";
	String node_js_main_path = "C:\\Users\\PrinciyShrivastava\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

	
	@BeforeTest(groups = {"OPAA-TC-234", "OPAA-TC-235", "OPAA-TC-236", "OPAA-TC-238"})
	public void setUp() throws MalformedURLException, InterruptedException {

		// start appium server
		builder = new AppiumServiceBuilder();

		builder.withAppiumJS(new File(node_js_main_path)).usingDriverExecutable(new File(node_js_path)).usingPort(4723)
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE).withIPAddress("127.0.0.1");

		Thread.sleep(5000);

		service = AppiumDriverLocalService.buildService(builder);
		service.start();

		// create capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 6 API 28");
		options.setApp(System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\app-release 3.apk");

		// create object for Android device
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

	}

	@AfterTest(groups = {"OPAA-TC-234", "OPAA-TC-235", "OPAA-TC-236", "OPAA-TC-238"})
	public void tearDown() {

		driver.quit();
		service.stop();

	}

}
