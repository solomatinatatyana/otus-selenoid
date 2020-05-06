package otus;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class test001CheckUrl extends BaseTest{

    private MainPage mainPage;

    @Test()
    public void test() throws InterruptedException {
        mainPage = new MainPage(driver);
        long id = Thread.currentThread().getId();
        mainPage
                .clickElHubsLink()
                .checkUrl();
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("currentThread is " + id);
    }

}
