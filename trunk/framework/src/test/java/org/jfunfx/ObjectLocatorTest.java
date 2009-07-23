package org.jfunfx;

import junit.framework.TestCase;
import org.jfunfx.jsconstruction.ObjectLocator;

/**
 * date 15.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class ObjectLocatorTest extends TestCase {
    public void test() {
        ObjectLocator objectLocator = new ObjectLocator("login");
        assertEquals(objectLocator.toString(), "{id: {id: 'login'}}");
        objectLocator = new ObjectLocator("bookGroupReportPanel", "Book-Group%20Report", "index:40", null, null);
        assertEquals(objectLocator.toString(),
                     "{id: {id: 'bookGroupReportPanel', automationName: 'Book-Group%20Report', automationIndex: 'index:40'}}");
        ObjectLocator objectLocator2 = new ObjectLocator("cbxBookGroup", "cbxBookGroup", "index:6", "All.Mgmt", objectLocator);
        assertEquals(objectLocator2.toString(),
                     "{id: {parent: {id: {id: 'bookGroupReportPanel', automationName: 'Book-Group%20Report', automationIndex: 'index:40'}}, " +
                         "id: 'cbxBookGroup', automationName: 'cbxBookGroup', automationIndex: 'index:6', automationValue: 'All.Mgmt'}}");
        ObjectLocator objectLocator3 = new ObjectLocator("obl3", objectLocator2);
        assertEquals(objectLocator3.toString(),
                     "{id: {parent: {id: {parent: {id: {id: 'bookGroupReportPanel', automationName: 'Book-Group%20Report', automationIndex: 'index:40'}}, " +
                         "id: 'cbxBookGroup', automationName: 'cbxBookGroup', automationIndex: 'index:6', automationValue: 'All.Mgmt'}}, id: 'obl3'}}");
    }
}
