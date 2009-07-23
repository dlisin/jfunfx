package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 21.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class ComboBox extends ListBase {
    public ComboBox(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    public ComboBox(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
    }

    /**
     * Select combobox item by its screen name.
     * <br/>Also after select generates open and close events to ensure
     * that all combobox's listeners are fired.
     *
     * @param name screen item name.
     */
    @Override
    public void selectItem(String name) {
        selectItem(name, true);
    }

    /**
     * Select combobox item by its screen name.
     *
     * @param name      screen item name.
     * @param openClose <CODE>true</CODE> - generate after select open and close events to ensure
     *                  that all combobox's listeners are fired; <CODE>false</CODE> -
     *                  only select value (this does not guarantee that all combobox's
     *                  listeners will be fired).
     */
    public void selectItem(String name, boolean openClose) {
        super.selectItem(name);
        if (openClose) {
            fireEvent("Open");
            sleep();
            fireEvent("Close");
            sleep();
        }
    }

    public String getText() {
        return jFunFXContainer.getText(objectLocator);
    }

    public int getSelectedIndex() {
        return Integer.parseInt(getPropertyValue("selectedIndex"));
    }
}
