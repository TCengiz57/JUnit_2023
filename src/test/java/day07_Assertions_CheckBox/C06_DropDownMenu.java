package day07_Assertions_CheckBox;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static Utilities.ReusableMethods.bekle;

public class C06_DropDownMenu extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        // 1.adim : dropdown webelementini locate et
        WebElement dropDownElementi = driver.findElement(By.xpath("//select[@title='Search in']"));
        // 2.adim locate ettigimiz webelementi parametre olarak yazip select objesi olustur
        Select select = new Select(dropDownElementi);
        // 3.adim select objesi ile istenen islemi yap
        select.selectByValue("search-alias=automotive-intl-ship");
        bekle(2);
        select.selectByIndex(7);
        bekle(2);
        select.selectByVisibleText("Books");
        bekle(2);
    }
}
