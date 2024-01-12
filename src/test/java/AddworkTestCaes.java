import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AddWorkPageTestCase {
    public WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
                driver.get("http://localhost:57880/");
    }

    @Test 
    @DisplayName("AddWorkPage/TC_001 - Valid Work Entry")
    public void TC_001() {
      
    }

    @Test
    @DisplayName("AddWorkPage/TC_002 - Missing Project Name")
    public void TC_002() {
        
    }

    @Test
    @DisplayName("AddWorkPage/TC_003 - Invalid Date Format")
    public void TC_003() {
        
    }

    @Test
    @DisplayName("AddWorkPage/TC_004 - Invalid Hours (Negative Value)")
    public void TC_004() {
        
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
