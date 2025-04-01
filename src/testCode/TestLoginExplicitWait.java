package testCode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestLoginExplicitWait {
    public static void main(String args[]) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\rashm\\eclipse-workspace\\SeleniumUi\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Instantiate a ChromeDriver class.
        driver = new ChromeDriver();
        
        // Create WebDriverWait instance (Maximum wait time: 20 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Maximize the browser
            driver.manage().window().maximize();

            // Launch the website
            driver.get("https://test.templedekho.com/");

            // Wait for Login button to be clickable and click it
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "//body/div[@id='root']/div[@class='templeApp']/div[@class='MuiBox-root css-0']/div[@class='headerMainNav MuiBox-root css-0']/nav[@class='MuiPaper-root MuiPaper-elevation MuiPaper-elevation4 MuiAppBar-root MuiAppBar-colorPrimary MuiAppBar-positionFixed mui-fixed css-1vfuvx1']/nav[@class='headerContainer']/div[@class='MuiGrid-root MuiGrid-container MuiGrid-spacing-xs-2 row d-flex align-items-center mainGrid css-isbt42']/div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-3 MuiGrid-grid-lg-3 MuiGrid-grid-xl-3 hdRightGrid css-wfj9yb']/div[@class='headerRight MuiBox-root css-0']/div[@class='profileBlock MuiBox-root css-0']/a[@href='javascipt:void()']/button[1]")));
            loginButton.click();

            // Wait for mobile input field and enter mobile number
            WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=':rb:']")));
            mobileInput.sendKeys("9830162522");
            Thread.sleep(10000);
            // Wait for Proceed button and click it
            WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='PROCEED']")));
            proceedButton.click();

            // Wait for OTP screen to appear
            WebElement otpScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class, 'otpScreen')]")));
            System.out.println(otpScreen.getText());

            // Wait for OTP fields and enter OTP
            List<WebElement> otpScreensInputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class, 'otpFields')]/div/input")));
            for (int i = 0; i < otpScreensInputs.size(); i++) {
                WebElement ipEl = otpScreensInputs.get(i);
                if ((i + 1) % 2 == 0) {
                    ipEl.sendKeys("2");
                } else {
                    ipEl.sendKeys("1");
                }
                System.out.println(ipEl.getAttribute("value")); // Use getAttribute("value") instead of getText() for input fields
            }

            // Wait for Confirm button and click it
            WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Confirm']")));
            confirmButton.click();

            // Scroll down
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");

            // Scroll up
            js.executeScript("window.scrollBy(0,-500)");

            // Click on various buttons (Wait before each click)
            String[] buttonNames = {"Temple", "Puja", "Chadhava", "Prasad", "Blog", "Darshan", "M R", "Logout", "Logout"};
            for (String buttonName : buttonNames) {
                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='" + buttonName + "']")));
                button.click();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
