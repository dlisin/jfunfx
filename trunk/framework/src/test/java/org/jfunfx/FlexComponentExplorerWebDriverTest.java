package org.jfunfx;

import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * date 17.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class FlexComponentExplorerWebDriverTest extends FlexComponentExplorerBaseTest {
    private WebDriver driver;

    @Override
    protected void setUp() throws Exception {
        driver = new InternetExplorerDriver();
//        driver = new FirefoxDriver();
        driver.get("http://localhost:8085/components-explorer/explorer.html");
//        Thread.sleep(7000);//for firefox only
        WebDriverJSExecutor jsExecutor = new WebDriverJSExecutor(driver);
        factory = new JFunFXComponentFactory(new JFunFXContainer(jsExecutor, "explorer"));
    }

    @Override
    protected void tearDown() throws Exception {
        driver.close();
    }

    private void waitLoading() {
        TestUtils.waitLoading(factory, new ObjectLocator("login_hbox_id"), "data");
    }
}
