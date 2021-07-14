package ru.training.at.hw6.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver webdriver = (WebDriver) result.getTestContext().getAttribute("webdriver");
        attachScreenShot(webdriver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenShot(WebDriver webdriver) {
        return ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
    }
}
