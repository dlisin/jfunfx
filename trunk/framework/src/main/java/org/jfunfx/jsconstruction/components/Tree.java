package org.jfunfx.jsconstruction.components;

import org.jfunfx.jsconstruction.JFunFXContainer;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 17.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class Tree extends ListBase {
    public Tree(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        super(jFunFXContainer, objectLocator, delay);
    }

    public Tree(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        super(jFunFXContainer, objectLocator);
        //branch openings can be long
        delay = 1000;
    }

    /**
     * Open tree branch.
     *
     * @param name branch path. Example: <CODE>'Visual Components'</CODE>,
     *             <CODE>'Visual Components>Button Controls'</CODE>.
     */
    public void openBranch(String name) {
//        fireEvent("Open", "itemRenderer:" + name, "triggerEvent:1");
        fireEvent("Open", name, "1");
        sleep();
    }

    /**
     * Sequently open branches and finally select last one.
     *
     * @param path path to the target node.
     */
    public void openAndSelectNode(String... path) {
        StringBuilder currentPath = new StringBuilder();
        for (int i = 0; i < path.length; i++) {
            String element = path[i];
            currentPath.append(element);
            if (i == path.length - 1) {
                //last element
                selectItem(currentPath.toString());
            } else {
                openBranch(currentPath.toString());
                currentPath.append(">");
            }
        }
    }

    /**
     * Close tree branch.
     *
     * @param name branch path. Example: <CODE>'Visual Components'</CODE>,
     *             <CODE>'Visual Components>Button Controls'</CODE>.
     */
    public void closeBranch(String name) {
        fireEvent("Close", name, "1");
        sleep();
    }
}
