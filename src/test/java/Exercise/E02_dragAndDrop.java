package Exercise;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class E02_dragAndDrop extends TestBase {
    @Test

    public void test(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions=new Actions(driver);
       WebElement suruklenecekButon=driver.findElement(By.xpath("//div[@id='draggable']"));
       WebElement birakilacakButon= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
       actions.dragAndDrop(suruklenecekButon,birakilacakButon).perform();

        bekle(5);


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        String expectedYazi="Dropped!";
        String actualYazi=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);






    }
}
