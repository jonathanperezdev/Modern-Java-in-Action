package org.modern.java.inaction.quiz21;

import org.modern.java.inaction.quiz21.print.PrintApple;
import org.modern.java.inaction.quiz21.print.PrintHeavyOrLight;
import org.modern.java.inaction.quiz21.print.PrintWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class AppPrintApple {
    public static void main( String[] args ){
        List<Apple> apples = Arrays.asList(new Apple(200), new Apple(80));
        prettyPrintApple(apples, new PrintWeight());
        prettyPrintApple(apples, new PrintHeavyOrLight());
    }

    public static void prettyPrintApple(List<Apple> inventory, PrintApple printApple) {
        for(Apple apple: inventory) {
            String output = printApple.asString(apple);
            System.out.println(output);
        }
    }
}
