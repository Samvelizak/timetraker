import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewPageTestCase {
    public WebDriver driver = new ChromeDriver();

    @BeforeEach
    public void setUp() {
       
    }

    @Test
    @DisplayName("ViewPage/TC_001 - View Work Entries")
    public void TC_001() {
       
    }

    @Test
    @DisplayName("ViewPage/TC_002 - Filter Work Entries")
    public void TC_002() {
       
    }

    @Test
    @DisplayName("ViewPage/TC_003 - Export Work Entries")
    public void TC_003() {
        
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
