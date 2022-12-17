package org.drivers;

public enum Devices {

    VIDEOCARD("Display"),
    PROCESSOR("Processor"),
    MOUSE("Mouse");

    private String enumType;

    public String getEnumType() {
        return enumType;
    }

    Devices(String enumType) {
        this.enumType = enumType;
    }
}
