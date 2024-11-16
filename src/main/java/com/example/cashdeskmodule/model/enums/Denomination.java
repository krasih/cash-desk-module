package com.example.cashdeskmodule.model.enums;

public enum Denomination {
    TEN("10"), TWENTY("20"), FIFTY("50");

    private final String value;

    Denomination(String value) {

        this.value = value;
    }

    public static Denomination findByValue(String value) {
        Denomination result = null;

        for (Denomination denomination : values()) {
            if (denomination.value.equals(value)) {
                result = denomination;
                break;
            }
        }
        return result;
    }
}
