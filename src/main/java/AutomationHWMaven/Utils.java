package AutomationHWMaven;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.jetty9.util.IO;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.seleniumhq.jetty9.util.IO.copyFile;

public class Utils extends BasePage {


    //1.To enter text
    public void enterText(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    //2. To get Text from the Element
    public String getTextFromElement(By by) {

        String text = driver.findElement(by).getText();

        return text;

    }

    //3. To click an Element
    public void clickElement(By by) {

        driver.findElement(by).click();
    }

    //4. To clear text and enter text
    public static void clearAndEnterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //5. To select by Visible Text
    public void selectByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));

        select.selectByVisibleText(text);

    }

    //6. To select by Value
    public void selectByValue(By by, String value) {

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);

    }

    //7. To select by Index
    public void selectByIndex(By by, int i) {


        WebElement mySelectElm = driver.findElement(by);
        Select mySelect = new Select(mySelectElm);
        mySelect.selectByIndex(i);


    }

    //8. Waiting for the element to be Clickable
    public void waitForClickable(long time, By by) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //9. Waiting for the element to be visible
    public void waitForElementVisible(By by, long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    //10. Waiting for the element to be Invisible
    public static void waitForElementToBeInvisible(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    //11. Waiting for the Alert to be Present
    public void waitForAlertPresent(long time) {

        WebDriverWait wait = new WebDriverWait(driver, time);

        wait.until(ExpectedConditions.alertIsPresent());


    }

    //12. For Time stamp
    public static String timeStamp() {
        DateFormat format = new SimpleDateFormat("ddMMyyHHmmSS");
        return format.format(new Date());
    }


    //13. Waiting for the Element to Load
    public static void waitForElementToLoad(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //14. Waiting for the Element to be displayed
    public static void waitForElementToBeDisplayed(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    //15. To wait and click
    public static void waitAndClick(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).click();
    }

    //16. To check Text present in DOM
    public static void textPresentInDom() {
        if (driver.getPageSource().contains("Text to check")) {
            System.out.println("Text is present");
        } else {
            System.out.println("Text is absent");
        }
    }

    public static void getTextFromTitle() {
        String title = driver.getTitle();
    }

    public static void getAttribute(By by, String text) {
        driver.findElement(by).getAttribute(text);
    }

    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

        //Convert webdriver object to take screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        //call getscreehshotas method to create image file
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new location
        File DestFile = new File(fileWithPath);

        //copy file at destination
        IO FileUtils;
        copyFile(srcFile, DestFile);

    }

    public static void takeScreenShotOfBrowser(IO FileUtils) {

        File scrFile5 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(scrFile5, new File("C:\\test.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getCSSValue(By by, String text) {

        driver.findElement(by).getCssValue(text);
    }

    // Wait method
    public static void sleep(final long millis) {
        System.out.println((String.format("sleeping %d ms", millis)));
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


    }
}
