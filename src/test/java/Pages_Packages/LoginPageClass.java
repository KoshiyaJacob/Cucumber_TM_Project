package Pages_Packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class LoginPageClass
{

    public void Login_HomePage_Verification( WebDriver driver) {

        driver.manage().window().maximize();
        driver.navigate().to("http://horse.industryconnect.io/Account/Login?ReturnUrl=%2f");


        //Entering name, password and click on login
        WebElement Username = driver.findElement(By.id("UserName"));
        Username.sendKeys("Hari");


        WebElement Password = driver.findElement(By.id("Password"));
        Password.sendKeys("123123");


        WebElement click_submit = driver.findElement(By.xpath("//input[@type='submit']"));
        click_submit.click();

        //Verify logged in or nor

        WebElement verificationText = driver.findElement(By.xpath("//*[@id='logoutForm']/ul/li/a"));
        String Text_Verify = verificationText.getText();
        Assert.assertEquals(Text_Verify , "Hello hari!", "TurnUp Potal Logged in Successfully");

    }

}



