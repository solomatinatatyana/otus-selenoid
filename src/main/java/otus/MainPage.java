package otus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    public static final String HUBS_LINK= ".//h3[contains(text(), 'Хабы')]";

    @FindBy(xpath = HUBS_LINK)
    private WebElement elHubsLinks;

    public MainPage checkUrl(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://habr.com/ru/hubs/");
        return this;
    }

    public MainPage clickElHubsLink(){
        elHubsLinks
                .click();
        return this;
    }
}
