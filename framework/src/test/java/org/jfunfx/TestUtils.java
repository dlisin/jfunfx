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
}
