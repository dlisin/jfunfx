package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 20.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class CheckBox extends Button {
    public CheckBox(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    public CheckBox(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
    }

    public void click() {
        /*if (objectLocator.getId() == null) {
            //addressing by automation name
            //here is code that allows to invert selection of the checkbox
            //(if you select a checkbox by yourself before test clicks it - exception will be thrown)
            ObjectLocator store = objectLocator;
            objectLocator = new ObjectLocator(
                null, store.getAutomationName(), null,
                (isSelected() ? "[X]" : "[ ]") + " " + store.getAutomationName(), null);
            super.click();
            objectLocator = store;
        } else {
            //addressing by id
            super.click();
        }*/
        super.click();
    }

    public Boolean isSelected() {
        return super.isSelected();
    }
}
