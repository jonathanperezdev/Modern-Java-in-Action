package org.modern.java.inaction.chapter5.quiz52_map;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MapSquare {
    public static void main(String args[]){
        //Return the square of numbers map()
        List<Integer> square = Stream.of(1,2,3,4,5).map(n -> n*n).collect(toList());
        square.forEach(System.out::println);
    }
}
