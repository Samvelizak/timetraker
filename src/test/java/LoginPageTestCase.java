import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    @Test  //  Test case 1
    @DisplayName("")
    public void TC_001(){


    }

    @Test// Test case 2
    @DisplayName("")
    public void TC_002(){

    }

    @Test// Test case 3
    @DisplayName("")
    public void TC_003(){

    }

    @Test// Test case 4
    @DisplayName("")
    public void TC_004(){

    }

    @Test// Test case 5
    @DisplayName("")
    public void TC_005(){

    }

    @Test// Test case 6
    @DisplayName("")
    public void TC_006(){

    }


    @Test

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
