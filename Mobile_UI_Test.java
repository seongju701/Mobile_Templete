package com.cj.mobile;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import java.net.URL;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mobile_UI_Test {
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	WebElement element = null;
	boolean setupSuccess = true;
	


	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps = DesiredCapabilities.android();

		// device name은 큰 의미없음. LG폰도 이 옵션으로 수행됨
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "LGF460S859d639d");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

		URL appiumUrl = new URL("http://127.0.0.1:4723/wd/hub");

		System.out.println("Start driver.");
		driver = new AndroidDriver<WebElement>(appiumUrl, caps);

	}

	@Test
	public void m_schedule_040() throws Exception {
		driver.get("http://cjmall.com");
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/a[1]/span")).click();
		//좌측 상단 메뉴버튼 클릭
		driver.findElement(By.xpath("//*[@id=\"gnb\"]/div[1]/a")).click();
		//로그인 버튼 클릭
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	public boolean existElement(WebDriver wd, By by, String meaning) {
		WebDriverWait wait = new WebDriverWait(wd, 2);
		// wait.ignoring(NoSuchElementException.class);

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

		} catch (TimeoutException e) {

			System.out.println("[" + meaning + "] WebElement does not Exist. time out ");
			return false;
		}
		System.out.println("[" + meaning + "] WebElement Exist.");
		return true;
	}

}
