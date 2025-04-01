package testCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class TestLogin {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rashm\\eclipse-workspace\\SeleniumUi\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// Instantiate a ChromeDriver class.
		driver = new ChromeDriver();
		try {

		// Maximize the browser
		driver.manage().window().maximize();

		// Launch
		driver.get("https://test.templedekho.com/");
		Thread.sleep(10000);
		   // Click on "Login

		driver.findElement(By.xpath("//body/div[@id='root']/div[@class='templeApp']/div[@class='MuiBox-root css-0']/div[@class='headerMainNav MuiBox-root css-0']/nav[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root MuiAppBar-colorPrimary MuiAppBar-positionFixed mui-fixed css-1vfuvx1']/nav[@class='headerContainer']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 row d-flex align-items-center mainGrid css-isbt42']/div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-3 MuiGrid-grid-lg-3 MuiGrid-grid-xl-3 hdRightGrid css-wfj9yb']/div[@class='headerRight MuiBox-root css-0']/div[@class='profileBlock MuiBox-root css-0']/a[@href='javascipt:void()']/button[1]\r\n"
				+ "")).click();
		Thread.sleep(10000);
		
              
        // Enter mobile number
        driver.findElement(By.xpath("//input[@id=':rb:']\r\n"
        		+ "")).sendKeys("9830162522");
        Thread.sleep(10000);
        
     //   driver.findElement(By.xpath("//input[@id=':rb:']\r\n"
     //   		+ "")).getText();

        // Click on "PROCEED"
        driver.findElement(By.xpath("//button[normalize-space()='PROCEED']\r\n"
        		+ "")).click();
        Thread.sleep(10000);
        
        WebElement otpScreen = driver.findElement(By.xpath("//*[contains(@class, 'otpScreen')]"));

      //  WebElement otpScreens.forEach(otpScreen -> System.out.println(otpScreen.getText()));
        System.out.println(otpScreen.getText() );
        

        
        List<WebElement> otpScreensInputs = driver.findElements(By.xpath("//*[contains(@class, 'otpFields')]/div/input"));
        for (int i = 0; i < otpScreensInputs.size(); i++) {
            WebElement ipEl = otpScreensInputs.get(i);
            if((i+1)%2 == 0) {
            	ipEl.sendKeys("2");
            } else {
            	ipEl.sendKeys("1");
            }
            System.out.println(ipEl.getText());
        }
        
        
        // Click on "Confirm"
        driver.findElement(By.xpath("//button[normalize-space()='Confirm']\r\n"
        		+ "")).click();
       
        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        
        // Scroll up
        js.executeScript("window.scrollBy(0,-500)");
        
        // Click on various buttons
        driver.findElement(By.xpath("//button[text()='Temple']")).click();
        driver.findElement(By.xpath("//button[text()='Puja']")).click();
        driver.findElement(By.xpath("//button[text()='Chadhava']")).click();
        driver.findElement(By.xpath("//button[text()='Prasad']")).click();
        driver.findElement(By.xpath("//button[text()='Blog']")).click();
        driver.findElement(By.xpath("//button[text()='Darshan']")).click();
        driver.findElement(By.xpath("//button[text()='M R']")).click();
        driver.findElement(By.xpath("//button[text()='Logout']")).click();
        driver.findElement(By.xpath("//button[text()='Logout']")).click();
        
	}
	catch (Exception e) {
        e.printStackTrace();
    } finally {
        // Close browser
        driver.quit();
    }

	}
}


