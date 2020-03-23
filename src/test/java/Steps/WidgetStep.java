package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.Date;

public class WidgetStep {

    WebDriver driver;

    @Before
    public void SetUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : Chrome");
        driver.close();
        driver.quit();
    }

    @Given("I navigate to widget page")
    public void iNavigateToWidgetPage() {
        System.out.print("Navigate Chat Page");
        driver.navigate().to("https://widget-v4.tidiochat.com/preview.html?code=4cydyg5ubfb3qqcdbfu16cyytczaxlds");
    }

   /* @And("I send message on widget page")
    public void sendMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("tidio-chat-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-message-button-fly")));
        driver.findElement(By.id("new-message-button-fly")).click();
        driver.findElement(By.id("new-message-textarea"));
        WebElement messageBox =  driver.findElement(By.id("new-message-textarea"));
        messageBox.sendKeys("Bardzo miła wiadomość testowa.");
        messageBox.sendKeys(Keys.ENTER);

        public class emailID{
           Date now = new Date();
           long unixTime = System.currentTimeMillis()/1000L;
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Podaj swój email...']")));
        driver.findElement(By.xpath("//input[@placeholder='Podaj swój email...']"));
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Podaj swój email...']"));
        email.sendKeys("bardzo@testowy.mail");
        email.sendKeys(Keys.ENTER);

    }*/

    @And("I send message with my email on widget page")
    public void iSendMessageWithMyEmailOnWidgetPage() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("tidio-chat-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-message-button-fly")));
        driver.findElement(By.id("new-message-button-fly")).click();
        driver.findElement(By.id("new-message-textarea"));
        WebElement messageBox =  driver.findElement(By.id("new-message-textarea"));
        messageBox.sendKeys("Bardzo miła wiadomość testowa.");
        messageBox.sendKeys(Keys.ENTER);

        long unixTime = System.currentTimeMillis() / 1000L;
        String emailId = "test"+unixTime+"@test.pl";
        System.out.println(emailId);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Podaj swój email...']")));
        driver.findElement(By.xpath("//input[@placeholder='Podaj swój email...']"));
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Podaj swój email...']"));
        email.sendKeys(emailId);
        email.sendKeys(Keys.ENTER);


    }
}
