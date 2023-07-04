package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Links {

    @Test
    public static void firstTest(){
        WebDriver driver = new ChromeDriver(); //экземпляр web-драйвера
        driver.get("https://the-internet.herokuapp.com");//открыть ссылку
        WebElement links = driver.findElement(By.id("content"));
        WebElement link = links.findElement(By.linkText("Drag and Drop"));
        link.click();
        //driver.quit();//закрыть браузер
    }
}
