package com.example.makeupkit.Models;

import java.io.IOException;

public enum Category {
    BB_CC, CONCEALER, CONTOUR, CREAM, HIGHLIGHTER, LIQUID, MINERAL, POWDER;

    public String toValue() {
        switch (this) {
            case BB_CC: return "bb_cc";
            case CONCEALER: return "concealer";
            case CONTOUR: return "contour";
            case CREAM: return "cream";
            case HIGHLIGHTER: return "highlighter";
            case LIQUID: return "liquid";
            case MINERAL: return "mineral";
            case POWDER: return "powder";
        }
        return null;
    }

    public static Category forValue(String value) throws IOException {
        if (value.equals("bb_cc")) return BB_CC;
        if (value.equals("concealer")) return CONCEALER;
        if (value.equals("contour")) return CONTOUR;
        if (value.equals("cream")) return CREAM;
        if (value.equals("highlighter")) return HIGHLIGHTER;
        if (value.equals("liquid")) return LIQUID;
        if (value.equals("mineral")) return MINERAL;
        if (value.equals("powder")) return POWDER;
        throw new IOException("Cannot deserialize Category");
    }
}
