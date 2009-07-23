package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.FlexComponent;
import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 22.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public abstract class ListBase extends FlexComponent {
    public ListBase(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
    }

    public ListBase(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    /**
     * Select tree/combo/list item (leaf or branch), note that item should be visible.
     *
     * @param path item path. Example: <CODE>'Visual Components>Button Controls>Button'</CODE>,
     *             where <CODE>'Button'</CODE> is a node screen name.
     */
    public void selectItem(String path) {
        fireEvent("Select", path, "1", "0");
        sleep();
    }

    public String getSelectedItem() {
        String item = getPropertyValue("selectedItem");
        if (item == null) {
            //no selected items
            return null;
        }
        return getSubPropertyValue("selectedItem", getLabelField());
    }

    public String getLabelField() {
        return getPropertyValue("labelField");
    }
}
