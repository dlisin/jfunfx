package org.jfunfx;

import org.jfunfx.jsconstruction.ObjectLocator;
import org.jfunfx.jsconstruction.components.WaitComponent;

/**
 * date 17.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class TestUtils {
    public static void waitLoading(JFunFXComponentFactory factory,
                                   ObjectLocator waitComponentLocator,
                                   String waitPropertyName) {
        WaitComponent waitComponent =
            factory.createWaitComponent(waitComponentLocator, waitPropertyName);
        while (true) {
            if (!waitComponent.isBusy()) {
                return;
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static String removeLineSeparators(String string) {
        return string == null ? "" : string.replaceAll("[\r\n]+", "");
    }

    public static void checkPageLoaded(String pageSource) {
        if (pageSource == null || pageSource.trim().length() == 0 ||
            /*IE (tested on IE7.0 Win XP) with Watij*/
            (pageSource.length() < 2000 && pageSource.contains("cannot display the webpage")) ||
            /*FF (tested on FF3.0) with WebDriver*/
            (pageSource.contains("<div id=\"errorLongDesc\">"))) {
            throw new IllegalStateException("Requested page is not available.");
        }
    }
}
