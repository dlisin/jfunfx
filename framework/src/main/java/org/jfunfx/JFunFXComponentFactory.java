package org.jfunfx;

import org.jfunfx.jsconstruction.*;
import org.jfunfx.jsconstruction.components.*;

/**
 * Flex components wrappers factory. It is the main front class of the framework, the test writer
 * should use it primarily.
 * <br/>Each Flex3 component supported has the same name in JFunFX.
 * <br/>Every component is checked for existence before creation. If not exist then
 * {@link org.jfunfx.jsconstruction.FlexComponentNotFoundException} is thrown.
 * <br/>date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class JFunFXComponentFactory {
    private JFunFXContainer jFunFXContainer;
    private long delay = 500;

    public JFunFXComponentFactory(JFunFXContainer jFunFXContainer) {
        this.jFunFXContainer = jFunFXContainer;
    }

    public JFunFXComponentFactory(JFunFXContainer jFunFXContainer, long delay) {
        this.jFunFXContainer = jFunFXContainer;
        this.delay = delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public Button createButton(String id)
        throws FlexComponentNotFoundException {
        return createButton(new ObjectLocator(id));
    }

    public Button createButton(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (Button) checkExistence(new Button(jFunFXContainer, objectLocator, delay));
    }

    public TextInput createTextInput(String id)
        throws FlexComponentNotFoundException {
        return createTextInput(new ObjectLocator(id));
    }

    public TextInput createTextInput(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (TextInput) checkExistence(new TextInput(jFunFXContainer, objectLocator, delay));
    }

    public TextArea createTextArea(String id)
        throws FlexComponentNotFoundException {
        return createTextArea(new ObjectLocator(id));
    }

    public TextArea createTextArea(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (TextArea) checkExistence(new TextArea(jFunFXContainer, objectLocator, delay));
    }

    public Label createLabel(String id)
        throws FlexComponentNotFoundException {
        return createLabel(new ObjectLocator(id));
    }

    public Label createLabel(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (Label) checkExistence(new Label(jFunFXContainer, objectLocator, delay));
    }

    public CheckBox createCheckBox(String id)
        throws FlexComponentNotFoundException {
        return createCheckBox(new ObjectLocator(id));
    }

    public CheckBox createCheckBox(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (CheckBox) checkExistence(new CheckBox(jFunFXContainer, objectLocator, delay));
    }

    public RadioButton createRadioButton(String id)
        throws FlexComponentNotFoundException {
        return createRadioButton(new ObjectLocator(id));
    }

    public RadioButton createRadioButton(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (RadioButton) checkExistence(new RadioButton(jFunFXContainer, objectLocator, delay));
    }

    public ComboBox createComboBox(String id)
        throws FlexComponentNotFoundException {
        return createComboBox(new ObjectLocator(id));
    }

    public ComboBox createComboBox(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (ComboBox) checkExistence(new ComboBox(jFunFXContainer, objectLocator, delay));
    }

    public Tree createTree(String id)
        throws FlexComponentNotFoundException {
        return createTree(new ObjectLocator(id));
    }

    public Tree createTree(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (Tree) checkExistence(new Tree(jFunFXContainer, objectLocator, delay));
    }

    public List createList(String id)
        throws FlexComponentNotFoundException {
        return createList(new ObjectLocator(id));
    }

    public List createList(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (List) checkExistence(new List(jFunFXContainer, objectLocator, delay));
    }

    public DateField createDateField(String id)
        throws FlexComponentNotFoundException {
        return createDateField(new ObjectLocator(id));
    }

    public DateField createDateField(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (DateField) checkExistence(new DateField(jFunFXContainer, objectLocator, delay));
    }

    public Text createText(String id)
        throws FlexComponentNotFoundException {
        return createText(new ObjectLocator(id));
    }

    public Text createText(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (Text) checkExistence(new Text(jFunFXContainer, objectLocator, delay));
    }

    /**
     * Create alert wrapper for alert window currently on the screen.
     * <br/>No checks are made for alert existance.
     *
     * @return alert wrapper.
     */
    public Alert createAlert() {
        return new Alert(jFunFXContainer, new ObjectLocator(""), delay);
    }

    /**
     * Create alert wrapper for alert window with title specified.
     * <br/>Alert existance is made by its title.
     *
     * @param title alert title.
     * @return alert wrapper.
     * @throws FlexComponentNotFoundException alert existance check by title failed.
     */
    public Alert createAlert(String title)
        throws FlexComponentNotFoundException {
        return createAlert(ObjectLocator.createByAutomationName(title));
    }

    protected Alert createAlert(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (Alert) checkExistence(new Alert(jFunFXContainer, objectLocator, delay));
    }

    public LinkButton createLinkButton(String id)
        throws FlexComponentNotFoundException {
        return createLinkButton(new ObjectLocator(id));
    }

    public LinkButton createLinkButton(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (LinkButton) checkExistence(new LinkButton(jFunFXContainer, objectLocator, delay));
    }

    public TabBar createTabBar(String id)
        throws FlexComponentNotFoundException {
        return createTabBar(new ObjectLocator(id));
    }

    public TabBar createTabBar(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (TabBar) checkExistence(new TabBar(jFunFXContainer, objectLocator, delay));
    }

    public Menu createMenu(String id)
        throws FlexComponentNotFoundException {
        return createMenu(new ObjectLocator(id));
    }

    public Menu createMenu(ObjectLocator objectLocator)
        throws FlexComponentNotFoundException {
        return (Menu) checkExistence(new Menu(jFunFXContainer, objectLocator, delay));
    }

    public WaitComponent createWaitComponent(String id, String property)
        throws FlexComponentNotFoundException {
        return createWaitComponent(new ObjectLocator(id), property);
    }

    public WaitComponent createWaitComponent(ObjectLocator objectLocator, String property)
        throws FlexComponentNotFoundException {
        return (WaitComponent) checkExistence(
            new WaitComponent(jFunFXContainer, objectLocator, property));
    }

    public Boolean checkComponentExistence(ObjectLocator objectLocator) {
        return new FlexComponent(jFunFXContainer, objectLocator).isComponentExists();
    }

    private FlexComponent checkExistence(FlexComponent flexComponent) {
        if (flexComponent.isComponentExists()) {
            return flexComponent;
        }
        throw new FlexComponentNotFoundException(flexComponent.getObjectLocator());
    }

    public JFunFXContainer getJFunFXContainer() {
        return jFunFXContainer;
    }

    /**
     * Pause test execution for any browser.
     *
     * @param millis pause in millis.
     */
    public void sleep(long millis) {
        JFunFXUtils.sleep(millis);
    }

    /**
     * Pause test execution for Firefox.
     *
     * @param millis pause in millis.
     */
    public void sleepFirefox(long millis) {
        if (isFirefox()) {
            JFunFXUtils.sleep(millis);
        }
    }

    /**
     * Pause test execution for InternetExplorer.
     *
     * @param millis pause in millis.
     */
    public void sleepInternetExplorer(long millis) {
        if (isInternetExplorer()) {
            JFunFXUtils.sleep(millis);
        }
    }

    public boolean isFirefox() {
        return jFunFXContainer.isFirefox();
    }

    public boolean isInternetExplorer() {
        return jFunFXContainer.isInternetExplorer();
    }
}
