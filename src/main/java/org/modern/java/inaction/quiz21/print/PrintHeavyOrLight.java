package org.modern.java.inaction.quiz21.print;

import org.modern.java.inaction.quiz21.Apple;

public class PrintHeavyOrLight implements PrintApple{
    @Override
    public String asString(Apple apple) {
        return "Apple info: "+apple.toString()+" "+((apple.getWeight()>150)?"Heavy":"Light");
    }
}
