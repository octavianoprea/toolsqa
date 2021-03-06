package automationFramework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AccessoriesPage_POF;
import pageObjects.CheckOut_POF;
import pageObjects.HomePage_POF;
import pageObjects.LoginPage_POF;


import java.util.concurrent.TimeUnit;

/**
 * Created by Flavian on 13-Mar-17.
 */
public class TestCase_POF {
     private static WebDriver driver;

        public static void main(String[] args) throws InterruptedException {

           String workingDir = System.getProperty("user.dir");
           System.out.println("working directory: "+ workingDir);
           System.setProperty("webdriver.chrome.driver", workingDir+"/src/test/java/selenium/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://store.demoqa.com/");
        driver.manage().window().maximize();

        HomePage_POF homePage = PageFactory.initElements(driver, HomePage_POF.class);
        LoginPage_POF loginPage = PageFactory.initElements(driver,LoginPage_POF.class);
        AccessoriesPage_POF accPage = PageFactory.initElements(driver,AccessoriesPage_POF.class);
        CheckOut_POF chkPage = PageFactory.initElements(driver,CheckOut_POF.class);


        homePage.navigateToMyAccount();
        loginPage.login();
            Thread.sleep(4000);
        accPage.navigateToAccessories();
        /*accPage.clickApple();
        accPage.addProductToCart();
        chkPage.updateQty(32);*/

        accPage.addFirstNProductsToCart(8);
            Thread.sleep(3000);
        chkPage.navigateToCheckOut();
        chkPage.verifyTotal();

        //Thread.sleep(5000);


        driver.close();
        driver.quit();
    }

}
