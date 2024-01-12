import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SelectingAddOrViewTestCases {
    public ChromeDriver driver = new ChromeDriver();
    @BeforeEach
    public void setUp(){
        driver.get("http://localhost:57880/");
        driver.findElement(By.id("username")).sendKeys("sam");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Select/TS_/TC_001")
    public void STC_001(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"http://localhost:57880/Home/Index");
        //Assertions.assertEquals(currentUrl,"");

    }
    @Test
    @DisplayName("Select/TS_/TC_002")
    public void STC_002(){
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("li:nth-child(1) a:nth-child(1)")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"http://localhost:57880/Home/Index");
    }

    @Test
    @DisplayName("Select/TS_/TC_003")
    public void STC_003(){
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[2]/a")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"http://localhost:57880/");



    }
    @Test
    @DisplayName("Select/TS_/TC_004")
    public void STC_004() {
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"logoutButtonContainer\"]/button")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"http://localhost:57880/home/login");
    }
    @Test
    @DisplayName("Select/TS_/TC_005")
    public void STC_005() {
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("btnHome")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"http://localhost:57880/Home/addwork");
    }
    @Test
    @DisplayName("Select/TS_/TC_006")
    public void STC_006() {
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("btnTasks")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"http://localhost:57880/Home/addproject");
    }
    @Test
    @DisplayName("Select/TS_/TC_007")
    public void STC_007() {

        driver.findElement(By.id("btnReports")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl,"http://localhost:57880/Home/report");
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
