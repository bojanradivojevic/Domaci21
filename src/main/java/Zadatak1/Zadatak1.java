package Zadatak1;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;

public class Zadatak1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://automationexercise.com/");

        WebElement signUpLogin = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signUpLogin.click();

        Faker faker = new Faker();

        WebElement userName = driver.findElement(By.name("name"));
        userName.sendKeys(faker.name().username());
        WebElement userEmail = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        userEmail.sendKeys(faker.internet().emailAddress());
        WebElement signUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signUp.click();

        JavascriptExecutor j = (JavascriptExecutor)driver;
        j.executeScript("window.scrollBy(0,600)");

        WebElement title = driver.findElement(By.id("id_gender1"));
        title.click();
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(faker.internet().password());
        WebElement dayOfBirth = driver.findElement(By.id("days"));
        Select buttonDay = new Select(dayOfBirth);
        buttonDay.selectByValue("15");
        WebElement monthOfBirth = driver.findElement(By.id("months"));
        Select buttonMonth = new Select(monthOfBirth);
        buttonMonth.selectByVisibleText("April");
        WebElement yearOfBirth = driver.findElement(By.id("years"));
        Select buttonYear = new Select(yearOfBirth);
        buttonYear.selectByValue("1994");
        WebElement chekBoxRecSpecOffers = driver.findElement(By.id("optin"));
        chekBoxRecSpecOffers.click();
        WebElement country = driver.findElement(By.xpath("/html/body/section/div/div/div/div[1]/form/p[6]/select"));
        Select buttonCountry = new Select(country);
        buttonCountry.selectByVisibleText("Canada");
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys(faker.name().firstName());
        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys(faker.name().lastName());
        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys(faker.address().fullAddress());
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys(faker.address().state());
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(faker.address().city());
        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys(faker.address().zipCode());
        WebElement mobile_number = driver.findElement(By.id("mobile_number"));
        mobile_number.sendKeys(faker.phoneNumber().cellPhone());

        j.executeScript("window.scrollBy(0,300)");

        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccount.click();
        WebElement buttonContinue = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        buttonContinue.click();
        WebElement deleteAccount = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccount.click();










        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }
}
