package
{
import custom.utilities.FlexObjectLocatorUtility;
import custom.utilities.FlexObjectLocatorUtilityHelper;

import flash.display.DisplayObject;
import flash.external.ExternalInterface;

import funfx.flexlocator.FlexObjectLocator;

import mx.automation.IAutomationManager;
import mx.automation.IAutomationObject;
import mx.events.FlexEvent;
import mx.logging.ILogger;
import mx.logging.Log;

/**
 * To make Mixin metadata tag work you should include following line to
 * additional compiler arguments '-includes "AdditionalProxy"'.
 */
[Mixin]
public class AdditionalProxy {
    private var log:ILogger = Log.getLogger("AdditionalProxy");
    private var flexObjectlocator:FlexObjectLocator;

    private static var _root:DisplayObject;

    private static var additionalProxy:AdditionalProxy;

    /**
     *  @private
     */
    public static function init(root:DisplayObject):void {
        if (additionalProxy == null) {
            _root = root;
            root.addEventListener(FlexEvent.APPLICATION_COMPLETE, applicationUpdateCompleteHandler);
        }
    }

    /**
     *  @private
     */
    private static function applicationUpdateCompleteHandler(event:FlexEvent):void {
        _root.removeEventListener(FlexEvent.UPDATE_COMPLETE, applicationUpdateCompleteHandler);
        additionalProxy = new AdditionalProxy();
    }

    public function AdditionalProxy() {
        additionalProxy = this;
        flexObjectlocator = new FlexObjectLocator();
        flexObjectlocator.flexObjectLocatorUtility = new FlexObjectLocatorUtility();
        flexObjectlocator.flexObjectLocatorUtility.flexLocatorhelper = new FlexObjectLocatorUtilityHelper();
        ExternalInterface.addCallback("getFunFXSubPropertyValue", getFunFXSubPropertyValue);
    }

    private function getFunFXSubPropertyValue(locator:Object, fieldName:String, subproperty:String) : String {
        log.debug(Logging.toString("Started finding property", "Locator", Logging.convertLocator(locator), "Property", fieldName));
        if (!automationManager.isSynchronized(null)) {
            log.error("AutomationManager is not synchronized");
            return null;
        }
        try {
            var target:IAutomationObject = flexObjectlocator.findAutomationObject(locator);
            var o:Object = Object(target);
            if (o.hasOwnProperty(fieldName)) {
                if (o[fieldName] == null) {
                    throw new Error("Subproperty not found: " + target + " doesn't have a subproperty named '" +
                                    fieldName + "." + subproperty + "' because property '" + fieldName + "' is null.");
                }
                if (o[fieldName].hasOwnProperty(subproperty)) {
                    return o[fieldName][subproperty];
                }
                log.error(Logging.toString("Subproperty not found",
                        "Property", fieldName,
                        "Subproperty", subproperty,
                        "Target", Logging.createComponentText(target as DisplayObject),
                        "Locator", Logging.convertLocator(locator)));
                throw new Error("Subproperty not found: " + target + " doesn't have a subproperty named '" +
                                fieldName + "." + subproperty + "'");
            } else if (fieldName == "null") {
                if (target == null) return "true";
                return "false";
            } else {
                log.error(Logging.toString("Field not found",
                        "Property", fieldName,
                        "Target", Logging.createComponentText(target as DisplayObject),
                        "Locator", Logging.convertLocator(locator)));
                throw new Error("Field not found: " + target + " doesn't have a field named '" + fieldName + "'");
            }
        } catch(e:Error) {
            return errorMessage(e);
        }
        return null;
    }

    private function errorMessage(e:Error) : String {
        // We have to escape backslashes or else they get interpreted as meta characters on the Ruby side.
        log.error(Logging.toString("FunFX faild", "Error", e.message, "Stacktrace", e.getStackTrace()));

        return "____FUNFX_ERROR:\n" + e.getStackTrace().replace(/\\/gm, "\\\\");
    }

    private function get automationManager():IAutomationManager {
        return AQAdapter.aqAdapter.automationManager;
    }
}
}