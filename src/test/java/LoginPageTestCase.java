import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPageTestCase {
   public WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void setUp(){
        driver.get("");
    }
    @Test  //  Test case 1 Vaild Username and Password
    @DisplayName("LoginPage/TS_001/TC_001")
    public void TC_001(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");



    }

    @Test// Test case 2 invalid username and valid password
    @DisplayName("LoginPage/TS_001/TC_002")
    public void TC_002(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }

    @Test// Test case 3 valid password and invalid password
    @DisplayName("LoginPage/TS_001/TC_003")
    public void TC_003(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }

    @Test// Test case 4 invalid username and password
    @DisplayName("LoginPage/TS_001/TC_004")
    public void TC_004(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }


    @Test// Test case 6 To exceed the data length of username
    @DisplayName("LoginPage/TS_001/TC_005")
    public void TC_005(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }
    @Test // Test case 7 To exceed the data length of password
    @DisplayName("LoginPage/TS_001/TC_006")
    public void TC_006(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }

    @Test//Test case 8 leave the username empty and click it
    @DisplayName("LoginPage/TS_001/TC_007")
    public void TC_007(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }

    @Test//Test case 9 leave the password empty and click it
    @DisplayName("LoginPage/TS_001/TC_008")
    public void TC_008(){
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).sendKeys("");
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

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
