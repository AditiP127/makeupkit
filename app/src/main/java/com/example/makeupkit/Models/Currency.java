package com.example.makeupkit.Models;

import java.io.IOException;

public enum Currency {
    CAD, GBP, USD;

    public String toValue() {
        switch (this) {
            case CAD: return "CAD";
            case GBP: return "GBP";
            case USD: return "USD";
        }
        return null;
    }

    public static Currency forValue(String value) throws IOException {
        if (value.equals("CAD")) return CAD;
        if (value.equals("GBP")) return GBP;
        if (value.equals("USD")) return USD;
        throw new IOException("Cannot deserialize Currency");
    }
}
