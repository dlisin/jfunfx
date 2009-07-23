package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.FlexComponent;
import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * Component that helps to recognize is application in busy state.
 * <br/>date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class WaitComponent extends FlexComponent {
    private String property;

    public WaitComponent(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator,
                         String property) {
        super(jFunFXContainer, objectLocator);
        this.property = property;
    }

    public Boolean isBusy() {
        return Boolean.parseBoolean(jFunFXContainer.getPropertyValue(objectLocator, property));
    }
}
