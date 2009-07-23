package org.jfunfx.jsconstruction;

/**
 * Base class for all flex component wrappers.
 * <p/>
 * <br/>
 * <br/>Each wrapper instance contains delay property which is used to pause execution in order to
 * wait until flex is ready to execute next command. Waiting is performed after
 * (or during execution) some commands, for example
 * {@link org.jfunfx.jsconstruction.components.Tree#openBranch}.
 * <br/>The default delay for components is 500 millis, but components can override it in
 * constructor, for example {@link org.jfunfx.jsconstruction.components.Tree}.
 * <br/>Also you can explicitly set delay to speed-up test execution or to avoid errors.
 * <p/>date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class FlexComponent {
    protected ObjectLocator objectLocator;
    protected JFunFXContainer jFunFXContainer;
    protected long delay = 500;

    public FlexComponent(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator) {
        this.objectLocator = objectLocator;
        this.jFunFXContainer = jFunFXContainer;
    }

    public FlexComponent(JFunFXContainer jFunFXContainer, ObjectLocator objectLocator, long delay) {
        this.objectLocator = objectLocator;
        this.jFunFXContainer = jFunFXContainer;
        this.delay = delay;
    }

    public Boolean isVisible() {
        return jFunFXContainer.isVisible(objectLocator);
    }

    public Boolean isComponentExists() throws FunFXException {
        return jFunFXContainer.isComponentExists(objectLocator);
    }

    public ObjectLocator getObjectLocator() {
        return objectLocator;
    }

    protected String fireEvent(String event, String... args) throws FunFXException {
        return jFunFXContainer.fireEvent(objectLocator, event, args);
    }

    protected String getPropertyValue(String property) throws FunFXException {
        return jFunFXContainer.getPropertyValue(objectLocator, property);
    }

    protected String getSubPropertyValue(String property, String subproperty)
        throws FunFXException {
        return jFunFXContainer.getSubPropertyValue(objectLocator, property, subproperty);
    }

    protected void click() {
        jFunFXContainer.click(objectLocator);
    }

    protected void sleep() {
        JFunFXUtils.sleep(delay);
    }

    /**
     * Get sleep time for this component.
     *
     * @return delay time in millis.
     * @see #sleep
     */
    public long getDelay() {
        return delay;
    }

    /**
     * Set sleep time for this component.
     *
     * @param delay delay time in millis.
     * @see #sleep
     */
    public void setDelay(long delay) {
        this.delay = delay;
    }
}
