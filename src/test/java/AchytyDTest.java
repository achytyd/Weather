import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    }

