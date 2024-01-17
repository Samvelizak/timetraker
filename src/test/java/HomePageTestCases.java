import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTestCases extends BaseClass {
    public WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void setUp(){
        test=reports.createTest("Home page test cases");
        driver.get("http://localhost:57880/Home/Login");
        driver.findElement(By.id("userid")).sendKeys("1");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/a")).click();


        System.out.println(driver.getTitle());

    }
    @Test  //  Test case 1 Vaild Username and Password
    @DisplayName("HomePageTestCases/TS_001/TC_001")
    public void TC_001(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a")).click();

        String currentUrl=driver.getCurrentUrl();


        try {
            Assertions.assertEquals("http://localhost:57880/", currentUrl);
            test.log(Status.PASS, "Expected: DashBorad");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: " + currentUrl);

            throw e;
        }

    }

    @Test// Test case 2 invalid username and valid password
    @DisplayName("LoginPage/TS_001/TC_002")
    public void TC_002(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/a")).click();

        String currentUrl=driver.getCurrentUrl();


        try {
            Assertions.assertEquals("http://localhost:57880/", currentUrl);
            test.log(Status.PASS, " Expected");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: " + currentUrl);

            throw e;
        }
    }

    @Test// Test case 3 valid password and invalid password
    @DisplayName("LoginPage/TS_001/TC_003")
    public void TC_003(){
        driver.findElement(By.xpath("//*[@id=\"logoutButtonContainer\"]/button")).click();

        String currentUrl=driver.getCurrentUrl();


        try {
            Assertions.assertEquals("http://localhost:57880/home/login", currentUrl);
            test.log(Status.PASS, "expected");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: " + currentUrl);

            throw e;
        }

    }

    @Test// Test case 4 invalid username and password
    @DisplayName("LoginPage/TS_001/TC_004")
    public void TC_004(){
        driver.findElement(By.xpath("/html/body/div[2]/div/center/div/a")).click();

        String currentUrl=driver.getCurrentUrl();


        try {
            Assertions.assertEquals("http://localhost:57880/Home/Login", currentUrl);
            test.log(Status.PASS, "expected");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: " + currentUrl);

            throw e;
        }

    }











    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {
            driver.quit();
        }
    }
}
