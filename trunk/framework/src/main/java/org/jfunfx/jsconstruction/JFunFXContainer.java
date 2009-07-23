package org.jfunfx.jsconstruction;

import org.jfunfx.JSExecutor;

/**
 * JFunFX container that provides several common methods of communication with FunFX.
 * <br/>date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class JFunFXContainer extends FunFXConnector {
    public JFunFXContainer(JSExecutor jsExecutor, String swfId) {
        super(jsExecutor, swfId);
    }

    /**
     * No additions needed on this level on abstraction.
     */
    @Override
    public String getPropertyValue(ObjectLocator locator, String property)
        throws FunFXException {
        return super.getPropertyValue(locator, property);
    }

    /**
     * No additions needed on this level on abstraction.
     */
    @Override
    public String getSubPropertyValue(ObjectLocator locator, String property, String subproperty)
        throws FunFXException {
        return super.getSubPropertyValue(locator, property, subproperty);
    }

    @Override
    public String getTabularProperty(ObjectLocator locator, String property)
        throws FunFXException {
        return super.getTabularProperty(locator, property);
    }

    /**
     * Input text to text component.
     * <br/>In default <CODE>AutoQuickEnv.xml</CODE> following Flex components are suppoted:
     * <pre>TextInput, TextArea, ComboBox, DateField, ColorPicker</pre>.
     *
     * @param locator flex object locator.
     * @param text    text to input.
     * @return result status.
     * @throws FunFXException error.
     */
    public String inputText(ObjectLocator locator, String text)
        throws FunFXException {
        return fireEvent(locator, "Input", text);
    }

    /**
     * Get component text.
     * <br/>Supported by all Flex components that have <CODE>'text'</CODE> property.
     *
     * @param locator flex object locator.
     * @return text.
     * @throws FunFXException error.
     */
    public String getText(ObjectLocator locator) {
        return super.getPropertyValue(locator, "text");
    }

    /**
     * Simply click component.
     * <br/>Supported by almost all Flex components, see <CODE>AutoQuickEnv.xml</CODE>.
     *
     * @param locator flex object locator.
     * @throws FunFXException error.
     */
    public void click(ObjectLocator locator) {
        fireEvent(locator, "Click", "localX:1", "localY:1", "keyModifier:0");
    }

    /**
     * Get component <CODE>'visible'</CODE> property value.
     * <br/>Note that <CODE>'visible'</CODE> property value <CODE>true</CODE> does not denotes that
     * the component is actually visible on the screen!
     *
     * @param locator object locator.
     * @return visible property value.
     * @throws FunFXException error.
     */
    public Boolean isVisible(ObjectLocator locator) {
        return Boolean.parseBoolean(getPropertyValue(locator, "visible"));
    }

    /**
     * Check is component exist on the page.
     * <br/>Note, that if component is exist on the page it is can be not visible.
     *
     * @param locator flex object locator.
     * @return exist / not.
     * @throws FunFXException error.
     */
    public Boolean isComponentExists(ObjectLocator locator) throws FunFXException {
        try {
            if (getPropertyValue(locator, "id") == null) {
                return false;
            }
            return true;
        } catch (FunFXException e) {
            return false;
        }
    }
}
