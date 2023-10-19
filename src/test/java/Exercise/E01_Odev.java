package Exercise;

import Utilities.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E01_Odev {
    public static void main(String[] args) {
        /*1. http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine “username” yazdirin
        4. Password alanina “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Back tusu ile sayfaya donun
        7. Online Banking menusunden Pay Bills sayfasina gidin
        8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        9. tarih kismina “2020-09-10” yazdirin
        10. Pay buttonuna tiklayin
        11. “The payment was successfully submitted.” mesajinin
        ciktigini test edin

         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@*='signin_button']")).click();

        //3. Login alanine “username” yazdirin
        WebElement loginAlani =driver.findElement(By.xpath("//input[@id='user_login']"));
        loginAlani.sendKeys("username");


        //4. Password alanina “password” yazdirin
        WebElement passwordAlani= driver.findElement(By.xpath("//input[@type='password']"));
        passwordAlani.sendKeys("password");

        ReusableMethods.bekle(2);

        // 5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();


        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

       //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();

        ReusableMethods.bekle(2);

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        ReusableMethods.bekle(2);

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement yatirilanPara= driver.findElement(By.xpath("//input[@id='sp_amount']"));
        yatirilanPara.sendKeys("1000");


        //9. tarih kismina “2020-09-10” yazdirin
        WebElement tarih= driver.findElement(By.xpath("//input[@id='sp_date']"));
        tarih.sendKeys("2020-09-10"+Keys.ENTER);

        ReusableMethods.bekle(2);

        //10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();

        // 11. “The payment was successfully submitted.” mesajini ciktigini test edin

        if (driver.findElement(By.xpath(" //span[@title='$ 1000 payed to payee sprint']")).isDisplayed()) {
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAİLED");
        }

        ReusableMethods.bekle(2);
        driver.close();


    }
}
