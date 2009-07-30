package org.jfunfx;

import junit.framework.TestCase;
import org.jfunfx.jsconstruction.FunFXException;
import org.jfunfx.jsconstruction.ObjectLocator;
import org.jfunfx.jsconstruction.components.*;

/**
 * Do not run this test! It is a base class for tests.
 * <p/>date 21.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class FlexComponentExplorerBaseTest extends TestCase {
    protected JFunFXComponentFactory factory;

    public void testButton() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(500);
        tree.openAndSelectNode("Visual Components", "Button Controls", "Button");
        factory.sleepFirefox(4000);

//        factory.createButton(new ObjectLocator("iconButton", new ObjectLocator("buttons_vbox_id")));
        factory.createButton("iconButton").click();
        factory.createButton(ObjectLocator.createByAutomationName("Button with Icon")).click();
        factory.createButton(ObjectLocator.createByAutomationName("Customized Button")).click();
        factory.createButton(ObjectLocator.createByAutomationName("Default Button")).click();

        assertEquals(TestUtils.removeLineSeparators(factory.createTextArea("message").getText()),
                     "Button with Icon pressed" +
                         "Button with Icon pressed" +
                         "Customized Button pressed" +
                         "Default Button pressed");
    }

    public void testCheckBox() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(500);
        tree.openAndSelectNode("Visual Components", "Button Controls", "CheckBox");
        factory.sleepFirefox(4000);

        TextArea textArea = factory.createTextArea("cartItems");
        assertEquals(TestUtils.removeLineSeparators(textArea.getText()), "");
        CheckBox milk = factory.createCheckBox("milkCB");
        assertFalse(milk.isSelected());
        milk.click();
        assertTrue(milk.isSelected());
        assertEquals(TestUtils.removeLineSeparators(textArea.getText()), "milk");
        milk.click();
        assertFalse(milk.isSelected());
        assertEquals(TestUtils.removeLineSeparators(textArea.getText()), "");
        factory.createCheckBox(ObjectLocator.createByAutomationName("eggs")).click();
//        factory.createCheckBox("eggsCB").click();
        factory.createCheckBox(ObjectLocator.createByAutomationName("bread")).click();
        assertEquals(TestUtils.removeLineSeparators(textArea.getText()),
                     "eggs" +
                         "bread");
    }

    public void testRadioButton() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(500);
        tree.openAndSelectNode("Visual Components", "Button Controls", "RadioButton");
        factory.sleepFirefox(4000);

        RadioButton rb1 = factory.createRadioButton(ObjectLocator.createByAutomationName("1942"));
        RadioButton rb2 = factory.createRadioButton(ObjectLocator.createByAutomationName("1952"));
        RadioButton rb3 = factory.createRadioButton(ObjectLocator.createByAutomationName("1962"));
        RadioButton rb4 = factory.createRadioButton(ObjectLocator.createByAutomationName("1972"));
        assertFalse(rb1.isSelected());
        assertFalse(rb2.isSelected());
        assertFalse(rb3.isSelected());
        assertFalse(rb4.isSelected());
        rb1.click();
        assertTrue(rb1.isSelected());
        assertFalse(rb2.isSelected());
        assertFalse(rb3.isSelected());
        assertFalse(rb4.isSelected());
        rb2.click();
        assertFalse(rb1.isSelected());
        assertTrue(rb2.isSelected());
        assertFalse(rb3.isSelected());
        assertFalse(rb4.isSelected());
        rb3.click();
        assertFalse(rb1.isSelected());
        assertFalse(rb2.isSelected());
        assertTrue(rb3.isSelected());
        assertFalse(rb4.isSelected());
    }

    public void testComboBox() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "General Controls", "ComboBox");
        factory.sleepFirefox(5000);

        ComboBox comboBox =
            factory.createComboBox(ObjectLocator.createByAutomationName("currency_combo"));
        assertEquals(comboBox.getSelectedIndex(), 0);
        assertEquals(comboBox.getSelectedItem(), "Visa");
        comboBox.selectItem("MasterCard", true);
        assertEquals(comboBox.getSelectedIndex(), 1);
        assertEquals(comboBox.getSelectedItem(), "MasterCard");
        System.out.println("comboBox.getLabelField() = " + comboBox.getLabelField());
    }

    public void testTree() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "General Controls", "Tree");
        factory.sleepFirefox(4000);

        Tree myTree = factory.createTree("myTree");
        assertNull(myTree.getSelectedItem());
        myTree.openBranch("Inbox");
        myTree.selectItem("Inbox>Marketing");
        assertEquals(myTree.getSelectedItem(), "Marketing");//does not work on WatiJ... returns null
        TextArea textArea = factory.createTextArea("treeTextArea");
        assertEquals(textArea.getText(), "Selected Item: Marketing");
        myTree.selectItem("Inbox");
        assertEquals(myTree.getSelectedItem(), "Inbox");
        assertEquals(textArea.getText(), "Selected Item: Inbox");
        myTree.closeBranch("Inbox");
        myTree.selectItem("Spam");
        assertEquals(myTree.getSelectedItem(), "Spam");
        assertEquals(textArea.getText(), "Selected Item: Spam");
        System.out.println("myTree.getSelectedItem() = " + myTree.getSelectedItem());
    }

    public void testList() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "General Controls", "List");
        factory.sleepFirefox(4000);

        List list = factory.createList("source");
        Label label = factory.createLabel("list_label_id");
        assertNull(list.getSelectedItem());
        assertEquals(label.getText(), "");
        list.selectItem("Alabama");
        assertEquals(list.getSelectedItem(), "Alabama");
        assertEquals(label.getText(), "Selected State: Alabama");
        list.selectItem("California");
        assertEquals(list.getSelectedItem(), "California");
        assertEquals(label.getText(), "Selected State: California");
        list.selectItem("Alaska");
        assertEquals(list.getSelectedItem(), "Alaska");
        assertEquals(label.getText(), "Selected State: Alaska");
    }

    public void testDateField() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "Date Controls", "DateField");
        factory.sleepFirefox(4000);

        DateField dateField = factory.createDateField("dateField1");
        assertNull(dateField.getDateString());
        dateField.setDate("Tue Jul 14 00:00:00 GMT+0400 2009");
        assertEquals(dateField.getDateString(), "Tue Jul 14 00:00:00 GMT+0400 2009");//Wed Apr 12 15:30:17 GMT-0700 2006
        Label selectionLabel = factory.createLabel("selection");
        assertEquals(selectionLabel.getText(), "Date selected: 2009/7/14");
        dateField.setDate("Sat Jul 11 00:00:00 GMT+0400 2009");
        assertEquals(dateField.getDateString(), "Sat Jul 11 00:00:00 GMT+0400 2009");
        assertEquals(selectionLabel.getText(), "Date selected: 2009/7/11");
        //wrong format test
        try {
            dateField.setDate("agsfdgj");
            fail();
        } catch (FunFXException e) {
            assertTrue(e.getMessage().contains("Invalid date format"));
        }
    }

    public void testText() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "Text Controls", "Text");
        factory.sleepFirefox(4000);

        Text text = factory.createText("text_id1");
        assertTrue(text.getText().startsWith("This is a multiline, non-editable text component."));
    }

    public void testAlert() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "General Controls", "Alert");
        factory.sleepFirefox(4000);

        factory.createButton("button_id1").click();
        factory.createAlert().clickButton("OK");
        factory.sleep(500);
        factory.createButton("button_id2").click();
        factory.sleep(500);
        factory.createAlert("Save Changes").clickButton("No");
        factory.sleep(500);
        assertEquals(factory.createLabel("status").getText(), "You answered No");
        factory.createButton("button_id3").click();
        factory.createAlert().clickButton("Green");
    }

    public void testLinkButton() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "Button Controls", "LinkButton");
        factory.sleepFirefox(4000);

        factory.createLinkButton(ObjectLocator.createByAutomationName("LinkButton control")).click();
        factory.createAlert().clickButton("OK");
    }

    public void testHorizontalList() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "General Controls", "HorizontalList");
        factory.sleepFirefox(4000);

        List list = factory.createList("CameraSelection");
        list.selectItem("Nokia 6680");
        assertEquals(list.getSelectedItem(), "Nokia 6680");
    }

    public void testTabBar() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "General Controls", "TabBar");
        factory.sleepFirefox(4000);

        TabBar tabBar = factory.createTabBar("tabbar_id1");
        TextArea textArea = factory.createTextArea("forClick");
        assertEquals(tabBar.getChildrenCount(), 3);
        assertEquals(tabBar.getSelectedIndex(), 0);
        tabBar.selectItem("Alaska");
        assertEquals(tabBar.getSelectedIndex(), 1);
        assertTrue(textArea.getText().startsWith("label is: Alaska, index is: 1"));
        tabBar.selectItem("Arkansas");
        assertEquals(tabBar.getSelectedIndex(), 2);
        assertTrue(textArea.getText().startsWith("label is: Arkansas, index is: 2"));
    }

    public void testMenu() {
        Tree tree = factory.createTree("compLibTree");
        tree.setDelay(1500);
        tree.openAndSelectNode("Visual Components", "Menu Controls", "Menu");
        factory.sleepFirefox(4000);

        factory.createButton("mybutton").click();
        Menu menu = factory.createMenu(ObjectLocator.createByAutomationName("menu_an1"));
        menu.selectItem("MenuItem 2");
        factory.createAlert("Clicked menu item").clickButton("OK");
    }
}
