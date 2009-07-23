package org.jfunfx;

import org.jfunfx.jsconstruction.FunFXException;
import watij.runtime.ie.IE;

/**
 * WatiJ javascript executor implementation.
 * <p/>date 21.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class WatijJSExecutor implements JSExecutor {
    private IE ie;

    public WatijJSExecutor(IE ie) {
        this.ie = ie;
    }

    /**
     * {@inheritDoc}
     */
    public String execute(String js) throws FunFXException {
        try {
            Object result = ie.executeScript(js);
            System.out.println(result);
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
        } catch (Exception e) {
            throw new FunFXException("", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getDriverName() {
        return ie.getClass().getName();
    }

    /**
     * {@inheritDoc}
     */
    public boolean makeJSreturn() {
        return false;
    }
}
