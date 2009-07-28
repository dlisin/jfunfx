package org.jfunfx.jsconstruction.components;

/**
 * date: 28.07.2009
 *
 * @author dlisin
 * @version 1.0
 */
public enum DateChooserDetailEnum {
    NEXT_MONTH(1),
    NEXT_YEAR(2),
    PREVIOUS_MONTH(3),
    PREVIOUS_YEAR(4);

    private int value;

    DateChooserDetailEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}