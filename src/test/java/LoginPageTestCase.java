import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LoginPageTestCase extends BaseClass{
   public WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void setUp(){
        test=reports.createTest("Login pages test cases");
        driver.get("http://localhost:57880/Home/Login");

    }
    @Test  //  Test case 1 Vaild Username and Password
    @DisplayName("LoginPage/TS_001/TC_001")
    public void TC_001(){
        driver.findElement(By.id("userid")).sendKeys("1");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String titleName=driver.getTitle();


        try {
            Assertions.assertEquals("DashBorad", titleName);
            test.log(Status.PASS, "Title is as expected: DashBorad");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Title is not as expected: " + titleName);

            throw e;
        }

    }

    @Test// Test case 2 invalid username and valid password
    @DisplayName("LoginPage/TS_001/TC_002")
    public void TC_002(){
        driver.findElement(By.id("userid")).sendKeys("2");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        Alert alert=driver.switchTo().alert();
        String alertMsg=alert.getText();
        alert.accept();

        //System.out.println(alertMsg);
        try {
            Assertions.assertEquals("Login failed: Login failed", alertMsg);
            test.log(Status.PASS, "Expected: Login failed: Login failed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: It should come" + alertMsg);

            throw e;
        }

    }

    @Test// Test case 3 valid password and invalid password
    @DisplayName("LoginPage/TS_001/TC_003")
    public void TC_003(){
        driver.findElement(By.id("userid")).sendKeys("1");
        driver.findElement(By.id("password")).sendKeys("1233");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Alert alert=driver.switchTo().alert();
        String alertMsg=alert.getText();
        alert.accept();

        //System.out.println(alertMsg);
        try {
            Assertions.assertEquals("Login failed: Login failed", alertMsg);
            test.log(Status.PASS, "Expected: Login failed: Login failed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: It should come " + alertMsg);

            throw e;
        }

    }

    @Test// Test case 4 invalid username and password
    @DisplayName("LoginPage/TS_001/TC_004")
    public void TC_004(){
        driver.findElement(By.id("userid")).sendKeys("2");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Alert alert=driver.switchTo().alert();
        String alertMsg=alert.getText();
        alert.accept();
        //System.out.println(alertMsg);
        try {
            Assertions.assertEquals("Login failed: Login failed", alertMsg);
            test.log(Status.PASS, "Expected: Login failed: Login failed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: It should come " + alertMsg);

            throw e;
        }

    }




    @Test // Test case 5 Enter the case sensitive password
    @DisplayName("LoginPage/TS_001/TC_006")
    public void TC_005(){
        driver.findElement(By.id("userid")).sendKeys("2");
        driver.findElement(By.id("password")).sendKeys("ABC");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Alert alert=driver.switchTo().alert();
        String alertMsg=alert.getText();
        alert.accept();
        //System.out.println(alertMsg);
        try {
            Assertions.assertEquals("Login failed: Login failed", alertMsg);
            test.log(Status.PASS, "Expected: Login failed: Login failed");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: It should come" + alertMsg);

            throw e;
        }

    }

    @Test//Test case 6 leave the username empty and click it
    @DisplayName("LoginPage/TS_001/TC_007")
    public void TC_006(){
       driver.findElement(By.id("userid")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String message = driver.findElement(By.name("userid")).getAttribute("validationMessage");
        try {
            Assertions.assertEquals("Please fill out this field.", message);
            test.log(Status.PASS, "Expected: Please fill out this field.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: " + message);

            throw e;
        }


    }

    @Test//Test case 7 leave the password empty and click it
    @DisplayName("LoginPage/TS_001/TC_008")
    public void TC_007(){
        driver.findElement(By.id("userid")).sendKeys("1");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String message = driver.findElement(By.name("password")).getAttribute("validationMessage");
        try {
            Assertions.assertEquals("Please fill out this field.", message);
            test.log(Status.PASS, "Expected: Please fill out this field.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: " + message);

            throw e;
        }

    }
    @Test//Test case 8 leave the password and username empty and click it
    @DisplayName("LoginPage/TS_001/TC_008")
    public void TC_008(){
        driver.findElement(By.id("userid")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String message = driver.findElement(By.name("password")).getAttribute("validationMessage");
        try {
            Assertions.assertEquals("Please fill out this field.", message);
            test.log(Status.PASS, "Expected: Please fill out this field.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Unexpected: " + message);

            throw e;
        }

    }






    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
