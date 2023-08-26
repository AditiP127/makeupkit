package com.example.makeupkit.Models;

import java.io.IOException;

public enum PriceSign {
    EMPTY, PRICE_SIGN;

    public String toValue() {
        switch (this) {
            case EMPTY: return "$";
            case PRICE_SIGN: return "\u00a3";
        }
        return null;
    }

    public static PriceSign forValue(String value) throws IOException {
        if (value.equals("$")) return EMPTY;
        if (value.equals("\u00a3")) return PRICE_SIGN;
        throw new IOException("Cannot deserialize PriceSign");
    }
}
