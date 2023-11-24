package com.hangout.core.vendorservice.entities;

public enum Category {
    NATURE(0),
    FOOD(1),
    ENTERTAINMENT(2),
    SPORTS(3);

    private final int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Category valueOf(int value) {
        for (Category category : values()) {
            if (category.getValue() == value) {
                return category;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }

    public static Category getByValue(int value) {
        for (Category category : values()) {
            if (category.getValue() == value) {
                return category;
            }
        }
        throw new IllegalArgumentException("No enum constant with value " + value);
    }
}
