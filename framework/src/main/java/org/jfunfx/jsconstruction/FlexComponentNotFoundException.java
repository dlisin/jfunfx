package org.jfunfx.jsconstruction;

/**
 * date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class FlexComponentNotFoundException extends RuntimeException {
    /**
     * {@inheritDoc}
     */
    public FlexComponentNotFoundException(ObjectLocator objectLocator) {
        super("Flex component not found: [" + objectLocator.toString() + "].");
    }
}
