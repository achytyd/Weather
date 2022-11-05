import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AchytyDTest {

    //TC_11_01
    //1.  Открыть базовую ссылку
    //2.  Нажать на пункт меню Guide
    //3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и
    // что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testClickGuideButtonOutput() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//         Arrange
//         Test Data
        String url = "https://openweathermap.org/";
        String buttonGuide = "Guide";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

//        Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement searchGuideButton = driver.findElement(
                By.xpath("//body/nav[@id = 'nav-website']/ul[@id = 'first-level-nav']/div[@id = 'desktop-menu']/ul/li/a")
        );
        searchGuideButton.click();

        Thread.sleep(1000);

        String actualResult = driver.getTitle();

//        Assert
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();



        }


        @Test
    public void testTemperatureInFahrenheit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//         Arrange
//         Test Data
        String url = "https://openweathermap.org/";
        String expectedResult = "F";

//        Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement searchOptionTemperature = driver.findElement(
                By.xpath("//div[text() = 'Imperial: °F, mph']")
        );
        searchOptionTemperature.click();
        Thread.sleep(1000);

        WebElement checkIfTemperetureIsInImperial = driver.findElement(By.xpath("//span[@class = 'heading']")
        );
        String actualResult = checkIfTemperetureIsInImperial.getText();
        Thread.sleep(5000);

//        Assert
        Assert.assertEquals(actualResult.substring(actualResult.length() -1), expectedResult);

        driver.quit();
    }

    @Test
//    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
// We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
// You can allow all cookies or manage them individually.”
//3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    public void testCookiesMessage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//         Arrange
//         Test Data
        String url = "https://openweathermap.org/";
        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential " +
                "cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies or" +
                " manage them individually.";
        String expectedResultAllowAll = "Allow all";
        String expectedResultManageCookies = "Manage cookies";

//        Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement findStickFooterPanelDescription = driver.findElement(
                By.xpath("//p[@class='stick-footer-panel__description']")
        );

        WebElement findButtonStickFooterPanelLink = driver.findElement(By.xpath(
                "//button[@class=\"stick-footer-panel__link\"]")
        );
        WebElement findAttributeStickFooterPanelLink = driver.findElement(By.xpath(
                "//a[@class=\"stick-footer-panel__link\"]")
        );

        String actualResult = findStickFooterPanelDescription.getText();
        Thread.sleep(5000);
        String actualResultAllowAll = findButtonStickFooterPanelLink.getText();
        String actualResultManageCookies = findAttributeStickFooterPanelLink.getText();


//        Assert
        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResultAllowAll, expectedResultAllowAll);
        Assert.assertEquals(actualResultManageCookies, expectedResultManageCookies);

        driver.quit();
    }

// TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”

    @Test
    public void testIfSupportMenuHasSubMenus() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//         Arrange
//         Test Data
        String url = "https://openweathermap.org/";
        String expectedResult1 = "FAQ";
        String expectedResult2 = "How to start";
        String expectedResult3 = "Ask a question";

//        Act
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement findSupportDropDownMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", findSupportDropDownMenu);
        boolean b = findSupportDropDownMenu.isSelected();
        if (b) {
            System.out.println("Checkbox is not checked");
        }else {
            System.out.println("Checkbox is checked");
        }
        findSupportDropDownMenu.click();

        WebElement findFaqInDropDown = driver.findElement(
                By.xpath("//a[text() = 'FAQ']")
        );
        WebElement findHowToStartInDropDown = driver.findElement(
                By.xpath("//a[text() = 'How to start']")
        );
        WebElement findAskAquestionInDropDown = driver.findElement(
                By.xpath("//a[text() = 'Ask a question']")
        );

//        String actualResult1 = findFaqInDropDown.getText();
//        String actualResult2 = findHowToStartInDropDown.getText();
//        String actualResult3 = findAskAquestionInDropDown.getText();
//
//
////        Assert
//        Assert.assertEquals(actualResult1, expectedResult1);
//        Assert.assertEquals(actualResult2, expectedResult2);
//        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

//    TC_11_06
//1.  Открыть базовую ссылку
//2.  Нажать пункт меню Support → Ask a question
//3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//4. Оставить пустым поле Email
//5. Заполнить поля  Subject, Message
//6. Подтвердить CAPTCHA
//7. Нажать кнопку Submit
//8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”

    @Test
    public void testSupportAskQuestion() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//         Arrange
//         Test Data
        String url = "https://openweathermap.org/";
        String expectedResult = "can't be blank";
        String message = "Hello";

//        Act
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement findSupportDropDownMenu = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        findSupportDropDownMenu.click();

        WebElement findAskAquestionInDropDown = driver.findElement(
                By.xpath("//a[text() = 'Ask a question']")
        );
        findAskAquestionInDropDown.click();
        WebElement falseCheckIsUserFalse = driver.findElement(
                By.xpath("//input[@id='question_form_is_user_false']")
        );
        falseCheckIsUserFalse.click();

        WebElement searchEmailField = driver.findElement(
                By.xpath("//input[@id=\"question_form_email\"]")
        );
        WebElement searchSubjectField = driver.findElement(
                By.xpath("//select[@id='question_form_subject']")
        );
        searchSubjectField.click();
        Thread.sleep(5000);
        WebElement optionSubscription = driver.findElement(By.xpath("//option[@value= 'Subscription']"));
        WebElement searchMessage = driver.findElement(
                By.xpath("//textarea[@id=\"question_form_message\"]"));
        searchMessage.click();
        searchMessage.sendKeys();
        WebElement searchCaptcha = driver.findElement(
                By.xpath("//div[@class=\"recaptcha-checkbox-border\"]")
        );
        searchCaptcha.click();

        WebElement searchSubmit = driver.findElement(
                By.xpath("//input[@class= 'btn btn-default']")
        );
        searchSubmit.click();
        Thread.sleep(2000);

        WebElement searchTextCantBeBlank = driver.findElement(
                By.xpath("//span[@class = 'help-block']")
        );
        String actualResult = searchTextCantBeBlank.getText();

        Assert.assertEquals(actualResult, expectedResult);






        driver.quit();
    }









    }

