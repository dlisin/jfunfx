package org.jfunfx.jsconstruction;

/**
 * date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class FunFXException extends RuntimeException {
    public FunFXException(String message) {
        super(message);
    }

    public FunFXException(String message, Throwable cause) {
        super(message, cause);
    }
}
