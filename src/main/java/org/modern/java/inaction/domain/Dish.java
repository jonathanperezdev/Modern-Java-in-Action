package org.modern.java.inaction.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Dish {
    public enum Type { MEAT, FISH, OTHER }

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
}
