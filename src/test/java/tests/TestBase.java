package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {

    @BeforeAll
    static void setUp() throws Exception {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        String selenoidLogin = config.selenoidLogin();
        String selenoidPassword = config.selenoidPassword();
        String selenoidServer = System.getProperty("selenoid_server", "selenoid.autotests.cloud/wd/hub");
        Configuration.baseUrl = "https://www.tutu.ru/";
        Configuration.browserSize = System.getProperty("browserSize", "1980x1024");
        Configuration.remote = "https://" + selenoidLogin + ":" + selenoidPassword + "@" +
                selenoidServer;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadTimeout = (500000);
    }

@BeforeEach
void openBaseUrl() {
        open("https://www.tutu.ru/");
}


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
