package {
import flash.display.DisplayObject;

import flash.events.Event;

import flash.events.IEventDispatcher;

import flash.events.KeyboardEvent;
import flash.events.MouseEvent;

import mx.automation.AutomationID;
import mx.automation.AutomationIDPart;
import mx.automation.IAutomationManager;
import mx.automation.IAutomationObject;
import mx.automation.IAutomationObjectHelper;
import mx.automation.IAutomationTabularData;
import mx.automation.events.AutomationReplayEvent;

public class AutomationManagerWrapper implements IAutomationManager, IAutomationObjectHelper {
    private var automationManager:IAutomationManager;
    private var automationManagerObjectHelper:IAutomationObjectHelper;

    public function AutomationManagerWrapper(automationManager:Object) {
        this.automationManager = automationManager as IAutomationManager;
        this.automationManagerObjectHelper = automationManager as IAutomationObjectHelper;
    }

    public function replayKeyDownKeyUp(to:flash.events.IEventDispatcher, keyCode:uint, ctrlKey:Boolean = false, shiftKey:Boolean = false, altKey:Boolean = false):Boolean {
        return automationManagerObjectHelper.replayKeyDownKeyUp(to, keyCode, ctrlKey, shiftKey, altKey);
    }

    public function replayClick(to:flash.events.IEventDispatcher, sourceEvent:flash.events.MouseEvent = null):Boolean {
        return automationManagerObjectHelper.replayClick(to, sourceEvent);
    }

    public function isAutomationComposite(obj:mx.automation.IAutomationObject):Boolean {
        return automationManagerObjectHelper.isAutomationComposite(obj);
    }

    public function helpCreateIDPart(parent:mx.automation.IAutomationObject, child:mx.automation.IAutomationObject, automationNameCallback:Function = null, automationIndexCallback:Function = null):mx.automation.AutomationIDPart {
        return automationManagerObjectHelper.helpCreateIDPart(parent, child, automationNameCallback, automationIndexCallback);
    }

    public function replayKeyboardEvent(to:flash.events.IEventDispatcher, event:flash.events.KeyboardEvent):Boolean {
        return automationManagerObjectHelper.replayKeyboardEvent(to, event);
    }

    public function replayClickOffStage():Boolean {
        return automationManagerObjectHelper.replayClickOffStage();
    }

    public function helpResolveIDPart(parent:mx.automation.IAutomationObject, part:Object):Array {
        return automationManagerObjectHelper.helpResolveIDPart(parent, part);
    }

    public function getAutomationComposite(obj:mx.automation.IAutomationObject):mx.automation.IAutomationObject {
        return automationManagerObjectHelper.getAutomationComposite(obj);
    }

    public function replayMouseEvent(target:flash.events.IEventDispatcher, event:flash.events.MouseEvent):Boolean {
        return automationManagerObjectHelper.replayMouseEvent(target, event);
    }

    public function addSynchronization(isComplete:Function, target:Object = null):void {
        automationManagerObjectHelper.addSynchronization(isComplete, target);
    }

    public function dispatchEvent(event:flash.events.Event):Boolean {
        return automationManager.dispatchEvent(event);
    }

    public function hasEventListener(type:String):Boolean {
        return automationManager.hasEventListener(type);
    }

    public function willTrigger(type:String):Boolean {
        return automationManager.willTrigger(type);
    }

    public function removeEventListener(type:String, listener:Function, useCapture:Boolean = false):void {
        automationManager.removeEventListener(type, listener, useCapture);
    }

    public function addEventListener(type:String, listener:Function, useCapture:Boolean = false, priority:int = 0, useWeakReference:Boolean = false):void {
        automationManager.addEventListener(type, listener, useCapture, priority, useWeakReference);
    }

    public function get recording():Boolean {
        return automationManager.recording;
    }

    public function resolveIDToSingleObject(rid:mx.automation.AutomationID, currentParent:mx.automation.IAutomationObject = null):mx.automation.IAutomationObject {
        return automationManager.resolveIDToSingleObject(rid, currentParent);
    }

    public function resolveIDPartToSingleObject(parent:mx.automation.IAutomationObject, part:mx.automation.AutomationIDPart):mx.automation.IAutomationObject {
        return automationManager.resolveIDPartToSingleObject(parent, part);
    }

    public function resolveID(rid:mx.automation.AutomationID, currentParent:mx.automation.IAutomationObject = null):Array {
        return automationManager.resolveID(rid, currentParent);
    }

    public function beginRecording():void {
        automationManager.beginRecording();
    }

    public function decrementCacheCounter(clearNow:Boolean = false):int {
        return automationManager.decrementCacheCounter(clearNow);
    }

    public function showInHierarchy(obj:mx.automation.IAutomationObject):Boolean {
        return automationManager.showInHierarchy(obj);
    }

    public function getAutomationClassName(obj:mx.automation.IAutomationObject):String {
        return automationManager.getAutomationClassName(obj);
    }

    public function createID(obj:mx.automation.IAutomationObject, relativeToParent:mx.automation.IAutomationObject = null):mx.automation.AutomationID {
        return automationManager.createID(obj, relativeToParent);
    }

    public function resolveIDPart(parent:mx.automation.IAutomationObject, part:mx.automation.AutomationIDPart):Array {
        return automationManager.resolveIDPart(parent, part);
    }

    public function get replaying():Boolean {
        return automationManager.replaying;
    }

    public function endRecording():void {
        automationManager.endRecording();
    }

    public function isSynchronized(target:mx.automation.IAutomationObject):Boolean {
        return automationManager.isSynchronized(target);
    }

    public function getParent(obj:mx.automation.IAutomationObject, parentToStopAt:mx.automation.IAutomationObject = null, ignoreShowInHierarchy:Boolean = false):mx.automation.IAutomationObject {
        return automationManager.getParent(obj, parentToStopAt, ignoreShowInHierarchy);
    }

    public function getElementFromPoint(x:int, y:int):mx.automation.IAutomationObject {
        return automationManager.getElementFromPoint(x, y);
    }

    public function isVisible(obj:flash.display.DisplayObject):Boolean {
        return automationManager.isVisible(obj);
    }

    public function incrementCacheCounter():int {
        return automationManager.incrementCacheCounter();
    }

    public function createIDPart(obj:mx.automation.IAutomationObject, parent:mx.automation.IAutomationObject = null):mx.automation.AutomationIDPart {
        return automationManager.createIDPart(obj, parent);
    }

    public function getChildrenFromIDPart(obj:mx.automation.IAutomationObject, part:mx.automation.AutomationIDPart = null, ignoreShowInHierarchy:Boolean = false):Array {
        return automationManager.getChildrenFromIDPart(obj, part, ignoreShowInHierarchy);
    }

    public function recordAutomatableEvent(recorder:mx.automation.IAutomationObject, event:flash.events.Event, cacheable:Boolean = false):void {
        automationManager.recordAutomatableEvent(recorder, event, cacheable);
    }

    public function getProperties(obj:mx.automation.IAutomationObject, names:Array = null, forVerification:Boolean = true, forDescription:Boolean = true):Array {
        return automationManager.getProperties(obj, names, forVerification, forDescription);
    }

    public function getTabularData(obj:mx.automation.IAutomationObject):mx.automation.IAutomationTabularData {
        return automationManager.getTabularData(obj);
    }

    public function getChildren(obj:mx.automation.IAutomationObject, ignoreShowInHierarchy:Boolean = false):Array {
        return automationManager.getChildren(obj, ignoreShowInHierarchy);
    }

    public function replayAutomatableEvent(event:mx.automation.events.AutomationReplayEvent):Boolean {
        trace("Wrapper: replayAutomatableEvent " + event.toString());
        trace(event.automationObject);
        trace(event.replayableEvent);
        printStackTrace();
        return automationManager.replayAutomatableEvent(event);
    }

    public function set automationEnvironment(env:Object):void {
        automationManager.automationEnvironment = env;
    }

    public function getRectangle(obj:flash.display.DisplayObject):Array {
        return automationManager.getRectangle(obj);
    }

    public function get automationEnvironment():Object {
        return automationManager.automationEnvironment;
    }

    public function getAutomationName(obj:mx.automation.IAutomationObject):String {
        return automationManager.getAutomationName(obj);
    }
    
    public function printStackTrace():void {
        try {
            throw new Error('StackTrace');
        } catch (e:Error) {
            trace(e.getStackTrace());
        }
    }

}
}