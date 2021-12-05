import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class ICanWin {
    public static void main(String[] args) throws InterruptedException {

 //Opening pastebin.com
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

 //Entering "Hellow from webdriver" text into "New Paste" field
        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("Hello from WebDriver");

 //doesn't work
 //Selecting 10 minutes from "Paste Expiration" dropdown
        WebElement tenMin = driver.findElement(By.id("postform-expiration"));
        Select select = new Select(tenMin);
        select.selectByVisibleText("10 Minutes");

//Entering "helloweb" into "Paste Name/Title" field
        WebElement searchInput2 = driver.findElement(By.id("postform-name"));
        searchInput2.sendKeys("helloweb");

//Taping on "Create new paste" button
        WebElement createNewPasteBtn = driver.findElement(By.xpath(".//*[text()='Create New Paste']"));
        createNewPasteBtn.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
