import org.apache.commons.exec.OS;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class TestQOne {
    public static void main(String[] args) throws InterruptedException {
        String localPath = System.getenv("PWD");
        String driPath = localPath.concat(File.separator).concat("src").concat(File.separator).concat("main").concat(File.separator).concat("lib").concat(File.separator).concat("chromedriver");
        System.setProperty("webdriver.chrome.driver", driPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ianzhang.cn/bing/");
        Thread.sleep(10000);
        WebElement webElement = driver.findElement(By.id("sb_form_q"));
        webElement.clear();
        Actions actionBuilder = new Actions(driver);
        Action action = actionBuilder
                .keyDown(Keys.SHIFT)
                .sendKeys(webElement, "zhangbolun") //输入大写的字母
                .keyUp(Keys.SHIFT)
                .sendKeys("zhangbolun")
                .sendKeys(Keys.ENTER)
                .build();

        action.perform();
        driver.quit();
    }
}

