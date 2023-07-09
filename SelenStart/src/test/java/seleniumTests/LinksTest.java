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

    @Test(description = "открыть сайт")
    public static void firstTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); //экземпляр web-драйвера
        String searchText = "Most Popular";

        driver.get("https://litecart.stqa.ru/en/");//открыть ссылку
        //driver.manage().window().maximize();
        WebElement element = driver.findElement(By.xpath("//div[@id='box-most-popular']/*"));
        Assert.assertEquals(element.getText(), searchText);
        driver.quit();
    }

    @Test(description = "Пройти по ссылке Rubber Ducks")
    public static void linkFirst() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String searchText = "Rubber Ducks";

        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id='box-category']/*[@class='title']"));
        Assert.assertEquals(element.getText(), searchText);
        driver.quit();

    }

    @Test(description = "переход по ссылке Subcategory")
    public static void linkSecond() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    String searchText2 = "Subcategory";

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
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(50));
        //driver.manage().window().maximize();
        WebElement blueDuck = driver.findElement(By.xpath("//li[@class='product column shadow hover-light']/*[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/blue-duck-p-4']"));//находим нужный элемент
        Actions click = new Actions(driver);//создаём экземпляр класса
        click.click(blueDuck).perform();//perform запускает запуск
        WebElement duckBlue = driver.findElement(By.xpath("//div[@id='box-product']//*[@class='title']"));

        Assert.assertEquals(duckBlue.getText(), imageSource);

        driver.quit();
    }

    @Test(description = "Перетягивание уточки negative case")
    public static void dragAndDrop() throws InterruptedException {
        String linkInEmailField = "http://www.canstockphoto.com/?r=282295";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duck = driver.findElement(By.xpath("//a[@href='http://www.canstockphoto.com/?r=282295']"));
        WebElement searchField = driver.findElement(By.xpath("//*[@name='query']"));
        Thread.sleep(2000);
        Actions builder = new Actions(driver);

        builder.dragAndDrop(duck,searchField).perform();
        Thread.sleep(2000);

        Assert.assertEquals(searchField.getCssValue("writing-mode"),linkInEmailField);

        //driver.quit();
    }

    @Test(description = "Перетягивание уточки positive case")
    public static void dragAndDrop0() throws InterruptedException {
        String linkInEmailField="";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        WebElement duck = driver.findElement(By.xpath("//li[@class='rslides1_on']/*/*"));
        WebElement searchField = driver.findElement(By.xpath("//*[@name='query']"));
        Thread.sleep(2000);
        Actions builder = new Actions(driver);

        builder.dragAndDrop(duck,searchField).perform();
        Thread.sleep(2000);

        Assert.assertEquals(searchField.getAttribute("value"),linkInEmailField);

        driver.quit();
    }

    @Test(description = "Прописывание текста в поле")
    public static void sendText() throws InterruptedException {
        String someInput = "aaa";

        WebDriver driver = new ChromeDriver();
        driver.get("https://litecart.stqa.ru/en/");

        driver.findElement(By.xpath("//*[@name='query']")).sendKeys(someInput);
        Thread.sleep(2000);
        Actions builder = new Actions(driver);

        Assert.assertEquals(someInput, someInput);

        driver.quit();
    }

    @Test(description = "Перетягивание объекта ClassWork и проверка ошибок хромдрайвера")
    public static void dragAndDrop2() throws InterruptedException {
        String linkInTheField = "rgba(255, 192, 203, 1)";

        WebDriver driver = new ChromeDriver();
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");

        WebElement ball = driver.findElement(By.id("ball"));
        WebElement goal = driver.findElement(By.id("gate"));
        Thread.sleep(2000);
        Actions builder = new Actions(driver);

        builder.dragAndDrop(ball,goal).perform();
        Thread.sleep(2000);

        Assert.assertEquals(goal.getCssValue("background-color"),linkInTheField);

        driver.quit();
    }

    @Test(description = "Перетягивание объекта")
    public static void dragAndDrop3() throws InterruptedException {
        String linkInEmailField = "";

        WebDriver driver = new ChromeDriver();
        driver.get("https://software-testing.ru/");

        WebElement iconLink = driver.findElement(By.cssSelector("[href='http://vk.com/test_it']"));
        WebElement field = driver.findElement(By.name("q"));
        Thread.sleep(2000);
        Actions builder = new Actions(driver);

        builder.dragAndDrop(iconLink,field).perform();
        Thread.sleep(2000);

        Assert.assertEquals(field.getAttribute("value"), linkInEmailField);

        driver.quit();
    }
}
