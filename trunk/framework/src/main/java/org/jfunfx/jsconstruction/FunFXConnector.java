package org.jfunfx.jsconstruction;

import org.jfunfx.JSExecutor;

/**
 * Connects JFunFX to FunFX with 4 methods shared by ExternalInterface in <CODE>funfx.swc</CODE>.
 * <br/>date 16.07.2009
 *
 * @author dvponomarev
 * @version 1.0
 */
public class FunFXConnector {
    private JSExecutor jsExecutor;
    private String swfId;

    private static final String ARGUMENT_SEPARATOR = "_ARG_SEP_";

    /**
     * @param jsExecutor javascript executor implementation.
     * @param swfId      id of the target SWF.
     */
    FunFXConnector(JSExecutor jsExecutor, String swfId) {
        this.jsExecutor = jsExecutor;
        this.swfId = swfId;
    }

    private String executeJS(String js) throws FunFXException {
        System.out.println(js);
        return jsExecutor.execute(
            "function getFlexApp(appName) {\n" +
                "   if (navigator.appName.indexOf (\"Microsoft\") !=-1) {\n" +
                "       return window[appName];\n" +
                "   } else {\n" +
                "       return document[appName];\n" +
                "   }\n" +
                "};" + (jsExecutor.makeJSreturn() ? "return " : "") + "getFlexApp('" + swfId + "')." + js);
    }

    public String fireEvent(ObjectLocator locator, String event, String... args) throws FunFXException {
        return executeJS("fireFunFXEvent(" + locator.toString() +
            ", '" + event + "', " + "'" + convertArgsToString(args) + "')");
    }

    protected String getPropertyValue(ObjectLocator locator, String property) throws FunFXException {
        return executeJS("getFunFXPropertyValue(" + locator.toString() +
            ", '" + property + "'" + ")");
    }

    protected String getSubPropertyValue(ObjectLocator locator, String property, String subproperty)
        throws FunFXException {
        return executeJS("getFunFXSubPropertyValue(" + locator.toString() +
            ", '" + property + "', '" + subproperty + "')");
    }

    protected String getTabularProperty(ObjectLocator locator, String property)
        throws FunFXException {
        return executeJS("getFunFXTabularPropertyValue(" + locator.toString() +
            ", '" + property + "'" + ")");
    }

    private String convertArgsToString(String... args) {
        if (args == null || args.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg).append(ARGUMENT_SEPARATOR);
        }
        sb.setLength(sb.length() - ARGUMENT_SEPARATOR.length());
        return sb.toString();
    }

    public boolean isFirefox() {
        return getDriverName().contains("Firefox");
    }

    public boolean isInternetExplorer() {
        return getDriverName().contains("Explorer") || getDriverName().contains("IE");
    }

    private String getDriverName() {
        return jsExecutor.getDriverName() == null ? "" : jsExecutor.getDriverName();
    }
}
