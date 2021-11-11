package org.modern.java.inaction.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class PredicateAndOrExample {
    public static void main( String[] args ){
        BiFunction<Integer,String, Apple> appleFunc = Apple::new;
        List<Apple> apples = Arrays.asList(appleFunc.apply(200, "Red"),
                appleFunc.apply(100, "Green"),
                appleFunc.apply(60, "Green"),
                appleFunc.apply(80, "Green"),
                appleFunc.apply(10, "Green"));
        Predicate<Apple> appleFilter = a -> a.getWeight() > 90;
        appleFilter = appleFilter.or(a-> a.getWeight() < 20)
                .and(a-> a.getColor().equalsIgnoreCase("Green"))
                ;

        apples.stream().filter(appleFilter).forEach(System.out::println);
    }
}
