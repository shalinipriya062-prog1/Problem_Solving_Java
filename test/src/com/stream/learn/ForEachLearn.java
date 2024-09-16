package com.stream.learn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ForEachLearn {
    public static void main(String[] args){
        List<Integer> b = Arrays.asList(4,3,2,7,8,9);
        //b.forEach(l -> System.out.println(l*2));

        //Stream<Integer> c = b.stream();
       // c.forEach(l -> System.out.println(l*2));

        //Stream<Integer> d = b.stream().map(l -> l*2);
        //d.forEach(l -> System.out.println(l));

        //b.stream().map(l-> l*2).forEach(l -> System.out.println(l));

        //b.stream().filter(l -> l%2!=0).sorted().map(l-> l*2).forEach(l -> System.out.println(l));

        int result = b.stream().filter(l -> l%2!=0).sorted().map(l-> l*2).reduce(0, (c,e) -> c+e);
        System.out.println(result);

    }
}
