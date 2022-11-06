import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LessonsTest {

//    /TC_1_1  - Тест кейс:
//    //1. Открыть страницу https://openweathermap.org/
//    //2. Набрать в строке поиска город Paris
//    //3. Нажать пункт меню Search
//    //4. Из выпадающего списка выбрать Paris, FR
//    //5. Подтвердить, что заголовок изменился на "Paris, FR"

    // TC writing principle: What, Where, When testing

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//         Arrange
//         Test Data
        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

//        Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(1000);

        WebElement parisFRChoiceInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropDownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

//        Thread.sleep(5000); // Timer for 5s

        // Assert
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit(); // Quit the browser at the end

    }
//    @Test
//    public void testH2TagText_WhenSearchingCityCountry() {
//        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.quit();

//    }

//    WebDriverWait wait = new WebDriverWait(driver, 25);
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
//                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
//        Thread.sleep(5000);

//    //a[contains(@class, 'btn_block orange round') " +
//                    "or contains(@class, 'ow-btn round btn-orange') ]")).size();

//    for (String winHandle : driver.getWindowHandles()) {
//            driver.switchTo().window(winHandle);
//        }


}
