package org.jfunfx.jsconstruction;

/**
 * date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class ObjectLocator {
    private String id;
    private String automationName;
    private String automationIndex;
    private String automationValue;
    private ObjectLocator parentLocator;

    /*
    {id: {id: 'bookGroupReportPanel'}}
    {id: {automationIndex: 'index:40', automationName: 'Book-Group%20Report', id: 'bookGroupReportPanel'}}
    {id: {automationIndex: 'index:6', automationName: 'cbxBookGroup', automationValue: 'All.Mgmt', id: 'cbxBookGroup'},
     parent: {parent: null, id: {automationIndex: 'index:40', automationName: 'Book-Group%20Report', id: 'bookGroupReportPanel'}}}
    */

    public ObjectLocator(String id) {
        this.id = id;
    }

    public ObjectLocator(String id, String automationName, String automationIndex, String automationValue, ObjectLocator parentLocator) {
        this.id = id;
        this.automationName = automationName;
        this.automationIndex = automationIndex;
        this.automationValue = automationValue;
        this.parentLocator = parentLocator;
    }

    public ObjectLocator(String id, ObjectLocator parentLocator) {
        this(new ObjectLocator(id), parentLocator);
    }

    public ObjectLocator(ObjectLocator locator, ObjectLocator parentLocator) {
        this(locator.getId(), locator.getAutomationName(), locator.getAutomationIndex(), locator.getAutomationValue(), parentLocator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{id: {");
        // parent locator
        if (parentLocator != null) {
            sb.append("parent: ").append(parentLocator.toString()).append(", ");
        }

        sb.append(getAttribute(id, "id"));
        sb.append(getAttribute(automationName, "automationName"));
        sb.append(getAttribute(automationIndex, "automationIndex"));
        sb.append(getAttribute(automationValue, "automationValue"));
        sb.setLength(sb.length() - 2);
        sb.append("}}");

        return sb.toString();
    }

    private String getAttribute(String value, String name) {
        if (value != null) {
            return name + ": " + "'" + value + "', ";
        }
        return "";
    }

    public String getAutomationIndex() {
        return automationIndex;
    }

    public String getAutomationName() {
        return automationName;
    }

    public String getAutomationValue() {
        return automationValue;
    }

    public String getId() {
        return id;
    }

    public ObjectLocator getParentLocator() {
        return parentLocator;
    }

    public static ObjectLocator createByAutomationName(String automationName) {
        return new ObjectLocator(null, automationName, null, null, null);
    }
}
