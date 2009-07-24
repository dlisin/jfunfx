package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.FlexComponent;
import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 24.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class Alert extends FlexComponent {
    public Alert(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
    }

    public Alert(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    /**
     * Click button on alert window.
     *
     * @param automationName button text.
     */
    public void clickButton(String automationName) {
        new Button(jFunFXContainer, ObjectLocator.createByAutomationName(automationName)).click();
    }
}
