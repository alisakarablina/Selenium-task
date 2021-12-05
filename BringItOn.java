import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BringItOn {


        private WebDriver driver;

        @BeforeMethod(alwaysRun = true)
        public void browserSetUp(){
            driver = new ChromeDriver();
        }

        @Test
        public void commonResults() {

            //Opening pastebin.com
            driver = new ChromeDriver();
            driver.get("https://pastebin.com/");

            //Entering text into "New Paste" field
            WebElement textInputNewPaste = driver.findElement(By.id("postform-text"));
            textInputNewPaste.sendKeys("git config --global user.name 'New Sheriff in Town'" +
                    "git reset $(git commit-tree HEAD^{tree} -m 'Legacy code')" +
                    "git push origin master --force");

            //Selecting Bash
            WebElement selBash = driver.findElement(By.id("postform-format"));
            Select select = new Select(selBash);
            select.selectByVisibleText("Bash");

            //Selecting 10 minutes from "Paste Expiration" dropdown
            WebElement tenMin = driver.findElement(By.id("postform-expiration"));
            Select sel = new Select(tenMin);
            sel.selectByVisibleText("10 Minutes");

//Entering title into "Paste Name/Title" field
            WebElement textInputTitle = driver.findElement(By.id("postform-name"));
            textInputTitle.sendKeys("how to gain dominance among developers");

//Taping on "Create new paste" button
            WebElement createNewPasteBtn = driver.findElement(By.xpath(".//*[text()='Create New Paste']"));
            createNewPasteBtn.click();

            //checking title
            List<WebElement> titleResult = driver.findElements(By.xpath("//h1[text()='how to gain domiance among developers']"));
            System.out.println("Title" + titleResult.size());

            Assert.assertTrue("Title is not entered", titleResult.size()>0);


        }

        @AfterMethod(alwaysRun = true)
        public void browserDown(){
            driver.quit();
            driver =  null;
        }
    }


