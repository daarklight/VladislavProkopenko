package ru.training.at.hw7jdi.data;

import pages.hw7jdi.entities.MetalColorsData;

public class MetalColors {

    public static MetalColorsData DATA_FIRST = new MetalColorsData().set(m -> {
        m.summary = "1";
        m.elements = "Water";
        m.color = "Red";
        m.metals = "Gold";
        m.vegetables = "Cucumber";
    });


}
