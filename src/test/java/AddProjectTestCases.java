import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddProjectTestCases {
    WebDriver driver=new ChromeDriver();
    @BeforeEach
    public void setUp(){
        driver.get("http://localhost:57880/");
        driver.findElement(By.id("userid")).sendKeys("1");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"login-form\"]/form/button")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("btnTasks")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }




    @Test
    public void TC_001(){
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/a[1]")).click();

    }
    @Test
    public void TC_002(){
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/ul/li[1]/a")).click();

    }
    @Test
    public void TC_003(){
        driver.findElement(By.xpath("//*[@id=\"logoutButtonContainer\"]/button")).click();

    }
    @Test // not completed
    public void TC_005(){
        driver.findElement(By.id("projectId")).sendKeys("9");
        driver.findElement(By.id("projectName")).sendKeys("Pro");
        driver.findElement(By.id("projectDescription")).sendKeys("ProDesc");
        driver.findElement(By.id("hoursAllocated")).sendKeys("7");
        driver.findElement(By.xpath("/html/body/div[2]/div/form/button")).click();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        Alert alert= driver.switchTo().alert();
        String aletMsg= alert.getText();
        Assertions.assertEquals("Project added sucessfully",aletMsg);

    }
    @Test
    public void TC_006(){
        driver.findElement(By.id("projectId")).sendKeys("");
        driver.findElement(By.id("projectName")).sendKeys("");
        driver.findElement(By.id("projectDescription")).sendKeys("");
        driver.findElement(By.id("hoursAllocated")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div[2]/div/form/button")).click();
        String Msg= driver.findElement(By.id("projectId")).getAttribute("validationMessage");
        Assertions.assertEquals("Please fill out this field.",Msg);

    }
    @Test
    public void TC_007(){ // not completed
        driver.findElement(By.id("projectId")).sendKeys("a1");
        driver.findElement(By.id("projectName")).sendKeys("pro");
        driver.findElement(By.id("projectDescription")).sendKeys("des");
        driver.findElement(By.id("hoursAllocated")).sendKeys("b");
        driver.findElement(By.xpath("/html/body/div[2]/div/form/button")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(driver.switchTo().alert().getText());
        //String Msg= driver.findElement(By.id("hoursAllocated")).getAttribute("validationMessage");
        //Assertions.assertEquals("Please enter a number",Msg);

    }

    @Test
    public void TC_008(){
        driver.findElement(By.xpath("/html/body/div[2]/div/p/a")).click();

    }
    @Test
    public void TC_009(){
        Boolean flag=false;

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div/p/a")).click();
        List<WebElement> tableElements= driver.findElements(By.tagName("tr"));

        for (WebElement i:tableElements) {
            List<WebElement> cell=i.findElements(By.tagName("td"));
            for (WebElement j:cell) {
                if(j.getText().contains("asd")){
                    flag=true;
                    break;

                }



            }
            if(flag){
                break;
            }


        }

        Assertions.assertEquals(true,flag);


    }





    @AfterEach
    public void tearDown(){
        driver.quit();

    }


}
