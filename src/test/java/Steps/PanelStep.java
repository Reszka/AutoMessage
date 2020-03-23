package Steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PanelStep {

    WebDriver driver;

    @Before
    public void SetUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();

        /*System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();*/
    }

    @After
    public void ClosingTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Closing the browser");
        driver.close();
        driver.quit();
    }

    @And("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.out.print("Navigate Login Page");
        driver.navigate().to("https://www.tidio.com/panel/login.html");
    }

    @And("I enter the username as {string} and password as {string} and log in")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) {
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='form__button']")).submit();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("app-content-header")));
    }

    @And("I navigate to conversations page")
    public void iNavigateToConversationsPage() {
        driver.navigate().to("https://www.tidio.com/panel/conversations/");
    }

    @Then("I confirm receiving the message")
    public void iConfirmReceivingTheMessage() {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'hide-dropdown')]")));
        driver.findElement(By.xpath("//a[contains(@class,'hide-dropdown')]")).click();
        WebElement replyMessage =  driver.findElement(By.xpath("//textarea[@placeholder='Enter your message...']"));
        replyMessage.sendKeys("Potwierdzamy otrzymanie wiadomości.");
        replyMessage.sendKeys(Keys.ENTER);
    }
}
