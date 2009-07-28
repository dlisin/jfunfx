package org.jfunfx.jsconstruction.components;

/**
 * date: 28.07.2009
 *
 * @author dlisin
 * @version 1.0
 */
public enum ScrollDetailEnum {
    AT_BOTTOM(1),
    AT_LEFT(2),
    AT_RIGHT(3),
    AT_TOP(4),
    LINE_DOWN(5),
    LINE_LEFT(6),
    LINE_RIGHT(7),
    LINE_UP(8),
    PAGE_DOWN(9),
    PAGE_LEFT(10),
    PAGE_RIGHT(11),
    PAGE_UP(12),
    THUMB_POSITION(13),
    THUMB_TRACK(14);

    private int value;

    ScrollDetailEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
