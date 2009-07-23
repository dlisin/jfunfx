package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.FlexComponent;
import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 23.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class DateField extends FlexComponent {
    public DateField(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
    }

    public DateField(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    public String getDate() {
        return getPropertyValue("selectedDate");
    }
}
