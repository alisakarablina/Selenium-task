package first_test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ICanWinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
     public void browserSetUp(){
         driver = new ChromeDriver();
    }

    @Test (description = "Create paste test")
    public void commonResults() {

 //Opening pastebin.com
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");

 //Entering "Hellow from webdriver" text into "New Paste" field
        WebElement textInputNewPaste = driver.findElement(By.id("postform-text"));
        textInputNewPaste.sendKeys("Hello from WebDriver");

 //Selecting 10 minutes from "Paste Expiration" dropdown
        WebElement tenMin = driver.findElement(By.id("postform-expiration"));
        Select select = new Select(tenMin);
        select.selectByVisibleText("10 Minutes");

//Entering "helloweb" into "Paste Name/Title" field
        WebElement textInputTitle = driver.findElement(By.id("postform-name"));
        textInputTitle.sendKeys("helloweb");

//Taping on "Create new paste" button
        WebElement createNewPasteBtn = driver.findElement(By.xpath(".//*[text()='Create New Paste']"));
        createNewPasteBtn.click();

    }

    @AfterMethod(alwaysRun = true)
    public void browserDown(){
      driver.quit();
      driver =  null;
      }
}
