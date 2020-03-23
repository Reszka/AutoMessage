package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageReceivedConfirmStep extends BaseUtil {

    private BaseUtil base;

    public MessageReceivedConfirmStep(BaseUtil base) {
        this.base = base;
    }

    @Given("I navigate to widget page")
    public void iNavigateToWidgetPage() {
        System.out.print("Navigate Chat Page");
        base.Driver1.navigate().to("https://widget-v4.tidiochat.com/preview.html?code=4cydyg5ubfb3qqcdbfu16cyytczaxlds");
    }

    @And("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        System.out.print("Navigate Login Page");
        base.Driver2.navigate().to("https://www.tidio.com/panel/login.html");
    }

    @And("I enter the username as {string} and password as {string} and log in")
    public void iEnterTheUsernameAsAndPasswordAs(String username, String password) {
        base.Driver2.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(username);
        base.Driver2.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        base.Driver2.findElement(By.xpath("//button[@class='form__button']")).submit();

        WebDriverWait wait = new WebDriverWait(base.Driver2, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("app-content-header")));
    }

    @And("I send message with my email on widget page")
    public void iSendMessageWithMyEmailOnWidgetPage() {

        WebDriverWait wait = new WebDriverWait(base.Driver1, 20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("tidio-chat-iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-message-button-fly")));
        base.Driver1.findElement(By.id("new-message-button-fly")).click();
        base.Driver1.findElement(By.id("new-message-textarea"));
        WebElement messageBox =  base.Driver1.findElement(By.id("new-message-textarea"));
        messageBox.sendKeys("Bardzo miła wiadomość testowa.");
        messageBox.sendKeys(Keys.ENTER);

        long unixTime = System.currentTimeMillis() / 1000L;
        String emailId = "test"+unixTime+"@test.pl";
        System.out.println(emailId);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Podaj swój email...']")));
        base.Driver1.findElement(By.xpath("//input[@placeholder='Podaj swój email...']"));
        WebElement email = base.Driver1.findElement(By.xpath("//input[@placeholder='Podaj swój email...']"));
        email.sendKeys(emailId);
        email.sendKeys(Keys.ENTER);
    }
    @And("I navigate to conversations page")
    public void iNavigateToConversationsPage() {
        base.Driver2.navigate().to("https://www.tidio.com/panel/conversations/");
    }

    @Then("I confirm receiving the message")
    public void iConfirmReceivingTheMessage() {

        WebDriverWait wait = new WebDriverWait(base.Driver2, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'hide-dropdown')]")));
        base.Driver2.findElement(By.xpath("//a[contains(@class,'hide-dropdown')]")).click();
        WebElement replyMessage =  base.Driver2.findElement(By.xpath("//textarea[@placeholder='Enter your message...']"));
        replyMessage.sendKeys("Potwierdzamy otrzymanie wiadomości.");
        replyMessage.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Potwierdzamy otrzymanie wiadomo')]")));
    }
}


