package org.jfunfx.jsconstruction.components;

/**
 * date: 28.07.2009
 *
 * @author dlisin
 * @version 1.0
 */
public enum ScrolDirectionEnum {
    HORIZONTAL(1),
    VERTICAL(2);

    private int value;

    ScrolDirectionEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}