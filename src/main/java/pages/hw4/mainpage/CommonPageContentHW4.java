package pages.hw4.mainpage;

import org.openqa.selenium.WebDriver;
import pages.hw4.AbstractPageHW4;

public class CommonPageContentHW4 extends AbstractPageHW4 {

    public CommonPageContentHW4(WebDriver webdriver) {
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