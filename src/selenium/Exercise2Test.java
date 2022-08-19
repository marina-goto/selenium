package selenium;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Exercise2Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver"); 
		WebDriver driver = new ChromeDriver(); //ChromeDriverの作成
		driver.get("http://rakuplus.jp"); //get()でブラウザ起動 
		WebElement UserName = driver.findElement(By.name("log")); 
		UserName.sendKeys("marina.goto@rakus-partners.co.jp");
		WebElement pass=driver.findElement(By.name("pwd"));
		pass.sendKeys("Mari2022rks");
		WebElement login=driver.findElement(By.name("wp-submit"));
		login.submit();
		WebElement QA=driver.findElement(By.cssSelector("#sgb-css-id-7 > div > a:nth-child(4)"));
		QA.click();
		
		List<WebElement> elements=driver.findElements(By.cssSelector("section.entry-content > div"));
		int count=0;
		for(WebElement div:elements) {
			if(count>0) {
			WebElement name=div.findElement(By.className("big"));
			WebElement frigana=div.findElement(By.cssSelector(".has-text-align-center.has-text-color"));
			WebElement picture=div.findElement(By.className("js-smartphoto"));
			
			System.out.println(name.getText());
			System.out.println(frigana.getText());
			System.out.println(picture.getAttribute("outerHTML"));
		}
			count++;
		}
		
		driver.quit();
	}

}
