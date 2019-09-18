package AutomationHWMaven;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Double.parseDouble;
import static org.assertj.core.api.Assertions.*;
import static org.openqa.selenium.By.partialLinkText;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AutomationHW extends Utils {

    LoadProp props = new LoadProp();


    @BeforeMethod

    public void openBrowser() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\Resources\\BrowserDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        //Maximise the browser window screen
        driver.manage().window().fullscreen();
        //implicity wait for driver object
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //open website

        //driver.get("https://demo.nopcommerce.com/");

        driver.get((String) props.getProperty("url"));

    }


        @AfterMethod()
        public void closeBrowser () {
            //browser close
            driver.quit();
        }

        @Test(priority = 0)
        public  void userShouldBeAbleToLogInSuccessfully() {


            //driver.findElement(By.xpath("//a[@class='ico-register']")).click();
            //clickElement(By.xpath("//a[@class='ico-register']"));
            clickElement(By.linkText("Register"));

            //select radio button
            //driver.findElement(By.xpath("//input[@id='gender-male']")).click();
            clickElement(By.xpath("//input[@id='gender-male']"));


            //First Name
            //driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Ramakant");
            enterText(By.xpath("//input[@id='FirstName']"), props.getProperty("Firstname"));


            //Last name
            //driver.findElement(By.id("LastName")).sendKeys("Sahay");
            enterText(By.id("LastName"), props.getProperty("lastname"));

            //Dropdown box
            //Day drop box select
            // Select Day = new Select(driver.findElement(By.name("DateOfBirthDay")));
            //Day.selectByVisibleText("1");

            selectByVisibleText(By.name("DateOfBirthDay"), props.getProperty("Day"));

            //Month drop box select
            //Select Month = new Select(driver.findElement(By.name("DateOfBirthMonth")));
            //Month.selectByVisibleText("April");

            selectByValue(By.name("DateOfBirthMonth"), props.getProperty("Month"));

            //Birth year drop box select
            //Select Year = new Select(driver.findElement(By.name("DateOfBirthYear")));
            //Year.selectByVisibleText("1965");

            selectByIndex(By.name("DateOfBirthYear"), Integer.parseInt(props.getProperty("i")));

            //random email creation
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);

            //Email
            // driver.findElement(By.xpath("//input[@id=\"Email\"] ")).sendKeys("rsahay" + randomInt + "@gmail.com");

            enterText(By.xpath("//input[@id=\"Email\"] "), "ramla" + randomInt + "@gmail.com");

            System.out.println("rsahay" + randomInt + "@gmail.com");

            //Company Name
            //driver.findElement(By.xpath("//input[@id=\"Company\"]")).sendKeys("ABC Online Ltd");
            enterText(By.xpath("//input[@id=\"Company\"]"), props.getProperty("Companyname"));


            //Password Entry
            //driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("Champa12");
            enterText(By.xpath("//input[@id=\"Password\"]"), props.getProperty("Password"));

            //Confirm Password
            //driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("Champa12");
            enterText(By.xpath("//input[@id=\"ConfirmPassword\"]"), props.getProperty("CPassword"));

            //Click Register button
            //driver.findElement(By.name("register-button")).click();
            clickElement(By.name("register-button"));


            //Registration successful (Test Pass or Fail)

            java.lang.String expectedMSG = "Your registration completed";
            java.lang.String actualMSG = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
                    //driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();

            Assert.assertEquals(expectedMSG, actualMSG);

            //Click on Continue
            //driver.findElement(By.name("register-continue")).click();
            clickElement(By.name("register-continue"));

        }

        @Test (priority = 1)
        public void userShouldBeAbleToReferAProductToFriendByEmail (){

            //Click on register
            clickElement(By.linkText("Register"));

            //select radio button

            clickElement(By.xpath("//input[@id='gender-male']"));


            //First Name

            enterText(By.xpath("//input[@id='FirstName']"), props.getProperty("Firstname"));


            //Last name

            enterText(By.id("LastName"), props.getProperty("lastname"));

            //Dropdown box
            selectByVisibleText(By.name("DateOfBirthDay"), props.getProperty("Day"));

            //Month drop box select
            selectByValue(By.name("DateOfBirthMonth"), props.getProperty("Month"));

            //Birth year drop box select
            selectByIndex(By.name("DateOfBirthYear"), Integer.parseInt(props.getProperty("i")));

            //random email creation
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(100000);

            //Email
            // driver.findElement(By.xpath("//input[@id=\"Email\"] ")).sendKeys("rsahay" + randomInt + "@gmail.com");

            enterText(By.xpath("//input[@id=\"Email\"] "), "ramla" + randomInt + "@gmail.com");

            System.out.println("rsahay" + randomInt + "@gmail.com");

            //Company Name
            //driver.findElement(By.xpath("//input[@id=\"Company\"]")).sendKeys("ABC Online Ltd");
            enterText(By.xpath("//input[@id=\"Company\"]"), props.getProperty("Companyname"));


            //Password Entry
            //driver.findElement(By.xpath("//input[@id=\"Password\"]")).sendKeys("Champa12");
            enterText(By.xpath("//input[@id=\"Password\"]"), props.getProperty("Password"));

            //Confirm Password
            //driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]")).sendKeys("Champa12");
            enterText(By.xpath("//input[@id=\"ConfirmPassword\"]"), props.getProperty("CPassword"));

            //Click Register button
            //driver.findElement(By.name("register-button")).click();
            clickElement(By.name("register-button"));


            //Click on Continue
            //driver.findElement(By.name("register-continue")).click();
            clickElement(By.name("register-continue"));



//click on macbook
            //driver.findElement(By.xpath("//div/a[@title=\"Show details for Apple MacBook Pro 13-inch\"]")).click();
            clickElement(By.xpath("//div/a[@title=\"Show details for Apple MacBook Pro 13-inch\"]"));


            //Email a friend
            //driver.findElement(By.xpath("//div[@class='email-a-friend']")).click();
            clickElement(By.xpath("//div[@class='email-a-friend']"));

            //Enter Friends email
            //driver.findElement(By.xpath("//input[@class='friend-email'] ")).sendKeys("rsahay600@gmail.com");
            enterText(By.xpath("//input[@class='friend-email']"), props.getProperty("email"));


            //Enter your email
            // driver.findElement(By.xpath("//input[@class='your-email']")).sendKeys("nehal.dama27@gmail.com");

            //Personal Message
            //driver.findElement(By.xpath(" //textarea[@placeholder='Enter personal message (optional).'] ")).sendKeys("Hey check this out a very good deal I found buy this has great features");
            enterText(By.xpath(" //textarea[@placeholder='Enter personal message (optional).'] "), "Hey check this out a very good deal I found buy this has great features" );



            //Click send email
            //driver.findElement(By.name("send-email")).click();
            clickElement(By.name("send-email"));


            //Test Pass or Fail

            String expectM = "Your message has been sent.";
            String actualM = getTextFromElement(By.xpath("//*[@class=\"result\"]"));

             //driver.findElement(By.xpath("//*[@class=\"result\"]")).getText();

            Assert.assertEquals(actualM, expectM);

        }



    @Test(priority = 2)
        public void userShouldBeNavigateCameraAndPhoto (){

            //click on Electronics category
            //driver.findElement(By.linkText("Electronics")).click();
            clickElement(By.linkText("Electronics"));

            //click on camera category
            //driver.findElement(By.xpath("//img[@alt=\"Picture for category Camera & photo\"]")).click();
            clickElement(By.xpath("//img[@alt=\"Picture for category Camera & photo\"]"));


            //To check if actual is equal to expected or not
            String actualM1 = getTextFromElement(By.xpath("//h1[contains(text(), 'Camera & photo')]"));
            String expectedM1 = "Camera & photo";

            Assert.assertEquals(actualM1, expectedM1);


        }

        @Test(priority = 3)

        public void userShouldBeAbleToFilterJewelleryByPriceRange () {


            //Select Jewellery category
            //driver.findElement(partialLinkText("Jewelry")).click();
            clickElement(partialLinkText("Jewelry"));


            //Select Price Range of 700-3000
            //driver.findElement(By.xpath("//a[contains(@href,'700-3000')]")).click();
            clickElement(By.xpath("//a[contains(@href,'700-3000')]"));

            //compare

            String actualM2 = getTextFromElement(By.xpath("//span[@class=\"price actual-price\"]"));
            //driver.findElement(By.xpath("//span[@class=\"price actual-price\"]")).getText();
            String expectedM2 = "$700.00 - $3,000.00";
            String string[] = expectedM2.split("-");
            String string4 = string[1].replaceAll(" ", "").replace("$", "").replace(",", "");
            String string3 = string[0].replace("$", "");
            //Convert String to Double
            double parse1 = parseDouble(string3);
            double parse2 = parseDouble(string4);
            //Converting Actual value to double
            double actualAM2 = parseDouble(actualM2.replace("$", "").replace(",", ""));

            // Assert.assertTrue(AM2,EM2);

            assertThat(actualAM2).isBetween(parse1, parse2);


            //Assertion to check if user is able to see the filtered range of $700 - $3000 at top left corner

            String M5 = getTextFromElement(By.xpath("//span[@class='item']"));
            //driver.findElement(By.xpath("//span[@class='item']")).getText();
            String M6 = "$700.00 - $3,000.00";

            Assert.assertEquals(M5, M6);


        }


        @Test(priority = 4)
        public void userShouldBeAbleToAdd2ItemsToTheBasket () throws InterruptedException {

            //Go to book category
            //driver.findElement(By.linkText("Books")).click();
            clickElement(By.linkText("Books"));

            //Add first book to cart
            //driver.findElement(By.xpath("//input[@type='button' and contains(@onclick, '38/1/1')]")).click();
            clickElement(By.xpath("//input[@type='button' and contains(@onclick, '38/1/1')]"));

            //waitForElementVisible(By.xpath("//input[@type='button' and contains(@onclick, '37/1/1')]"),3000);
            Thread.sleep(3000);
            //waitAndClick(By.xpath("//input[@type='button' and contains(@onclick, '37/1/1')]"), 30);
            //waitForElementToBeInvisible(By.tagName("display: block"), 1000);

            //Add second book to cart
            //driver.findElement(By.xpath("//input[@type='button' and contains(@onclick, '37/1/1')]")).click();
           clickElement(By.xpath("//input[@type='button' and contains(@onclick, '37/1/1')]"));
            //clickElement(By.xpath("//div[1]/div/div[2]/div[3]/div[2]/input[1]"));

            //waitForElementVisible(By.xpath("//p[@class = \"content\"]"), 2);

            Thread.sleep(7000);

            //Click on shopping cart
            //driver.findElement(By.className("ico-cart")).click();
            clickElement(By.className("ico-cart"));


            //Check if test was successful or failed
            String actualu1 = getTextFromElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));

            String expectedu1 = getTextFromElement(By.linkText("Fahrenheit 451 by Ray Bradbury"));

            Assert.assertEquals(actualu1, expectedu1);

            String actualb2 = getTextFromElement(By.linkText("First Prize Pies"));


           String expectedb2 = getTextFromElement(By.linkText("First Prize Pies"));
           Assert.assertEquals(actualb2, expectedb2);

        }

    }
