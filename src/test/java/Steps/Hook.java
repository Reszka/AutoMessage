package Steps;

import Base.BaseUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void SetUpDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        base.Driver1 = new ChromeDriver();
        base.Driver2 = new ChromeDriver();
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println(scenario.getStatus());
        }

        System.out.println("Closing the browser");
        base.Driver1.close();
        base.Driver1.quit();
        base.Driver2.close();
        base.Driver2.quit();
    }
}
