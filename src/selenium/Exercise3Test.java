package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Exercise3Test {

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
		WebDriver driver = new ChromeDriver(); 
		//ChromeDriverの作成
		driver.get("https://www.e-procurement.metro.tokyo.lg.jp/index.jsp"); 
		//get()でブラウザ起動 
		driver.findElement(By.cssSelector("body > div.noticeofurlchange > div > button")).click();
		//お知らせのOKをクリック
//		String window1 = driver.getWindowHandle();
//		//今のところを保存
//		driver.findElement(By.className("cat_menu_1")).click();
//		//入札情報サービスをクリック
//        String newHandle = null;
//        for (String id : driver.getWindowHandles()) {
//            if (!id.equals(window1)) {
//                newHandle = id;
//            }
//        }
//      //次のタブのハンドルを用意し、タブが新しく開かれていたらnewHandleに代入する
//        
//        driver.switchTo().window(newHandle);
//      //newHandleにハンドルを移す

		
		String window0 = driver.getWindowHandle();
		//今のところを保存
		driver.findElement(By.className("cat_menu_1")).click();
		//入札情報サービスをクリック
	    Set<String> set = driver.getWindowHandles();
	  //全てのウィンドウハンドルを取得
	    Iterator<String> it = set.iterator();
	  //それぞれのウインドウハンドルを別々の変数に保存
	    String window1 = it.next();
	    System.out.println(window1);
	  //ウィンドウハンドル１
	    String window2 = it.next();
	    System.out.println(window2);
	    //ウィンドウハンドル２
	    driver.switchTo().window(window2);
		//ページの切り替え
	    System.out.println(driver.getWindowHandle());
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.linkText("発注予定情報")).click();
		//発注予定情報をクリック
//		driver.quit();
		//ブラウザを閉じる
	}

}
