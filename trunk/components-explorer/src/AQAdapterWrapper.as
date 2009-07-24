package {
import funfx.recording.FunFXRecording;

import mx.automation.IAutomationManager;
import mx.automation.IAutomationObject;
import mx.core.UIComponent;

public class AQAdapterWrapper extends AQAdapter {
    private var adapter:AQAdapter;

    public function AQAdapterWrapper(adapter:AQAdapter) {
        super();
        this.adapter = adapter;
    }

    override public function replay(target:IAutomationObject, method:String, args:Array):Object {
        trace("Method:'" + method + "' Args:'", args, "'", "Automation name:'"+target.automationName+"'", 
              "Automation value:'" + target.automationValue + "'", target);
        return adapter.replay(target, method, args);
    }

    override public function get automationManager():IAutomationManager {
        return adapter.automationManager;
    }

    override public function createAutomationID(object:UIComponent):String {
        return adapter.createAutomationID(object);
    }

    /*override public function setCustomTestingEnvironment(te:String):void {
        adapter.setCustomTestingEnvironment(te);
    }*/

    override public function setTestingEnvironment(te:XML):void {
        adapter.setTestingEnvironment(te);
    }

    override public function encodeValue(value:Object,
                                         testingToolType:String,
                                         codecName:String,
                                         relativeParent:IAutomationObject):Object {
        return adapter.encodeValue(value, testingToolType, codecName, relativeParent);
    }

    override public function getPropertyValue(obj:Object,
                                              pd:AQPropertyDescriptor,
                                              relativeParent:IAutomationObject = null):Object {
        return adapter.getPropertyValue(obj, pd, relativeParent);
    }

    override public function encodeProperties(obj:Object,
                                              propertyDescriptors:Array,
                                              interactionReplayer:IAutomationObject):Array {
        return adapter.encodeProperties(obj, propertyDescriptors, interactionReplayer);
    }

    override public function beginRecording():Object {
        return adapter.beginRecording();
    }

    override public function endRecording():Object {
        return adapter.endRecording();
    }

    override public function run(objID:String, method:String, args:String):Object {
        return adapter.run(objID, method, args);
    }

    override public function getPropertyDescriptors(obj:IAutomationObject,
                                                    names:Array = null,
                                                    forVerification:Boolean = true,
                                                    forDescription:Boolean = true):Array {
        return adapter.getPropertyDescriptors(obj, names, forVerification, forDescription);
    }

    override public function getProperties(objID:String, names:String):Object {
        return adapter.getProperties(objID, names);
    }

    override public function getParent(objID:String):Object {
        return adapter.getParent(objID);
    }

    override public function getTabularData(objID:String, begin:uint = 0, end:uint = 0):Object {
        return adapter.getTabularData(objID, begin, end);
    }

    override public function decodeProperties(obj:Object,
                                              args:Array,
                                              propertyDescriptors:Array,
                                              interactionReplayer:IAutomationObject):void {
        adapter.decodeProperties(obj, args, propertyDescriptors, interactionReplayer);
    }

    override public function setPropertyValue(obj:Object,
                                              value:Object,
                                              pd:AQPropertyDescriptor,
                                              relativeParent:IAutomationObject = null):void {
        adapter.setPropertyValue(obj, value, pd, relativeParent);
    }

    override public function getRecords():String {
        return adapter.getRecords();
    }

    override public function get funFXRecorder():FunFXRecording {
        return adapter.funFXRecorder;
    }
}
}