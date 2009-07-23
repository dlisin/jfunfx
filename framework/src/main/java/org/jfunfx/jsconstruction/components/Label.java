package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.FlexComponent;
import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class Label extends FlexComponent {
    public Label(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    public Label(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
    }

    public String getText() {
        return jFunFXContainer.getText(objectLocator);
    }
}
