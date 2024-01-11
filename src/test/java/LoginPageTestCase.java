import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginPageTestCase {
   public WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void setUp(){
        driver.get("http://localhost:57880/");
    }
    @Test  //  Test case 1 Vaild Username and Password
    @DisplayName("LoginPage/TS_001/TC_001")
    public void TC_001(){
        driver.findElement(By.id("username")).sendKeys("sam");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String titleName=driver.getTitle();
        Assertions.assertEquals(titleName,"DashBorad");
    }

    @Test// Test case 2 invalid username and valid password
    @DisplayName("LoginPage/TS_001/TC_002")
    public void TC_002(){
        driver.findElement(By.id("username")).sendKeys("samvel");
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
        Assertions.assertEquals(alertMsg,"Login failed: Login failed");

    }

    @Test// Test case 3 valid password and invalid password
    @DisplayName("LoginPage/TS_001/TC_003")
    public void TC_003(){
        driver.findElement(By.id("username")).sendKeys("sam");
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
        Assertions.assertEquals(alertMsg,"Login failed: Login failed");

    }

    @Test// Test case 4 invalid username and password
    @DisplayName("LoginPage/TS_001/TC_004")
    public void TC_004(){
        driver.findElement(By.id("username")).sendKeys("samvel");
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
        Assertions.assertEquals(alertMsg,"Login failed: Login failed");

    }


    @Test// Test case 5 Enter the case sensitive username
    @DisplayName("LoginPage/TS_001/TC_005")
    public void TC_005(){
        driver.findElement(By.id("username")).sendKeys("SAM");
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
        Assertions.assertEquals(alertMsg,"Login failed: Login failed");
    }

    @Test // Test case 6 Enter the case sensitive password
    @DisplayName("LoginPage/TS_001/TC_006")
    public void TC_006(){
        driver.findElement(By.id("username")).sendKeys("akash");
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
        Assertions.assertEquals(alertMsg,"Login failed: Login failed");

    }

    @Test//Test case 7 leave the username empty and click it
    @DisplayName("LoginPage/TS_001/TC_007")
    public void TC_007(){
       driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("abc");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        String message = driver.findElement(By.name("username")).getAttribute("validationMessage");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(message);

        Assertions.assertEquals(message,"Please fill out this field.");

    }

    @Test//Test case 8 leave the password empty and click it
    @DisplayName("LoginPage/TS_001/TC_008")
    public void TC_008(){
        driver.findElement(By.id("username")).sendKeys("sam");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        String message = driver.findElement(By.name("password")).getAttribute("validationMessage");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(message);

        Assertions.assertEquals(message,"Please fill out this field.");

    }
    @Test//Test case 9 leave the password and username empty and click it
    @DisplayName("LoginPage/TS_001/TC_008")
    public void TC_009(){
        driver.findElement(By.id("username")).sendKeys("s");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        String message = driver.findElement(By.name("password")).getAttribute("validationMessage");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println(message);

        Assertions.assertEquals(message,"Please fill out this field.");

    }






    @AfterEach
    public void tearDown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
