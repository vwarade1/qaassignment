package WebPageTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
 
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Vwara\\Downloads\\chromedriver_win32\\chromedriver.exe");
 
        driver = new ChromeDriver();

        driver.get("https://sakshingp.github.io/assignment/login.html");
    }


    @Test
    public void testBlankUsername() {
    	
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("log-in"));

        password.sendKeys("pass");

        loginButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://sakshingp.github.io/assignment/login.html");
    }

    @Test
    public void testBlankPassword() {
        
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("log-in"));
        
        username.sendKeys("admin");

        	   loginButton.click();
        	    
        	   try {
        	        Thread.sleep(3000);
        	    } catch (InterruptedException e) {
        	        e.printStackTrace();
        	    }

        	    Assert.assertEquals(driver.getCurrentUrl(), "https://sakshingp.github.io/assignment/login.html");
        	}
    @Test
    public void testSuccessfulLogin() {
     
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

        Assert.assertEquals(driver.getCurrentUrl(), "https://sakshingp.github.io/assignment/home.html");
    }


        	@AfterMethod
        	public void teardown() 
        	{
        		
        	    driver.quit();
        	}

    }
