package org.modern.java.inaction.chapter6.groupingBy;

import org.modern.java.inaction.domain.Dish;
import org.modern.java.inaction.domain.Menu;

import java.util.*;
import java.util.function.Function;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class GroupingByExamples {
    enum CaloricLevel {DIET, NORMAL, FAT}
    public static void main(String[] args){
        //Default groupingBy is key,List this is an example
        Map<Dish.Type, List<Dish>> byDishType = Menu.menu.stream().collect(groupingBy(Dish::getType));

        //Other option is collect the rows belongs to a group in different collection's kinds as set
        Map<Dish.Type, Set<Dish>> byDishTypeSet = Menu.menu.stream().collect(groupingBy(Dish::getType, toSet()));

        //What about an specific implementation of set as HashSet
        Map<Dish.Type, Set<Dish>> byDishTypeHashSet = Menu.menu.stream()
                .collect(groupingBy(Dish::getType, toCollection(HashSet::new)));

        //You can have a multilevel Map, see README.md multilevel map explanation
        Function<Dish, CaloricLevel> caloricLevelFunction = (dish) -> {
            if (dish.getCalories() < 400)
                return CaloricLevel.DIET;
            else if(dish.getCalories() <= 700)
                return CaloricLevel.NORMAL;
            else
                return CaloricLevel.FAT;
        };

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> multiLevel = Menu.menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(caloricLevelFunction)));

        //Now lets see aggregation operations or reducers, is the same concept of sum(), count() of sql
        //Count elements in each group
        Map<Dish.Type, Long> dishNumberByGroup = Menu.menu.stream()
                .collect(groupingBy(Dish::getType, counting()));

        //Total calories by type
        Map<Dish.Type, Integer> dishTotalCaloriesByGroup = Menu.menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        //Get max calories dish in each group
        Map<Dish.Type, Optional<Dish>> maxCaloriesDishOpt = Menu.menu.stream()
                .collect(groupingBy(Dish::getType,
                        maxBy(comparingInt(Dish::getCalories))));

        //But Optional<Dish> is useless cause if we have an empty group, it is not included into the map,
        // so, you can use collectingAndThen collect first and later apply any transformation
        Map<Dish.Type, Dish> maxCaloriesDish = Menu.menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)));

        //You can group and transform
        Map<Dish.Type, List<String>> groupType = Menu.menu.stream().
                collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        //You can filter before perform the groupingBy
        Map<Dish.Type, List<Dish>> groupFilter = Menu.menu.stream()
                .filter(d -> d.getCalories() > 500)
                .collect(groupingBy(Dish::getType));
        //Problem with this you will get {OTHER=[french fries, pizza], MEAT=[pork, beef]}, FISH does not exist
        //So to avoid delete a group without elements you can filter into the group
        Map<Dish.Type, List<Dish>> groupFilterInto = Menu.menu.stream()
                .collect(groupingBy(Dish::getType, filtering(d -> d.getCalories() > 500, toList())));
        //The result will be {OTHER=[french fries, pizza], MEAT=[pork, beef], FISH=[]}
    }
}
