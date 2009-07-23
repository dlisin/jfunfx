package org.jfunfx;

import org.jfunfx.jsconstruction.FunFXException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * WebDriver javascript executor implementation.
 * <p/>date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class WebDriverJSExecutor implements JSExecutor {
    private WebDriver driver;

    public WebDriverJSExecutor(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * {@inheritDoc}
     */
    public String execute(String js) throws FunFXException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        Object result = null;
        try {
            result = jsExecutor.executeScript(js);
        } catch (IllegalStateException e) {
            if (e.getMessage() != null && e.getMessage().startsWith("Cannot determine result type (19)")) {
                return null;
            }
            throw e;
        }

        System.out.println(result);

        /*try {
            Thread.sleep(sleepInterval);
        } catch (InterruptedException e) {
        }*/

        if (result != null) {
            String resultStr = result.toString();
            if (resultStr.startsWith("____FUNFX_ERROR")) {
                throw new FunFXException(resultStr);
            } else {
                return resultStr;
            }
        } else {
            return null;
        }
    }

    public String getDriverName() {
        return driver.getClass().getName();
    }

    /**
     * {@inheritDoc}
     */
    public boolean makeJSreturn() {
        return true;
    }
}
