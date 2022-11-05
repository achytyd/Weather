import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_11_02 {

    @Test
    public void testTemperatureInFahrenheit() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

//         Arrange
//         Test Data
        String url = "https://openweathermap.org/";
        String optionTemperature = "Imperial";
        String expectedResult = "Imperial: °F, mph";

//        Act
        driver.get(url);
        Thread.sleep(5000);

        WebElement searchOptionTemperature = driver.findElement(
                By.xpath("//div[text() = 'Imperial: °F, mph']")
        );
        searchOptionTemperature.click();

        Thread.sleep(1000);

//        String actualResult = driver.getTitle(); Work on this

//        Assert
        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

}
