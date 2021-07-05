package pages.mainpage;

import org.openqa.selenium.WebDriver;
import pages.AbstractPage;

public class CommonPageContent extends AbstractPage {

    public CommonPageContent(WebDriver webdriver) {
        super(webdriver);
    }

    public void openPage(String mainPageURL) {
        webdriver.navigate().to(mainPageURL);
    }

    public String checkPageTitle() {
        return webdriver.getTitle();
    }

    public void switchToMainPage() {
        webdriver.switchTo().defaultContent();
    }
}
