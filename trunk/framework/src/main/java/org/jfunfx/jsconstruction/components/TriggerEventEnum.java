package org.jfunfx.jsconstruction.components;

/**
 * date: 28.07.2009
 *
 * @author dlisin
 * @version 1.0
 */
public enum TriggerEventEnum {
    MOUSE(1),
    KEYBOARD(2);

    private int value;

    TriggerEventEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}