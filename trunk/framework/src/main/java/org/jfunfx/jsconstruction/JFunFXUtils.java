package org.jfunfx.jsconstruction;

/**
 * date 21.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class JFunFXUtils {
    /**
     * Pause test execution without any exceptions throwing.
     * If InterruptedException is thrown then execution resumes immediately.
     *
     * @param millis sleep in millis.
     */
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            //if interrupted - so no delay will be used
        }
    }
}
