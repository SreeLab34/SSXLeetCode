package demo;

import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
    ChromeDriver driver;
    public TestCases() throws MalformedURLException
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
        
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
         String currentURL = driver.getCurrentUrl();
         if (currentURL.contains("leetcode")) {
            System.out.println("Test case passed: URL contains 'leetcode'");
        } else {
            System.out.println("Test case failed: URL does not contain 'leetcode'");
        }
        System.out.println("end Test case: testCase01");
    }



    public void testCase02() throws InterruptedException
     {
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");
        String currentURL = driver.getCurrentUrl();
         if (currentURL.contains("leetcode")) {
            System.out.println("Test case passed: URL contains 'leetcode'");
        } else {
            System.out.println("Test case failed: URL does not contain 'leetcode'");
        }
        WebElement qts = driver.findElement(By.xpath("//p[@class='link'][text()='View Questions ']"));
        qts.click();
        Thread.sleep(5000);
        String currentURL1 = driver.getCurrentUrl();
         if (currentURL1.contains("problemset")) {
            System.out.println("Test case passed: URL contains 'problemset'");
        } else {
            System.out.println("Test case failed: URL does not contain 'problemset'");
        }
                Thread.sleep(5000);

        try
        {
        List<WebElement> questionElements = driver.findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
            int count = 1;
            int i=2;
            System.out.println("1st 5 questions:");

            for (WebElement element : questionElements) {
                if (count > 5) {
                    break;
                }
                WebElement titleElement = element.findElement(By.xpath("(//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s'])["+i+"]"));
                String questionTitle = titleElement.getText().trim();
                i++;
                  if (titleElement.getText().contains(questionTitle)) {
            System.out.println("pass");
        } else {
            System.out.println("fail");
        }
                // Print the title of each question
                System.out.println(questionTitle);

                count++;
            }
        } catch (Exception e) {
           System.out.println("Check");}
       
        System.out.println("End Test case: testCase02");
    }


    public void testCase03() throws InterruptedException
     {
        System.out.println("Start Test case: testCase03");
        driver.get("https://leetcode.com/");
         WebElement qts = driver.findElement(By.xpath("//p[@class='link'][text()='View Questions ']"));
        qts.click();
        Thread.sleep(5000);
       
        WebElement twoSum = driver.findElement(By.xpath("(//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s'])[2]"));
        twoSum.click();
        Thread.sleep(5000);
        String currentURL = driver.getCurrentUrl();
         if (currentURL.contains("two-sum")) {
            System.out.println("Test case passed: URL contains 'two-sum'");
        } else {
            System.out.println("Test case failed: URL does not contain 'two-sum'");
        }
                System.out.println("End Test case: testCase03");

     }

    public void testCase04() throws InterruptedException
     {
        System.out.println("Start Test case: testCase04");
        driver.get("https://leetcode.com/");
         WebElement qts = driver.findElement(By.xpath("//p[@class='link'][text()='View Questions ']"));
        qts.click();
        Thread.sleep(5000);
       
        WebElement twoSum = driver.findElement(By.xpath("(//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s'])[2]"));
        twoSum.click();
        Thread.sleep(5000);
        WebElement subm = driver.findElement(By.xpath("//div[@class='normal absolute left-0 top-0 whitespace-nowrap font-normal'][text()='Submissions']"));
        subm.click();
        WebElement reg = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));

        Thread.sleep(5000);
         if (reg.getText().contains("Register or Sign In")) {
            System.out.println("Test case passed: URL contains 'Register or Sign In'");
        } else {
            System.out.println("Test case failed: URL does not contain 'Register or Sign In'");
        }
       
                System.out.println("End Test case: testCase04");

     }


}
