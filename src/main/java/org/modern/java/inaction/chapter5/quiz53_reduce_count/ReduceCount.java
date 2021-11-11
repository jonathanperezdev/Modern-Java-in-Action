package org.modern.java.inaction.chapter5.quiz53_reduce_count;

import org.modern.java.inaction.domain.Menu;

public class ReduceCount {
    public static void main(String args[]){
        //Return count dishes using reduce
        Menu.menu.stream()
                .map(d -> 1).reduce((a,b) -> a+1)
                .ifPresent(System.out::println);

        //Using count approach
        System.out.println(Menu.menu.stream().count());

        //Using parallel stream
        System.out.println(Menu.menu.parallelStream().count());

    }
}
