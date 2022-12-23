package org.modern.java.inaction.chapter8;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class SmallCollectionCreation {
    public static void main(String args[]){
        //This are immutable collection creation
        List<String> animals = List.of("dog","cat","elephant");
        //Means if I add animals.add("bird") throws exception, same for map and set

        Set<String> animalsSet = Set.of("dog","cat","elephant");

        Map<String,String> animalMap = Map.of("key1","dog","key2","cat");
        //You have other option with Maps
        Map<String,String> animalMap2 = Map.ofEntries(
                entry("key1","dog"),
                entry("key2","cat"));

    }
}
