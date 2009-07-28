package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.FlexComponent;
import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 28.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class TabBar extends FlexComponent {
    public TabBar(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
    }

    public TabBar(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    public void selectItem(String item) {
        fireEvent("Change", item);
    }

    public int getSelectedIndex() {
        return Integer.parseInt(getPropertyValue("selectedIndex"));
    }

    public int getChildrenCount() {
        return Integer.parseInt(getPropertyValue("numChildren"));
    }
}
