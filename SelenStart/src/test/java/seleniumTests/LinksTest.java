package seleniumTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LinksTest {

    @Test
    public static void firstTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //экземпляр web-драйвера
        String searchText = "Rubber Ducks";
        String searchText2 = "Subcategory";

        driver.get("https://litecart.stqa.ru/en/");//открыть ссылку
        //WebElement links = driver.findElement(By.id("content"));
        //WebElement link = links.findElement(By.linkText("Drag and Drop"));
        //link.click();
        driver.manage().window().maximize();

        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id='box-category']/*[@class='title']"));
        Assert.assertEquals(element.getText(), searchText);


        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/");
        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath("//*[@id='box-category']//*[@class='title']"));
        Assert.assertEquals(element2.getText(), searchText2);

        driver.quit();//закрыть браузер
    }

    @Test(description = "Переход по синей уточке")
    public static void click() throws InterruptedException {
        String imageSource = "Blue Duck";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");
        Thread.sleep(2000);
        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");
        Thread.sleep(2000);
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        //driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50));
        //driver.manage().window().maximize();
        WebElement blueDuck = driver.findElement(By.xpath("//li[@class='product column shadow hover-light']/*[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/blue-duck-p-4']"));//находим нужный элемент
        Actions click = new Actions(driver);//создаём экземпляр класса
        click.click(blueDuck).perform();//perform запускает запуск
        WebElement duckBlue = driver.findElement(By.xpath("//div[@id='box-product']//*[@class='title']"));

        Assert.assertEquals(duckBlue.getText(), imageSource);

        driver.quit();
    }

    @Test(description = "Перетягивание уточки")
    public static void dragAndDrop() throws InterruptedException {
        String linkInEmailField = "http://www.canstockphoto.com/?r=282295";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duck = driver.findElement(By.xpath("//a[@href='http://www.canstockphoto.com/?r=282295']"));
        WebElement searchField = driver.findElement(By.xpath("//*[@name='email']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        actions.dragAndDrop(duck,searchField).perform();
        //Thread.sleep(2000);

        //Assert.assertEquals(searchField.getText(),linkInEmailField);

        driver.quit();
    }
}
