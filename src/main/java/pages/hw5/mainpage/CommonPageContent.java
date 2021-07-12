package pages.hw5.mainpage;

import org.openqa.selenium.WebDriver;
import pages.hw5.AbstractPage;

public class CommonPageContent extends AbstractPage {
    public CommonPageContent(WebDriver webdriver) {
        super(webdriver);
    }

    public void openPage() {
        webdriver.navigate().to(mainPageURL);
    }

    public String checkPageTitle() {
        return webdriver.getTitle();
    }

    public void switchToMainPage() {
        webdriver.switchTo().defaultContent();
    }
}
