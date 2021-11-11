package org.modern.java.inaction.quiz21.print;

import org.modern.java.inaction.quiz21.Apple;

public class PrintWeight implements PrintApple{
    @Override
    public String asString(Apple apple) {
        return "Weight: "+apple.getWeight();
    }
}
