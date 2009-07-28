package org.jfunfx.jsconstruction.components;

/**
 * date: 28.07.2009
 *
 * @author dlisin
 * @version 1.0
 */
public enum KeyModifierEnum {
    CTRL(1),
    SHIFT(2),
    ALT(4),
    CTRL_SHIFT(3),
    CTRL_ALT(5),
    SHIFT_ALT(6),
    CTRL_SHIFT_ALT(7);

    private int value;

    KeyModifierEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
