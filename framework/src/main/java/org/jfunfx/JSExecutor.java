package org.jfunfx;

import org.jfunfx.jsconstruction.FunFXException;

/**
 * Communication interface between web-driver library (such as WebDriver or WatiJ) and JFunFX.
 * date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public interface JSExecutor {
    /**
     * Execute JS in SWF.
     *
     * @param js javascript.
     * @return returned value.
     * @throws org.jfunfx.jsconstruction.FunFXException
     *          error.
     */
    String execute(String js) throws FunFXException;

    /**
     * Get driver name (to determine is it firefox or ie).
     *
     * @return driver class name.
     */
    String getDriverName();

    /**
     * Make js return of returned value or not
     * (For example, webdriver requires <CODE>true</CODE>, watij - <CODE>false</CODE>).
     *
     * @return make js return of returned value or not.
     */
    boolean makeJSreturn();
}
