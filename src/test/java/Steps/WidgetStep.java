package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser : Firefox");
    }

    @Given("I navigate to widget page")
    public void iNavigateToWidgetPage() {
        System.out.print("Navigate Chat Page");
        driver.navigate().to("https://widget-v4.tidiochat.com/preview.html?code=4cydyg5ubfb3qqcdbfu16cyytczaxlds");
    }

    @Then("I send message on widget page")
    public void sendMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#tidio-chat-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div:nth-child(1) div.frame-content div.widget-position-right.sidebar-position-right div.flyMessage.chrome.moveFromRight-enter-done > div.message-container")));
        driver.findElement(By.id("new-message-button-fly")).click();
        driver.findElement(By.id("new-message-textarea"));
        WebElement messageBox =  driver.findElement(By.id("new-message-textarea"));
        messageBox.sendKeys("Bardzo miła wiadomość testowa.");
        messageBox.sendKeys(Keys.ENTER);
    }
}
