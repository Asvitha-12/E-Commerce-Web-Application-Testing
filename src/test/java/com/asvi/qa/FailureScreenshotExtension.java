package com.asvi.qa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class FailureScreenshotExtension
        implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isEmpty()) {
            return;
        }

        Object testInstance = context.getTestInstance().orElse(null);

        if (!(testInstance instanceof BaseTest)) {
            return;
        }

        BaseTest baseTest = (BaseTest) testInstance;
        WebDriver driver = baseTest.getDriver();

        if (driver == null || !(driver instanceof TakesScreenshot)) {
            return;
        }

        try {
            Path screenshotDirectory =
                    Paths.get("screenshots", "failures");

            Files.createDirectories(screenshotDirectory);

            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String testName = context.getRequiredTestClass().getSimpleName()
                    + "_" + context.getRequiredTestMethod().getName();

            Path screenshotPath = screenshotDirectory.resolve(
                    testName + "_" + timestamp + ".png");

            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            Files.write(screenshotPath, screenshot);

            System.out.println("Failure screenshot saved: "
                    + screenshotPath.toAbsolutePath());

        } catch (IOException | RuntimeException exception) {
            System.err.println("Could not capture failure screenshot: "
                    + exception.getMessage());
        }
    }
}