import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectingAddOrViewTestCases {
    public ChromeDriver driver = new ChromeDriver();
    @BeforeEach
    public void setUp(){
        driver.get("");
    }

    @Test
    @DisplayName("Select/TS_/TC_001")
    public void STC_001(){
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }
    @Test
    @DisplayName("Select/TS_/TC_002")
    public void STC_002(){
        driver.findElement(By.id("")).click();
        Assertions.assertEquals("","");

    }
    @Test
    @DisplayName("Select/TS_/TC_003")
    public void STC_003(){
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
