package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.FlexComponent;
import org.jfunfx.jsconstruction.FunFXException;
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

    public String getDateString() {
        return getPropertyValue("selectedDate");
    }

    public void setDate(String date) throws FunFXException {
        fireEvent("Open", "1");
        fireEvent("Change", date);
        //check date format valid
        String dateSet = getDateString();
        if (dateSet.contains("Invalid Date")) {
            throw new FunFXException("Invalid date format");
        }
    }
}
