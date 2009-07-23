package org.jfunfx;

import org.jfunfx.jsconstruction.JFunFXContainer;
import watij.runtime.ie.IE;

/**
 * date 21.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class FlexComponentExplorerWatiJTest extends FlexComponentExplorerBaseTest {
    private IE ie;

    @Override
    protected void setUp() throws Exception {
        ie = new IE();
        ie.start("http://localhost:8085/components-explorer/explorer.html");
        JSExecutor jsExecutor = new WatijJSExecutor(ie);
        factory = new JFunFXComponentFactory(new JFunFXContainer(jsExecutor, "explorer"));
    }

    @Override
    protected void tearDown() throws Exception {
        ie.close();
    }
}
