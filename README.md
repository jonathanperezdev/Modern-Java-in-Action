# Modern-Java-in-Action
Repository with examples of Modern Java in Action Book

## groupingBy Operations
[Theory](https://docs.google.com/document/d/1Nl-01uY2qwOkfeiMySlihSKqqlsS3DFwrofJ-WgGyGY/edit#heading=h.qsat86q2lccq)

### Grouping by Multilevel
You can create Multilevel maps, if you validate next example

```java
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
```
See more examples of groupingBy in next [URL](https://github.com/jonathanperezdev/Modern-Java-in-Action/blob/main/src/main/java/org/modern/java/inaction/chapter6/groupingBy/GroupingByExamples.java)

The resulting structure can be represented as a tree as is shown in next image, but, you can think in this structure as a table, left side of the image

![groupingBy - Multilevel](https://github.com/jonathanperezdev/Modern-Java-in-Action/blob/main/img/groupingBy_Multilevel_map.JPG?raw=true "groupingBy - Multilevel")

