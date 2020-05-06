package otus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    private MainPage mainPage;
    private String port;

    @BeforeClass()
    public void setUp() throws IOException {
        port = setEnvironment("src/main/resources/setRemoteEnvironment.bat");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setVersion("78.0");
        capabilities.setCapability("enableVNC",true);
        capabilities.setCapability("enableVideo",false);
        driver = new RemoteWebDriver(
                new URL("http://0.0.0.0:"+port+"/wd/hub"),
                capabilities
        );
        mainPage = new MainPage(driver);
        driver.get("https://habr.com/ru/hubs/");
    }

    private String setEnvironment(String path) throws IOException {
        InputStream is = Runtime.getRuntime().exec(new String[] {path}).getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(is);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        String str;
        while ((str = bufferedReader.readLine())!=null){
            stringBuffer.append(str);
        }
        String string = stringBuffer.toString();
        String port = string.substring(916, string.lastIndexOf("/"));
        System.out.println("Номер порта: " +port);
        return port;
    }

    @AfterClass()
    public void tearDown(){
        driver.close();
    }
}
