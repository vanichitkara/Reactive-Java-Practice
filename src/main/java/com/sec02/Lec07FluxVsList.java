package com.sec02;

import com.courseUtil.Util;
import com.sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {
    public static void main(String[] args) {
        //List gives a list of names collectively after 5 seconds
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        //Flux gives list of names with an interval of 1 second after each name
        //i.e., as and when the item is ready, the publisher emits it to the subscriber
        NameGenerator.getNames(5)
                .subscribe(Util.onNext());

        //This comparison is more like laundry, List is like folding all clothes and then keeping in almirah
        //Flux is like folding one clothing item and then keeping it in almirah and continue doing this with every item
    }
}
