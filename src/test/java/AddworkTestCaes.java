import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddworkTestCaes {
    public WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void setUp(){
        driver.get("http://localhost:57880/");
        driver.findElement(By.id("userid")).sendKeys("1");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("btnHome")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test  //  Test case 1
    public void TC_001(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/a")).click();
    }
    @Test  //  Test case 1
    public void TC_002(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/a")).click();
    }
    @Test  //  Test case 1
    public void TC_003(){
        driver.findElement(By.xpath("//*[@id=\"loginHere\"]/a")).click();
    }
    @Test  //  Test case 1
    public void TC_004(){
        driver.findElement(By.xpath("//*[@id=\"logoutButtonContainer\"]/button")).click();
    }
    @Test  //  Test case 1
    public void TC_005(){
        driver.findElement(By.xpath("//*[@id=\"logoutButtonContainer\"]/button")).click();
    }
    @Test  //  Test case 1
    public void TC_006() {
       WebElement element= driver.findElement(By.id("projectName"));
        Select dropdown= new Select(element);
        dropdown.selectByVisibleText("Project 3");
        String dropDownValue=driver.findElement(By.xpath("//*[@id=\"projectName\"]/option[3]")).getText();
        Assertions.assertEquals("Project 3",dropDownValue);

    }
    @Test  //  Test case 1
    public void TC_007(){
       WebElement date=driver.findElement(By.xpath("//*[@id=\"workDate\"]"));
       date.sendKeys("24-11-2002");
       //String fDate=date.getAttribute("value");
        //Assertions.assertEquals("24-11-2002",fDate);
    }
    @Test  //  Test case 1
    public void TC_008(){
        WebElement element= driver.findElement(By.id("projectId"));
        Select dropdown= new Select(element);
        dropdown.selectByVisibleText("4");
        driver.findElement(By.id("workDescription")).sendKeys("first project");
        driver.findElement(By.xpath("//*[@id=\"workDate\"]")).sendKeys("24-11-2002");;
        driver.findElement(By.id("hours")).sendKeys("3");
        driver.findElement(By.xpath("/html/body/div[2]/div/form/button")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert=driver.switchTo().alert();
        String alertMsg= alert.getText();
        //System.out.println(alertMsg);
        Assertions.assertEquals("Work added successfully",alertMsg);

    }
    @Test  //  Test case 1
    public void TC_009(){
        driver.findElement(By.id("workDescription")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"workDate\"]")).sendKeys("");;
        driver.findElement(By.id("hours")).sendKeys("");
        String message = driver.findElement(By.xpath("//*[@id=\"workDescription\"]")).getAttribute("validationMessage");
        Assertions.assertEquals("Please fill out this field.",message);
    }

    @Test  //  Test case 1
    public void TC_0010(){
        driver.findElement(By.xpath("/html/body/div[2]/div/p/a")).click();
        String currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:57880/Home/DashBorad",currentUrl);
    }

    @Test
    public void TC_011(){
        driver.findElement(By.xpath("/html/body/div[2]/div/p/a")).click();


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
