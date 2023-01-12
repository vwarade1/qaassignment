package WebPageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vwara\\Downloads\\chromedriver_win32\\chromedriver.exe");

        
        driver = new ChromeDriver();

        driver.get("https://sakshingp.github.io/assignment/login.html");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("log-in"));
        username.sendKeys("admin");
        password.sendKeys("pass");
        loginButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSortTable() {
        
        WebElement amountHeader = driver.findElement(By.id("amount"));

       
        amountHeader.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        boolean isSorted = true;
        WebElement previousAmount = null;
        for (WebElement amount : driver.findElements(By.cssSelector("#transaction-table td.amount-column"))) {
            if (previousAmount != null) {
                if (Double.parseDouble(amount.getText()) < Double.parseDouble(previousAmount.getText())) {
                    isSorted = false;
                    break;
                }
            }
            previousAmount = amount;
        }
        Assert.assertTrue(isSorted);
    }

    @AfterMethod
    public void teardown() 
    {
        driver.quit();
    }
}
